package org.example.behavior.strategy;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class Sorter {
    /*一个可以根据文件大小选择对应排序方法并对文件进行排序的类*/
    private static final long GB = 1024 * 1024 * 1024;
    private static ArrayList<AlgRange> algs = new ArrayList<AlgRange>();

    static {
        File conf = new File("src/main/java/org/example/behavior/strategy/sort.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(conf);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("algRange");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if ( node.getNodeType() == Node.ELEMENT_NODE ){
                    Element element = (Element) node;
                    long start = Long.parseLong(element.getElementsByTagName("range")
                            .item(0).getAttributes().getNamedItem("start").getNodeValue()) * GB;
                    long end = Long.parseLong(element.getElementsByTagName("range")
                            .item(0).getAttributes().getNamedItem("end").getNodeValue()) * GB;
                    String className = element.getElementsByTagName("algClass").item(0).getTextContent();
                    ISortAlg alg = (ISortAlg) Class.forName(className).newInstance();
                    algs.add(new AlgRange(start, end, alg));
                }
            }
        } catch (Exception e) { // 捕获处理所有可能抛出的异常
            e.printStackTrace(); // 打印异常信息
        }

    }


    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg = null;

        for (AlgRange algRange: algs) {
            if (algRange.inRange(fileSize)) {
                sortAlg = algRange.getAlg();
                break;
            }
        }
        assert sortAlg != null;
        sortAlg.sort(filePath);
    }

    private static class AlgRange { // AlgRange需要声明为静态类，因为非静态类需要持有外部类的实例，而AlgRange在外部类的静态代码块中被创建
        private long start;
        private long end;
        private ISortAlg alg;

        public AlgRange(long start, long end, ISortAlg alg) {
            this.start = start;
            this.end = end;
            this.alg = alg;
        }

        public boolean inRange(long fileSize) {
            return fileSize >= start && fileSize < end;
        }

        public ISortAlg getAlg() {
            return alg;
        }
    }

}


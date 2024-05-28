package org.example.behavior.strategy;

import java.io.File;
import java.util.ArrayList;

public class Sorter {
    /*一个可以根据文件大小选择对应排序方法并对文件进行排序的类*/
    private static final long GB = 1024 * 1024 * 1024;
    private static ArrayList<AlgRange> algs = new ArrayList<AlgRange>();

    static {
        algs.add(new AlgRange(0, 6*GB, SortAlgFactory.getSortAlg("QuickSort")));
        algs.add(new AlgRange(6*GB, 10*GB, SortAlgFactory.getSortAlg("ExternalSort")));
        algs.add(new AlgRange(10*GB, 100*GB,SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
        algs.add(new AlgRange(100*GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapreduceSort")));
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


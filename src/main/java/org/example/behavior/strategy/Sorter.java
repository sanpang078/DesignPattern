package org.example.behavior.strategy;

import java.io.File;

public class Sorter {
    /*一个可以根据文件大小选择对应排序方法并对文件进行排序的类*/
    private static final long GB = 1024 * 1024 * 1024;

    public File createFile(String filePath) {
        File file = new File(filePath);
        return file;
    }
    public void sortFile(File file) {
        long fileSize = file.length();
        if ( fileSize < 6 * GB ) {
            quickSort(file);
        } else if ( fileSize < 10 * GB) {
            externalSort(file);
        } else if (fileSize < 100 * GB) {
            concurrentExternalSort(file);
        } else {
            mapreduceSort(file);
        }
    }

    public void sortFile(String filePath) {
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg;
        if ( fileSize < 6 * GB ) {
            sortAlg = SortAlgFactory.getSortAlg("QuickSort");
        } else if ( fileSize < 10 * GB) {
            sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
        } else if (fileSize < 100 * GB) {
            sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        } else {
            sortAlg = SortAlgFactory.getSortAlg("MapreduceSort");
        }
        sortAlg.sort(filePath);
    }

    private void mapreduceSort(File file) {
        System.out.println("mapreduce排序");
    }

    private void concurrentExternalSort(File file) {
        System.out.println("多线程外部排序");
    }

    private void externalSort(File file) {
        System.out.println("外部排序");
    }

    private void quickSort(File file) {
        System.out.println("快速排序");
    }


}

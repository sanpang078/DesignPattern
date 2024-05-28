package org.example.behavior.strategy;

public class ConcurrentExternalSort implements ISortAlg{
    public void sort(String filePath) {
        System.out.println("多线程外部排序");
    }
}

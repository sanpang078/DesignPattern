package org.example.behavior.strategy;

import java.io.File;

public class SorterTest {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        File file = new SubFile("C:\\Users\\Admin\\Desktop\\xxx项目文档.docx");
        sorter.sortFile(file);
    }
}

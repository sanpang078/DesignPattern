package org.example.behavior.strategy;

import java.io.File;

public class SubFile extends File {
    public SubFile(String pathname) {
        super(pathname);
    }

    @Override
    public long length() {
        return 120L * 1024 * 1024 * 1024;
    }
}

package org.example.structure.proxy.rpc.server;

public class CaculatorServiceImpl implements CaculatorService{

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}

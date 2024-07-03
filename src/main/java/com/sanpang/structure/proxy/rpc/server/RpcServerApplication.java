package com.sanpang.structure.proxy.rpc.server;

import com.sanpang.structure.proxy.rpc.RpcServer;

public class RpcServerApplication {
    public static void main(String[] args) throws Exception {
        CaculatorService service = new CaculatorServiceImpl();
        RpcServer server = new RpcServer();
        server.export(service, 1234);
    }
}

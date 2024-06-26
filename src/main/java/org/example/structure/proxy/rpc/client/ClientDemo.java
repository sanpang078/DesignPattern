package org.example.structure.proxy.rpc.client;

import org.example.structure.proxy.rpc.RpcClient;

public class ClientDemo {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CaculatorService service = client.refer(CaculatorService.class, "127.0.0.1", 1234);
        int result = service.add(2, 4);
        System.out.println("result: " + result);

    }
}

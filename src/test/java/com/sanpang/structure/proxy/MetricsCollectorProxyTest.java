package com.sanpang.structure.proxy;

public class MetricsCollectorProxyTest {
    public static void main(String[] args) {
        MetricsCollectorProxy proxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) proxy.createProxy(new UserController());
        userController.register("111122223333","sanpang");

    }
}

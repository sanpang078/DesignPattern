package com.sanpang.behavior.observer;

import java.util.Random;

public class UserServer {
    public Long register(String telephone, String password) {
        System.out.println("注册用户成功");
        return new Random().nextLong();
    }
}

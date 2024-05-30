package org.example.behavior.observer;

import java.util.Random;

public class UserServer {
    public Long register(String telephone, String password) {

        return new Random().nextLong();
    }
}

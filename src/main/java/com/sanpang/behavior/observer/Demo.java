package com.sanpang.behavior.observer;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Object> observers = new ArrayList<Object>();
        observers.add(new RegNotificationObserver(new NotificationService()));
        observers.add(new RegPromotionObserver(new PromotionService()));
        UserController userController = new UserController(new UserServer());
        userController.setRegObservers(observers);
        Long userId = userController.register("15088889999", "1234");
        System.out.println(userId);


    }
}

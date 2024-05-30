package org.example.behavior.observer;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<IRegObserver> observers = new ArrayList<IRegObserver>();
        observers.add(new RegNotificationObserver(new NotificationService()));
        observers.add(new RegPromotionObserver(new PromotionService()));
        UserController userController = new UserController(new UserServer());
        userController.setRegObservers(observers);
        userController.register("15088889999", "1234");
    }
}

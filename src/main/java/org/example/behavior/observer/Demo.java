package org.example.behavior.observer;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        ArrayList<IRegObserver> observers = new ArrayList<IRegObserver>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        observers.add(new RegNotificationObserver(new NotificationService()));
        observers.add(new RegPromotionObserver(new PromotionService()));
        UserController userController = new UserController(new UserServer(), executor);
        userController.setRegObservers(observers);
        Long userId = userController.register("15088889999", "1234");
        System.out.println(userId);
    }
}

package org.example.behavior.observer;

import com.google.common.base.Preconditions;
import org.example.behavior.observer.eventbus.Subscribe;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

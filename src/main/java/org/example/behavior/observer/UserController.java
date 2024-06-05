package org.example.behavior.observer;

//import com.google.common.eventbus.AsyncEventBus;
import org.example.behavior.observer.eventbus.AsyncEventBus;
import org.example.behavior.observer.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class UserController {
    private UserServer userServer;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 3;
    private EventBus eventBus;

    public UserController(UserServer userServer){
        this.userServer = userServer;
        //this.eventBus = new EventBus(); //同步阻塞模式
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers){
        for (Object observer: observers) {
            eventBus.registry(observer);
        }

    }

    public Long register(String telephone, String password){
        final long userId = userServer.register(telephone, password);
        eventBus.post(userId);
        return userId;
    }
}

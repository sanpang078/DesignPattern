package org.example.behavior.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class UserController {
    private UserServer userServer;
    private List<IRegObserver> regObservers = new ArrayList<IRegObserver>();
    private ThreadPoolExecutor executor;

    public UserController(UserServer userServer, ThreadPoolExecutor executor){
        this.userServer = userServer;
        this.executor = executor;
    }

    public void setRegObservers(List<IRegObserver> observers){
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password){
        final long userId = userServer.register(telephone, password);
        for (final IRegObserver regObserver: regObservers) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    regObserver.handleRegSuccess(userId);
                }
            });

        }
        return userId;
    }
}

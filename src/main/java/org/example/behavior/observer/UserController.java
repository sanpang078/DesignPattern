package org.example.behavior.observer;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private UserServer userServer;
    private List<IRegObserver> regObservers = new ArrayList<IRegObserver>();

    public UserController(UserServer userServer){
        this.userServer = userServer;
    }

    public void setRegObservers(List<IRegObserver> observers){
        regObservers.addAll(observers);
    }

    public Long register(String telephone, String password){
        long userId = userServer.register(telephone, password);
        for (IRegObserver regObserver: regObservers) {
            regObserver.handleRegSuccess(userId);
        }
        return userId;
    }
}

package com.sanpang.behavior.observer.eventbus;

import java.util.List;
import java.util.concurrent.Executor;


import com.google.common.util.concurrent.MoreExecutors;

public class EventBus {
    private Executor executor;
    private ObserverRegistry observerRegistry = new ObserverRegistry();

    public EventBus() { this(MoreExecutors.directExecutor());}

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void registry(Object object){
        observerRegistry.registry(object);
    }

    public void post(final Object event) {
        List<ObserverAction> observerActions = observerRegistry.getMatchedObserverActions(event);
        for (final ObserverAction observerAction: observerActions){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }

}

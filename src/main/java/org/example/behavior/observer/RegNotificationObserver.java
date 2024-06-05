package org.example.behavior.observer;

import org.example.behavior.observer.eventbus.Subscribe;

public class RegNotificationObserver {
    NotificationService notificationService;
    public RegNotificationObserver(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @Subscribe
    public void handleRegSuccess(final Long userId) {

        notificationService.sendInboxMessage(userId, "Welcome to ...");

    }
}

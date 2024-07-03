package com.sanpang.behavior.observer;

import com.sanpang.behavior.observer.eventbus.Subscribe;

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

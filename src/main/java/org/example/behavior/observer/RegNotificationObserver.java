package org.example.behavior.observer;

public class RegNotificationObserver implements IRegObserver{
    NotificationService notificationService;
    public RegNotificationObserver(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @Override
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "Welcome to ...");
    }
}

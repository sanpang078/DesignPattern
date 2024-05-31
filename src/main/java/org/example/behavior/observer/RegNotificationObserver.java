package org.example.behavior.observer;

public class RegNotificationObserver implements IRegObserver{
    NotificationService notificationService;
    public RegNotificationObserver(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @Override
    public void handleRegSuccess(final Long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                notificationService.sendInboxMessage(userId, "Welcome to ...");
            }
        });
        thread.start();
    }
}

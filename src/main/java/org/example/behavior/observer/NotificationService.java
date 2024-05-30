package org.example.behavior.observer;

public class NotificationService {
    public void sendInboxMessage(long userId, String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = "hello " + userId + ", " + s;
        System.out.println(msg);
    }
}

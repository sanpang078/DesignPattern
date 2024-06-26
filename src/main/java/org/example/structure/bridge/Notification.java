package org.example.structure.bridge;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    private List<NotificationHandler> handlers = new ArrayList<>();

    public void addNotificationHandler(NotificationHandler handler) {
        handlers.add(handler);
    }


    public void notify(NotificationEmergencyLevel level, String message){
        for (NotificationHandler handler: handlers) {
            handler.handle(level, message);
        }
    }

}

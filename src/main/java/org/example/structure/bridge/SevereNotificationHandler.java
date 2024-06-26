package org.example.structure.bridge;

import java.util.List;

public class SevereNotificationHandler extends NotificationHandler{
    private MsgSender msgSender;

    public SevereNotificationHandler(MsgSender msgSender){
        super(msgSender);
    }

    public void handle(NotificationEmergencyLevel level ,String message) {
        if (level.equals(NotificationEmergencyLevel.SEVERE)) {
            msgSender.send(message);
        }
    }

}

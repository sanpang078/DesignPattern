package org.example.structure.bridge;

import java.util.List;

public class UgencyWechatNotificationHandler extends NotificationHandler{
    private MsgSender msgSender;

    public UgencyWechatNotificationHandler(MsgSender msgSender){
        super(msgSender);
    }

    public void handle(NotificationEmergencyLevel level ,String message) {
        if (level.equals(NotificationEmergencyLevel.URGENCY)) {
            msgSender.send(message);
        }
    }

}

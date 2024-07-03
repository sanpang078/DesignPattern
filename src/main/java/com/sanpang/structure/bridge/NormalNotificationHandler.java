package com.sanpang.structure.bridge;

public class NormalNotificationHandler extends NotificationHandler{
    private MsgSender msgSender;

    public NormalNotificationHandler( MsgSender msgSender){
        super(msgSender);
    }

    public void handle(NotificationEmergencyLevel level ,String message) {
        if (level.equals(NotificationEmergencyLevel.NORMAL)) {
            msgSender.send(message);
        }
    }

}

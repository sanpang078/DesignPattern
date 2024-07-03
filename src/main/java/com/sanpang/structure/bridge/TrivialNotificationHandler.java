package com.sanpang.structure.bridge;

public class TrivialNotificationHandler extends NotificationHandler{
    private MsgSender msgSender;

    public TrivialNotificationHandler(MsgSender msgSender){
        super(msgSender);
    }

    public void handle(NotificationEmergencyLevel level ,String message) {
        if (level.equals(NotificationEmergencyLevel.TRIVIAL)) {
            msgSender.send(message);
        }
    }

}

package com.sanpang.structure.bridge;

public abstract class NotificationHandler {
    private MsgSender msgSender;

    public NotificationHandler(MsgSender msgSender){
        this.msgSender = msgSender;
    }
    public  abstract void handle(NotificationEmergencyLevel level ,String message);
}

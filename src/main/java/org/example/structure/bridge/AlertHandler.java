package org.example.structure.bridge;

public abstract class AlertHandler {
    AlertRule rule;
    Notification notification;
    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    public abstract void handle(ApiStatInfo apiStatInfo);

}

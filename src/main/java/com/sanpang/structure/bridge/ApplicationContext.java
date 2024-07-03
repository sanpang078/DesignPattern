package com.sanpang.structure.bridge;

public class ApplicationContext {
    private AlertRule rule;
    private Notification notification;
    private Alert alert;

    private static final ApplicationContext instance = new ApplicationContext();


    private ApplicationContext() {
        initializeBeans();
    }

    private void initializeBeans() {
        this.rule = new AlertRule();
        this.notification = new Notification();
        this.alert = new Alert();
        alert.addAlertHandler(new ErrorAlertHandler(rule, notification));
        alert.addAlertHandler(new TpsAlertHandler(rule, notification));
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public Alert getAlert() {
        return this.alert;
    }
}

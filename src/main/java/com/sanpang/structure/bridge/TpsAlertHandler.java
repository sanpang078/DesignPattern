package com.sanpang.structure.bridge;

public class TpsAlertHandler extends AlertHandler {
    private AlertRule rule;
    private Notification notification;

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    public void handle(ApiStatInfo apiStatInfo) {
        String api = apiStatInfo.getApi();
        long tps = apiStatInfo.getRequestCount() / apiStatInfo.getDurationOfSeconds();
        if ( tps > rule.getMatachedRule(api).getMaxTps() ) {
            notification.notify(NotificationEmergencyLevel.URGENCY, "...");
        }
    }


}

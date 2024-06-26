package org.example.structure.bridge;

import javafx.scene.control.Alert;

public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void handle(ApiStatInfo apiStatInfo) {
        String api = apiStatInfo.getApi();
        if ( apiStatInfo.getErrorCount() > rule.getMatachedRule(api).getMaxErrorCount() ) {
            notification.notify(NotificationEmergencyLevel.SEVERE, "...");
        }
    }

}

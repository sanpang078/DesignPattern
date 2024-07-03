package com.sanpang.structure.bridge;

import java.util.ArrayList;
import java.util.List;

public class Alert {
    private List<AlertHandler> handlers = new ArrayList<>();

    public void addAlertHandler(AlertHandler alertHandler) {
        this.handlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo){
        for (AlertHandler handler: handlers) {
            handler.handle(apiStatInfo);
        }
    }
}

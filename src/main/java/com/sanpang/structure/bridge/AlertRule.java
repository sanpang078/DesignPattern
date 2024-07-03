package com.sanpang.structure.bridge;

import java.util.Map;

public class AlertRule {
    private Map<String, RuleEntry> apiRules;

    public  RuleEntry getMatachedRule(String api) {
        return apiRules.get(api);
    }


}

class RuleEntry{
    private String api;
    private int maxErrorCount;
    private int maxTps;

    public RuleEntry(String api, int maxErrorCount, int maxTps){
        this.api = api;
        this.maxErrorCount = maxErrorCount;
        this.maxTps = maxTps;
    }

    public int getMaxErrorCount() {
        return maxErrorCount;
    }

    public int getMaxTps() {
        return maxTps;
    }
}
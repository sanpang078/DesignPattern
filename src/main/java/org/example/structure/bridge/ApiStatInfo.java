package org.example.structure.bridge;

public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long durationOfSeconds;

    private long ErrorCount;

    public String getApi() {
        return api;
    }

    public long getRequestCount() {
        return this.requestCount;
    }

    public long getDurationOfSeconds() {
        return this.durationOfSeconds;
    }

    public long getErrorCount() {
        return this.ErrorCount;
    }

}

package com.fanzibang.structural.proxy.entity;

public class RequestInfo {

    private String method;

    private long responseTime;

    private long startTime;

    public RequestInfo() {}

    public RequestInfo(String method, long responseTime, long startTime) {
        this.method = method;
        this.responseTime = responseTime;
        this.startTime = startTime;
    }
}

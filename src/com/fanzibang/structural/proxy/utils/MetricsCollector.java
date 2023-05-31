package com.fanzibang.structural.proxy.utils;

import com.fanzibang.structural.proxy.entity.RequestInfo;

public class MetricsCollector {


    public void recordRequest(RequestInfo requestInfo) {
        System.out.println("recordRequest:" + requestInfo);
    }

}

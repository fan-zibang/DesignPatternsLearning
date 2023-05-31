package com.fanzibang.structural.proxy.dynamicProxy;

import com.fanzibang.structural.proxy.entity.RequestInfo;
import com.fanzibang.structural.proxy.utils.MetricsCollector;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * MetricsCollectorProxy 作为一个动态代理类，
 * 动态地给每个需要收集接口请求信息的类创建代理类。
 */
public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object target) {
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), dynamicProxyHandler);
    }


    private class DynamicProxyHandler implements InvocationHandler {
        // 代理类中的真实对象
        private Object target;
        public
        DynamicProxyHandler(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTime = System.currentTimeMillis();
            Object invoke = method.invoke(target    , args);
            long endTime = System.currentTimeMillis();
            long responseTime = endTime - startTime;
            String apiName = target.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTime);
            metricsCollector.recordRequest(requestInfo);
            return invoke;
        }
    }
}

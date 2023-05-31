package com.fanzibang.structural.proxy;

import com.fanzibang.structural.proxy.dynamicProxy.MetricsCollectorProxy;
import com.fanzibang.structural.proxy.staticProxy.UserController;
import com.fanzibang.structural.proxy.staticProxy.UserControllerProxyV1;
import com.fanzibang.structural.proxy.staticProxy.UserControllerProxyV2;

public class Application {

    public static void main(String[] args) {
        IUserController proxyV1 = new UserControllerProxyV1(new UserController());
        proxyV1.login("admin", "123");

        UserControllerProxyV2 proxyV2 = new UserControllerProxyV2();
        proxyV2.login("admin", "123");

        MetricsCollectorProxy metricsCollectorProxy = new MetricsCollectorProxy();
        IUserController userController = (IUserController) metricsCollectorProxy.createProxy(new com.fanzibang.structural.proxy.dynamicProxy.UserController());
        userController.login("admin", "123");
    }
}

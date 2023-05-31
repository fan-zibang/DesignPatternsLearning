package com.fanzibang.structural.proxy.staticProxy;

import com.fanzibang.structural.proxy.entity.RequestInfo;
import com.fanzibang.structural.proxy.utils.MetricsCollector;
import com.fanzibang.structural.proxy.vo.UserVO;

/**
 * 解决 V1：
 * 让代理类继承原始类,然后扩展附加功能。
 *
 * 缺点：
 * 1.我们需要在代理类中，将原始类中的所有方法，都重新实现一遍，
 * 并且每个方法都附加相似的逻辑。
 * 2.如果要添加的附加功能的类不止一个，我们需要为每个类都创建一个代理类。
 * 导致项目中类的个数大量增多，增加了维护代码的成本。
 */
public class UserControllerProxyV2 extends UserController{

    private MetricsCollector metricsCollector;

    public UserControllerProxyV2() {
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVO login(String username, String password) {
        long startTime = System.currentTimeMillis();
        UserVO userVO = super.login(username, password);
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);
        return userVO;
    }
}

package com.fanzibang.structural.proxy.staticProxy;

import com.fanzibang.structural.proxy.IUserController;
import com.fanzibang.structural.proxy.entity.RequestInfo;
import com.fanzibang.structural.proxy.utils.MetricsCollector;
import com.fanzibang.structural.proxy.vo.UserVO;

/**
 * UserControllerProxy 类负责在业务代码执行前后附加其他逻辑代码，并通过委托的方式调用原始类来执行业务代码
 * 基于接口而非实现编程的设计思想，将原始类对象替换为代理类对象的时候，
 * 为了让代码改动尽量少，代理类和原始类需要实现相同的接口。
 *
 * 缺点：
 * 如果原始类并没有定义接口，并且原始类不是我们开发维护的，
 * 比如它是一个第三方类库，我们没有办法直接修改原始类，给它重新定义一个接口
 */
public class UserControllerProxyV1 implements IUserController {

    private MetricsCollector metricsCollector;

    private UserController userController;

    public UserControllerProxyV1(UserController userController) {
        this.userController = userController;
        this.metricsCollector = new MetricsCollector();
    }

    @Override
    public UserVO login(String username, String password) {
        long startTime = System.currentTimeMillis();
        // 委托
        UserVO userVO = userController.login(username, password);
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);
        return userVO;
    }
}

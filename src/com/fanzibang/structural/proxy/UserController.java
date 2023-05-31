package com.fanzibang.structural.proxy;

import com.fanzibang.structural.proxy.entity.RequestInfo;
import com.fanzibang.structural.proxy.utils.MetricsCollector;
import com.fanzibang.structural.proxy.vo.UserVO;

/**
 * 缺点：
 * 1.统计登录逻辑耗时的代码侵入到业务代码中，跟业务代码高度耦合。
 * 如果未来需要替换这个耗时代码，替换的成本会比较大。
 * 2.收集接口请求的代码跟业务代码无关，不应该放到一个类中。
 * 业务类最好符合单一职责原则，只聚焦业务处理。
 */
public class UserController {

    // 依赖注入
    private MetricsCollector metricsCollector;

    public UserVO login(String username, String password) {
        long startTime = System.currentTimeMillis();

        // ...省略登录逻辑

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;
        RequestInfo requestInfo = new RequestInfo("login", responseTime, startTime);
        metricsCollector.recordRequest(requestInfo);

        // 返回 UserVo
        return new UserVO(username, password);
    }
}

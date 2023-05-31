package com.fanzibang.structural.proxy.dynamicProxy;

import com.fanzibang.structural.proxy.IUserController;
import com.fanzibang.structural.proxy.vo.UserVO;

/**
 * UserController 类只负责业务功能
 * 基于接口而非实现编程的设计思想，将原始类对象替换为代理类对象的时候，
 * 为了让代码改动尽量少，代理类和原始类需要实现相同的接口。
 */
public class UserController implements IUserController {

    @Override
    public UserVO login(String username, String password) {
        // ...省略登录逻辑
        return new UserVO(username, password);
    }

}

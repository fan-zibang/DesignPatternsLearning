package com.fanzibang.structural.proxy;

import com.fanzibang.structural.proxy.vo.UserVO;

public interface IUserController {

    UserVO login(String username, String password);
}

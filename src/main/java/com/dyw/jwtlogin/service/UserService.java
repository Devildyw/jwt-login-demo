package com.dyw.jwtlogin.service;

import com.dyw.jwtlogin.entity.User;
import com.dyw.jwtlogin.param.PageParam;
import org.cuit.epoch.result.Result;

import java.util.List;

/**
 * @author Devil
 * @create 2022-04-03 16:24
 */
public interface UserService {
    Result<List<User>> list(PageParam pageParam);
}

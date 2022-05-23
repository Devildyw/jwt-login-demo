package com.example.jwtlogin.service;

import com.example.jwtlogin.entity.User;
import com.example.jwtlogin.param.PageParam;
import org.cuit.epoch.result.Result;

import java.util.List;

/**
 * @author Devil
 * @create 2022-04-03 16:24
 */
public interface UserService {
    Result<List<User>> list(PageParam pageParam);
}

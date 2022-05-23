package com.example.jwtlogin.service;

import com.example.jwtlogin.param.RegisterParam;
import org.cuit.epoch.result.Result;

/**
 * @author Devil
 * @create 2022-04-03 16:03
 */
public interface LoginService {
    Result<String> login(RegisterParam registerParam);
}

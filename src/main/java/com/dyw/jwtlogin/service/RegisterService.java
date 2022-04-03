package com.dyw.jwtlogin.service;

import com.dyw.jwtlogin.param.RegisterParam;
import org.cuit.epoch.result.Result;

/**
 * @author Devil
 * @create 2022-04-03 16:03
 */
public interface RegisterService {
    Result<String> register(RegisterParam registerParam);
}

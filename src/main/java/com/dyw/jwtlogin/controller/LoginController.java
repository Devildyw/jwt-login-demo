package com.dyw.jwtlogin.controller;

import com.dyw.jwtlogin.param.RegisterParam;
import com.dyw.jwtlogin.service.LoginService;
import org.cuit.epoch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @create 2022-04-03 16:01
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping
    public Result<String> login(@RequestBody RegisterParam registerParam){
        return loginService.login(registerParam);
    }
}

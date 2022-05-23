package com.example.jwtlogin.controller;

import com.example.jwtlogin.param.RegisterParam;
import com.example.jwtlogin.service.RegisterService;
import org.cuit.epoch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Devil
 * @create 2022-04-03 16:02
 */
@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping
    public Result<String> register(@RequestBody RegisterParam registerParam){
        return registerService.register(registerParam);
    }
}

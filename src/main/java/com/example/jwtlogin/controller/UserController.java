package com.example.jwtlogin.controller;

import com.example.jwtlogin.entity.User;
import com.example.jwtlogin.param.PageParam;
import com.example.jwtlogin.service.UserService;
import org.cuit.epoch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Devil
 * @create 2022-04-03 16:22
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("list")
    public Result<List<User>> list(@RequestBody PageParam pageParam){
       return userService.list(pageParam);
    }

}

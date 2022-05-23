package com.example.jwtlogin.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.jwtlogin.entity.User;
import com.example.jwtlogin.mapper.UserMapper;
import com.example.jwtlogin.param.RegisterParam;
import com.example.jwtlogin.service.RegisterService;
import org.cuit.epoch.result.R;
import org.cuit.epoch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

/**
 * @author Devil
 * @create 2022-04-03 16:04
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    private static final String SALT = "DevilDyw_Salt##$$";
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result<String> register(RegisterParam registerParam) {
        String username = registerParam.getUsername();
        String password = registerParam.getPassword();
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername,username).last("limit 1");
        if (userMapper.selectOne(userLambdaQueryWrapper)!=null){
            return R.fail("该用户名以被使用");
        }
        MD5 md5 = new MD5(SALT.getBytes(StandardCharsets.UTF_8));
        password = md5.digestHex(password, "UTF-8");

        User user = new User(null, username, password, null, null);
        int insert = userMapper.insert(user);
        if(insert<=0){
            return R.fail("注册失败");
        }
        return R.success("注册成功");
    }
}

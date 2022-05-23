package com.example.jwtlogin.service.impl;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.jwtlogin.entity.User;
import com.example.jwtlogin.mapper.UserMapper;
import com.example.jwtlogin.param.RegisterParam;
import com.example.jwtlogin.service.LoginService;
import com.example.jwtlogin.utils.JwtUtil;
import org.cuit.epoch.result.R;
import org.cuit.epoch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @author Devil
 * @create 2022-04-03 16:03
 */
@Service
public class LoginServiceImpl implements LoginService {
    private static final String SALT = "DevilDyw_Salt##$$";
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    @Override
    public Result<String> login(RegisterParam registerParam) {
        String password = registerParam.getPassword();
        String username = registerParam.getUsername();

        MD5 md5 = new MD5(SALT.getBytes(StandardCharsets.UTF_8));
        password = md5.digestHex(password, "UTF-8");
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<User>();
        userLambdaQueryWrapper.select(User::getUsername,User::getId);
        userLambdaQueryWrapper.eq(User::getUsername,username).eq(User::getPassword,password).last("limit 1");
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        if( user==null){
            return R.fail("登录失败 用户名或密码错误");
        }
        //生成jwt
        String token = JwtUtil.generateToken(user.getId());
        //存入redis
        stringRedisTemplate.opsForValue().set("token_"+token,JSONUtil.toJsonStr(user),1,TimeUnit.HOURS);
        return R.success(token);
    }
}

package com.dyw.jwtlogin;

import com.dyw.jwtlogin.entity.User;
import com.dyw.jwtlogin.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwtLoginApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user = new User(null, "123456", "123456", null, null);
        int insert = userMapper.insert(user);
        System.out.println(insert>0);
    }
}

package com.dyw.jwtlogin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyw.jwtlogin.entity.User;
import com.dyw.jwtlogin.mapper.UserMapper;
import com.dyw.jwtlogin.param.PageParam;
import com.dyw.jwtlogin.service.UserService;
import org.cuit.epoch.result.R;
import org.cuit.epoch.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Devil
 * @create 2022-04-03 16:24
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result<List<User>> list(PageParam pageParam) {
        Integer currentPage = pageParam.getCurrentPage();
        Integer pageSize = pageParam.getPageSize();

        IPage<User> page = new Page<>();
        page.setCurrent(currentPage);
        page.setSize(pageSize);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.orderBy(true,false,User::getId);
        IPage<User> page1 = userMapper.selectPage(page, userLambdaQueryWrapper);
        List<User> records = page1.getRecords();

        Result<List<User>> success = R.success(records);
        return success;
    }
}

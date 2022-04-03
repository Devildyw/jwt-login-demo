package com.dyw.jwtlogin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyw.jwtlogin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Devil
 * @create 2022-04-03 15:58
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

package com.dyw.jwtlogin.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Devil
 * @create 2022-04-03 16:11
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),metaObject);
    }
}

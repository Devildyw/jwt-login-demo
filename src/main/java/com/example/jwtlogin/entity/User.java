package com.example.jwtlogin.entity;

import com.baomidou.mybatisplus.annotation.*;

/**
 * @author Devil
 * @create 2022-04-03 15:43
 */
@TableName(autoResultMap = true)
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public User(Integer id, String username, String password, String updateTime, String createTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public User() {
    }

    private String username;

    private String password;
    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
}

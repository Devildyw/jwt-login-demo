package com.dyw.jwtlogin.param;

/**
 * @author Devil
 * @create 2022-04-03 16:44
 */
public class RegisterParam {
    private String username;

    private String password;

    @Override
    public String toString() {
        return "RegisterParam{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterParam() {
    }

    public RegisterParam(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

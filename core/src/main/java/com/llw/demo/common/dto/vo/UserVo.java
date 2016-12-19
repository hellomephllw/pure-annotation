package com.llw.demo.common.dto.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @discription: 用户视图对象或值对象
 * @author: llw
 * @date: 2016-11-26
 */
public class UserVo {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

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

    @Override
    public String toString() {
        return "UserVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

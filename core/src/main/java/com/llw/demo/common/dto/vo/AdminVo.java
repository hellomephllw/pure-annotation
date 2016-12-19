package com.llw.demo.common.dto.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @discription: 管理员视图对象或值对象
 * @author: llw
 * @date: 2016-11-26
 */
public class AdminVo {

    @ApiModelProperty(value = "权限")
    private String auth;

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "auth='" + auth + '\'' +
                '}';
    }

}

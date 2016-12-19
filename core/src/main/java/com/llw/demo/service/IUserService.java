package com.llw.demo.service;

/**
 * @discription: 用户服务
 * @author: llw
 * @date: 2016-11-17
 */
public interface IUserService {

    /**
     * 用户登陆服务
     * @param username 用户名
     * @param password 密码
     * @return 是否登陆成功
     * @throws Exception
     */
    boolean login(String username, String password) throws Exception;

}

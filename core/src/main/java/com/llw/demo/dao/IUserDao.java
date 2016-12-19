package com.llw.demo.dao;

import com.llw.demo.model.User;

/**
 * @discription: User持久层接口
 * @author: llw
 * @date: 2016-11-17
 */
public interface IUserDao {

    /**
     * 根据username获取user
     * @param username 用户名
     * @return 用户
     * @throws Exception
     */
    User findUserByUsername(String username) throws Exception;

}

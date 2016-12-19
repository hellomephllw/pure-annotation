package com.llw.demo.service.impl;

import com.llw.demo.dao.IUserDao;
import com.llw.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @discription: 用户服务实现
 * @author: llw
 * @date: 2016-11-18
 */
@Transactional
@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public boolean login(String username, String password) throws Exception {
        System.out.println("entry userService");

        userDao.findUserByUsername(username);

        return false;
    }
}

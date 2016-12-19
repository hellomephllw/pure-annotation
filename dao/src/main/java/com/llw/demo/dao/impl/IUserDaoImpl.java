package com.llw.demo.dao.impl;

import com.llw.demo.common.base.BaseHibernateDao;
import com.llw.demo.dao.IUserDao;
import com.llw.demo.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @discription: 用户持久层实现
 * @author: llw
 * @date: 2016-11-18
 */
@Repository
public class IUserDaoImpl extends BaseHibernateDao<User> implements IUserDao {

    @Override
    public User findUserByUsername(String username) throws Exception {
        System.out.println("entry dao");

        Query query = getSession().createQuery("from User u");

        System.out.println(getSession().getTransaction().getStatus());

        List<User> users = query.list();

        System.out.println(users);

        this.pagingQuick("", 0, 2);

        return null;
    }

}

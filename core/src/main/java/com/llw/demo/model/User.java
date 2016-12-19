package com.llw.demo.model;

import com.llw.demo.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @discription: 用户
 * @author: llw
 * @date: 2016-11-17
 */
@Entity
@Table(name = "test_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /** 用户名 */
    @Column
    private String username;
    /** 密码 */
    @Column
    private String password;

    //getter&setter
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return password.equals(user.password);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }

}

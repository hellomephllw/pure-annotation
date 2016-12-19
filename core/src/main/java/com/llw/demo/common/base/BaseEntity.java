package com.llw.demo.common.base;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @discription: 模型对象基类，所有实体都要继承该基类
 * @author: llw
 * @date: 2016-11-17
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    /** 逻辑主键 */
    @Id
    protected long id;
    /** 乐观锁版本控制 */
    @Column
    protected long version;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", version=" + version +
                '}';
    }

}

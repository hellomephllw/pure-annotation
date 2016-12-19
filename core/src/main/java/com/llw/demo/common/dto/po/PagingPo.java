package com.llw.demo.common.dto.po;

import java.util.List;

/**
 * @discription: 分页持久层返回对象
 * @author: llw
 * @date: 2016-11-27
 */
public class PagingPo<T> {

    /** 分页条件查询出的实体 */
    private List<T> entities;
    /** 条件查询出的总数 */
    private long count;

    public PagingPo() {
    }

    public PagingPo(List<T> entities, long count) {
        this.entities = entities;
        this.count = count;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PagingPo{" +
                "entities=" + entities +
                ", count=" + count +
                '}';
    }

}

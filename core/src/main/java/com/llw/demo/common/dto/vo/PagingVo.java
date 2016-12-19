package com.llw.demo.common.dto.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

/**
 * @discription: 分页视图对象或值对象
 * @author: llw
 * @date: 2016-11-26
 */
public class PagingVo<T> {

    /** 当前页码 */
    @ApiModelProperty(value = "当前页码")
    private int pageNo;

    @ApiModelProperty(value = "每页数据量")
    /** 每页数据量 */
    private int pageSize;

    @ApiModelProperty(value = "总页数")
    /** 总页数 */
    private int pageAmount;

    @ApiModelProperty(value = "实体集合")
    /** 实体集合:建议使用TreeSet */
    private Set<T> entities;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public Set<T> getEntities() {
        return entities;
    }

    public void setEntities(Set<T> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "PagingVo{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageAmount=" + pageAmount +
                ", entities=" + entities +
                '}';
    }

}

package com.llw.demo.common.dto.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @discription: 自定义视图对象
 * @author: llw
 * @date: 2016-11-26
 */
public class SpecialVo {

    @ApiModelProperty("描述")
    private String xxx;

    @ApiModelProperty("所需集合")
    private List<?> list;

    public SpecialVo() {
    }

    public SpecialVo(String xxx, List<?> list) {
        this.xxx = xxx;
        this.list = list;
    }

    public String getXxx() {
        return xxx;
    }

    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SpecialVo{" +
                "xxx='" + xxx + '\'' +
                ", list=" + list +
                '}';
    }

}

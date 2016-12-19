package com.llw.demo.common.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * @discription: 基本vo
 * @author: llw
 * @date: 2016-11-26
 */
public class BaseVo {

    @ApiModelProperty(value = "状态(0:失败 1:成功)")
    protected int status;

    @ApiModelProperty(value = "消息")
    protected String message;

    @ApiModelProperty("返回数据")
    protected Object valueObject;

    public BaseVo() {
    }

    public BaseVo(int status, String message, Object valueObject) {
        this.status = status;
        this.message = message;
        this.valueObject = valueObject;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getValueObject() {
        return valueObject;
    }

    public void setValueObject(Object valueObject) {
        this.valueObject = valueObject;
    }

    @Override
    public String toString() {
        return "BaseVo{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", valueObject=" + valueObject +
                '}';
    }
}

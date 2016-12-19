package com.llw.demo.common.dto.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @discription: 商品视图对象或值对象
 * @author: llw
 * @date: 2016-11-26
 */
public class ProductVo {

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品价格")
    private String price;

    public ProductVo() {
    }

    public ProductVo(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductVo{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}

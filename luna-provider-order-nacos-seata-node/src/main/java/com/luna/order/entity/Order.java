package com.luna.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 订单(Order)实体类
 *
 * @author luna
 * @since 2021-02-05 00:12:20
 */
@ApiModel("订单实体类")
public class Order implements Serializable {
    private static final long serialVersionUID = 169551432339480360L;
    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private Long              id;
    /**
     * 用户编号
     */
    @ApiModelProperty("用户编号")
    private Long              userId;
    /**
     * 产品编号
     */
    @ApiModelProperty("产品编号")
    private Long              productId;
    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer           count;
    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private Double            money;
    @ApiModelProperty("status")
    private Integer           status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

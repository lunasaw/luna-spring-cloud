package com.luna.commons.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 库存(Storage)实体类
 *
 * @author luna
 * @since 2021-02-05 12:04:27
 */
@ApiModel("库存实体类")
public class Storage implements Serializable {
    private static final long serialVersionUID = 153277348548937479L;
    /**
     * 库存编号
     */
    @ApiModelProperty("库存编号")
    private Long              id;
    /**
     * 总量
     */
    @ApiModelProperty("总量")
    private Integer           total;
    /**
     * 产品编号
     */
    @ApiModelProperty("产品编号")
    private Long              productId;
    /**
     * 库存使用量
     */
    @ApiModelProperty("库存使用量")
    private Integer           used;
    /**
     * 库存剩余量
     */
    @ApiModelProperty("库存剩余量")
    private Integer           residue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getResidue() {
        return residue;
    }

    public void setResidue(Integer residue) {
        this.residue = residue;
    }

}

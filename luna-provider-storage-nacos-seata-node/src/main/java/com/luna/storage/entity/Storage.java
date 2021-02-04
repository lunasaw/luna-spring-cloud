package com.luna.storage.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (Storage)实体类
 *
 * @author luna
 * @since 2021-02-05 01:40:07
 */
@ApiModel("实体类")
public class Storage implements Serializable {
    private static final long serialVersionUID = 762366657381218528L;
    @ApiModelProperty("id")
    private Long              id;
    @ApiModelProperty("total")
    private Integer           total;
    @ApiModelProperty("productId")
    private Long              productId;
    @ApiModelProperty("used")
    private Integer           used;
    @ApiModelProperty("residue")
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

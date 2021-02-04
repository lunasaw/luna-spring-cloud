package com.luna.storage.entity;

import java.io.Serializable;

/**
 * (Storage)实体类
 *
 * @author luna
 * @since 2021-02-04 22:24:22
 */
public class Storage implements Serializable {
    private static final long serialVersionUID = -24940899542204579L;

    private Long              id;

    private Integer           total;

    private Long              productId;

    private Integer           used;

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

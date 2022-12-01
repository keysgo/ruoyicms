package com.ruoyi.home.domain;

import com.ruoyi.common.core.domain.BaseEntity;

/***
 * 分类
 * @author keysto
 */
public class KeystoPngingType{
    private static final long serialVersionUID = 1L;

    /** 分类 */
    private String type;

    /** 数量 */
    private Integer countType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCountType() {
        return countType;
    }

    public void setCountType(Integer countType) {
        this.countType = countType;
    }

    @Override
    public String toString() {
        return "KeystoPngingType{" +

                ", type='" + type + '\'' +
                ", countType=" + countType +
                '}';
    }
}

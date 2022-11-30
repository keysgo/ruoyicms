package com.ruoyi.home.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * png前端对象 keysto_pngimg
 * 
 * @author ruoyi
 * @date 2022-11-30
 */
public class KeystoPngimg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 关键字 */
    @Excel(name = "关键字")
    private String keywords;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 描述 */
    @Excel(name = "描述")
    private String miaoshu;

    /** 信息 */
    @Excel(name = "信息")
    private String info;

    /** 下载地址 */
    @Excel(name = "下载地址")
    private String src;

    /** 大小 */
    @Excel(name = "大小")
    private String size;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setKeywords(String keywords) 
    {
        this.keywords = keywords;
    }

    public String getKeywords() 
    {
        return keywords;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMiaoshu(String miaoshu) 
    {
        this.miaoshu = miaoshu;
    }

    public String getMiaoshu() 
    {
        return miaoshu;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }
    public void setSrc(String src) 
    {
        this.src = src;
    }

    public String getSrc() 
    {
        return src;
    }
    public void setSize(String size) 
    {
        this.size = size;
    }

    public String getSize() 
    {
        return size;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("keywords", getKeywords())
            .append("name", getName())
            .append("miaoshu", getMiaoshu())
            .append("info", getInfo())
            .append("src", getSrc())
            .append("size", getSize())
            .append("type", getType())
            .toString();
    }
}

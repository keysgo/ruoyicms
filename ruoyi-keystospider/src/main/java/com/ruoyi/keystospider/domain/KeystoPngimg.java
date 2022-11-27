package com.ruoyi.keystospider.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * png管理对象 keysto_pngimg
 * 
 * @author keysto
 * @date 2022-11-27
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

    /** 描述 */
    @Excel(name = "描述")
    private String miaoshu;

    /** 下载地址 */
    @Excel(name = "下载地址")
    private String pngsrc;

    /** 大小 */
    @Excel(name = "大小")
    private String size;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    /** png信息 */
    @Excel(name = "png信息")
    private String pnginfo;

    /** png描述 */
    @Excel(name = "png描述")
    private String desc;

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
    public void setMiaoshu(String miaoshu) 
    {
        this.miaoshu = miaoshu;
    }

    public String getMiaoshu() 
    {
        return miaoshu;
    }
    public void setPngsrc(String pngsrc) 
    {
        this.pngsrc = pngsrc;
    }

    public String getPngsrc() 
    {
        return pngsrc;
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
    public void setPnginfo(String pnginfo) 
    {
        this.pnginfo = pnginfo;
    }

    public String getPnginfo() 
    {
        return pnginfo;
    }
    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public String getDesc() 
    {
        return desc;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("keywords", getKeywords())
            .append("miaoshu", getMiaoshu())
            .append("pngsrc", getPngsrc())
            .append("size", getSize())
            .append("type", getType())
            .append("pnginfo", getPnginfo())
            .append("desc", getDesc())
            .toString();
    }
}

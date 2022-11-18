package com.ruoyi.keystospider.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 亚马逊产品对象 keysto_product
 * 
 * @author keysto
 * @date 2022-11-16
 */
public class KeystoProduct extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 介绍 */
    @Excel(name = "介绍")
    private String desc;

    /** 亚马逊链接 */
    @Excel(name = "亚马逊链接")
    private String src;

    /** 价格 */
    @Excel(name = "价格")
    private String price;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String img;

    /** 点赞 */
    @Excel(name = "点赞")
    private String star;

    /** 评论 */
    @Excel(name = "评论")
    private String reviews;

    /** 评论图片 */
    @Excel(name = "评论图片")
    private String reviewsImg;

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
    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public String getDesc() 
    {
        return desc;
    }
    public void setSrc(String src) 
    {
        this.src = src;
    }

    public String getSrc() 
    {
        return src;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setStar(String star) 
    {
        this.star = star;
    }

    public String getStar() 
    {
        return star;
    }
    public void setReviews(String reviews) 
    {
        this.reviews = reviews;
    }

    public String getReviews() 
    {
        return reviews;
    }
    public void setReviewsImg(String reviewsImg) 
    {
        this.reviewsImg = reviewsImg;
    }

    public String getReviewsImg() 
    {
        return reviewsImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("desc", getDesc())
            .append("src", getSrc())
            .append("price", getPrice())
            .append("img", getImg())
            .append("star", getStar())
            .append("reviews", getReviews())
            .append("reviewsImg", getReviewsImg())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

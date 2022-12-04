package com.ruoyi.home.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author keysto
 * 配置前台页面信息
 */
@Configuration
@PropertySource(value = { "classpath:home.properties" })
public class HomeConfig {
    @Value("${home.url}")
    private String homeUrl;

    @Value("${home.title}")
    private String homeTitle;

    @Value("${home.keywords}")
    private String homeKeywords;

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getHomeTitle() {
        return homeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        this.homeTitle = homeTitle;
    }

    public String getHomeKeywords() {
        return homeKeywords;
    }

    public void setHomeKeywords(String homeKeywords) {
        this.homeKeywords = homeKeywords;
    }
}

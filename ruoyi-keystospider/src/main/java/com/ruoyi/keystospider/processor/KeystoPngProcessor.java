package com.ruoyi.keystospider.processor;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.ruoyi.common.utils.http.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.processor.PageProcessor;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;
import java.util.UUID;

/**
 * @author keysto
 */
@Slf4j
public class KeystoPngProcessor implements PageProcessor {


    /***
     * https://pngimg.com/
     * 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
     */
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setCharset("utf-8")
//          .addCookie("sp-cdn","\"L5Z9:ID\"")
            .setUserAgent(
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
            .setDomain("pngimg.com");

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        //获取所有分类链接
        List<Selectable> category_links = page.getHtml().css("div.sub_category").links().nodes();
        if(category_links.size()==0){
            //获取分类页的所有具体图片页面链接
            List<Selectable> imgLinks = page.getHtml().css("div.img_desc a").links().regex("https://pngimg.com/image/.*").nodes();
            //处理具体页面
            if(imgLinks.size()==0){
                savePngInfo(page);
            }else {
                //把具体页面加入队列
                for (Selectable imgLink : imgLinks) {
                    page.addTargetRequest(imgLink.toString());
                }
            }
        }else {
            //处理分类页加入队列
            for (Selectable category_link : category_links) {
                page.addTargetRequest(category_link.toString());
            }
        }

    }

    /***
     * 处理具体图片页面
     * 下载图片
     * 入库存储信息
     * @param page
     */
    private void savePngInfo(Page page) {
        String imgUrl = page.getHtml().css("div.png_big a").links().nodes().get(0).toString();
        String href = page.getHtml().css("div.png_big a", "href").toString();
        String[] split = StringUtils.split(href, "/");
        //获取文件名字
        String pngName = split[2];

        String title = page.getHtml().xpath("/html/body/div[4]/div/h1/text()").toString();
        String typeName = page.getHtml().xpath("/html/body/div[4]/div/div[3]/span/span[4]/a/span/text()").toString();
        String desc = page.getHtml().css("div.row p").toString();
        log.info(title);
        log.info(desc);
        try {
            long l = HttpUtil.downloadFile(imgUrl, FileUtil.file("E:\\java\\ruoyicms\\ruoyi-keystospider\\src\\main\\resources\\download\\png\\"));
            if(l>0){
               //下载成功,存储信息

            }

        }catch (RuntimeException e){
            e.getMessage();
        }





    }

    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return site;
    }

    @Test
    public void run() {
        KeystoPngProcessor keystoPngProcessor = new KeystoPngProcessor();
//https://pngimg.com/
        Spider.create(keystoPngProcessor)
                .addUrl("https://pngimg.com/image/54691")
                //开启5个线程抓取
                .thread(1)
//                .addPipeline()
                //启动爬虫
                .run();
    }
}

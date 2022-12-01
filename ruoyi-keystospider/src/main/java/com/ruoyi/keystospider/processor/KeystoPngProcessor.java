package com.ruoyi.keystospider.processor;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpUtil;
import com.ruoyi.keystospider.domain.KeystoPngimg;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.processor.PageProcessor;
import lombok.extern.slf4j.Slf4j;
import us.codecraft.webmagic.selector.Selectable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author keysto
 */
@Slf4j
@Component
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
        if (category_links.size() == 0) {
            //获取分类页的所有具体图片页面链接
            List<Selectable> imgLinks = page.getHtml().css("div.img_desc a").links().regex("https://pngimg.com/image/.*").nodes();
            //处理具体页面
            if (imgLinks.size() == 0) {
                savePngInfo(page);
            } else {
                //把具体页面加入队列
                for (Selectable imgLink : imgLinks) {
                    page.addTargetRequest(imgLink.toString());
                }
            }
        } else {
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
        KeystoPngimg keystoPngimg = new KeystoPngimg();
        String imgUrl = page.getHtml().css("div.png_big a").links().nodes().get(0).toString();
        String desc = "";



//        HttpUtil.downloadFile(imgUrl, FileUtil.file("E:\\java\\ruoyicms\\ruoyi-keystospider\\src\\main\\resources\\download\\png\\"));

        //下载成功,存储信息




        String pngPath="E:\\java\\ruoyicms\\ruoyi-keystospider\\src\\main\\resources\\download\\png\\";
        String href = page.getHtml().css("div.png_big a", "href").toString();
        String[] split = StringUtils.split(href, "/");
        //获取文件名字
        String pngName = split[2];
        //下载文件
//        savePng(imgUrl,pngPath,pngName);
        keystoPngimg.setName(pngName);
        String title = page.getHtml().xpath("/html/body/div[4]/div/h1/text()").toString();
        keystoPngimg.setTitle(title);

        String typeName = page.getHtml().xpath("/html/body/div[4]/div/div[3]/span/span[3]/a/span/text()").toString();
        keystoPngimg.setType(typeName);
        List<Selectable> descList = page.getHtml().xpath("/html/body/div[4]/div//p").nodes();
        String pngInfo = page.getHtml().xpath("/html/body/div[4]/div/div[5]").toString();
        keystoPngimg.setInfo(pngInfo);
        for (Selectable s : descList) {
            desc += s;
        }
        keystoPngimg.setMiaoshu(desc);


        log.info("111111");
        page.putField("keystoPngimg", keystoPngimg);

    }



    /**
     * description: 保存图片到本地
     *
     * @param imgUrl
     * @return: void
     * @author: weirx
     * @time: 2022/1/5 17:46
     */
    private void savePng(String imgUrl,String pngPath,String pngName) {
        try {
            URL url = new URL(imgUrl);
            // 打开连接
            URLConnection con = url.openConnection();
            // 输入流
            InputStream is = con.getInputStream();
            Files.copy(is, Paths.get(pngPath+pngName));
        } catch (IOException e) {
            e.printStackTrace();
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

    @Autowired
    private KeystoPngPipeline keystoPngPipeline;

    @Test
    public void run() {
        KeystoPngProcessor keystoPngProcessor = new KeystoPngProcessor();
//https://pngimg.com/     https://pngimg.com/image/20013
        Spider.create(keystoPngProcessor)
                .addUrl("https://pngimg.com/")
                //开启5个线程抓取
                .thread(20)
                .addPipeline(this.keystoPngPipeline)
                //启动爬虫
                .runAsync();
    }
}

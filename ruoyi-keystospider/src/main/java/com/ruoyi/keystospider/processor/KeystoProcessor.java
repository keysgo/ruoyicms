package com.ruoyi.keystospider.processor;

import com.ruoyi.keystospider.domain.KeystoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

@Component
public class KeystoProcessor implements PageProcessor {

    //部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me()
            .setRetryTimes(3).
            setSleepTime(1000).
            setCharset("utf-8").
//            addCookie("sp-cdn","\"L5Z9:ID\"").
//            addCookie("ubid-main","132-7277366-5809615").
//            addCookie("lc-main","en_US").
//            addCookie("session-id-time","2082787201l").
//            addCookie("i18n-prefs","USD").
//            addCookie("session-token","e3uh77NJVgoKG6o8+48VeGZbOy3aq0aQ7v0UCJjPSLEpAhVZuC3TwHfOSEref47iVZr0T7Sl1Lnefp48z0DYOZpexIBwVYrfIYsg6ZS/7Q7rrxLTaQwwzHtGP4kYAlJg5iQl2hXCY0gT+rjHB44RxcBixBBh+l4P4XVzRSqSpyh6IEHqobNlGtcynGtUPdTCp4l/uSGwaDpI7mdK4cmKoB9GnMCDwljSnevWG0tqiqQ=").
//            addCookie("session-id","139-4044824-9523247").
//            addCookie("csm-hit","tb:SP7DGNGCAG4TP14JPB2G+s-SP7DGNGCAG4TP14JPB2G|1668425676801&t:1668425676801&adb:adblk_no").
//            addCookie("x-amz-captcha-2","nm1Lo54qyEgHXivfTXnoEw==").
//            addCookie("x-amz-captcha-1","1668430650546214").
            setUserAgent(
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
            .setDomain("www.amazon.com");



    @Override
    public void process(Page page) {

        //获取产品页面
        List<Selectable> list = page.getHtml().css("div.s-main-slot h2").nodes();
        System.out.println("1111");

        if(list.size()==0){
            //判断页面为产品页,提取产品详细信息
            System.out.println("提取产品详细信息");
            saveProductInfo(page);
            System.out.println("提取产品信息结束");
        }else {
            //提取产品连接加入任务
            for (Selectable selectable : list) {
                String productUrl = selectable.links().toString();
                //https://www.amazon.com/CANINEDESIGN-QUALITY-DOG-COLLARS-Caninedesign/dp/B07B8Z2XK6/ref=sr_1_1?crid=2DGNRN9FKTMJ&keywords=dog%2Bcollars&qid=1668421736&sprefix=%2Caps%2C253&sr=8-1&th=1
                // ref=sr_1_1?crid=2DGNRN9FKTMJ&keywords=dog%2Bcollars&qid=1668421736&sprefix=%2Caps%2C253&sr=8-1&th=1
                String regUrl="https://www.amazon.com/.*/dp/.*";
                if(productUrl.matches(regUrl)){
                    System.out.println(productUrl);
                    page.addTargetRequest(productUrl);
                }
//                System.out.println(productUrl);
//                page.addTargetRequest(productUrl);
            }
            //获取下一页url
            String bkUrl = page.getHtml().css("span.s-pagination-strip a.s-pagination-next").links().toString();

            //String bkUrl = (String) css
            System.out.println(bkUrl);
        }


    }

    /***
     * 保存爬取信息
     * @param page
     */
    private void saveProductInfo(Page page) {

        KeystoProduct keystoProduct = new KeystoProduct();
        //标题
        keystoProduct.setTitle(page.getHtml().xpath("//*[@id=\"productTitle\"]/text()").toString());

        //价格
        keystoProduct.setPrice(page.getHtml().css("span.a-price span.a-offscreen","text").toString());

        //内容
        keystoProduct.setDesc(page.getHtml().xpath("//*[@id=\"feature-bullets\"]/ul").toString());

        keystoProduct.setSrc(page.getUrl().toString());

        keystoProduct.setImg(page.getHtml().xpath("//*[@id=\"landingImage\"]/@src").toString());
        System.out.println("产品标题"+keystoProduct.getTitle());
        page.putField("keystoProduct",keystoProduct);

    }

    @Override
    public Site getSite() {
        return site;
    }

    @Autowired
    private KeystoPipeline keystoPipeline;

    public void run() {
        KeystoProcessor keystoProcessor = new KeystoProcessor();

        Spider.create(keystoProcessor)
                .addUrl("https://www.amazon.com/s?k=dog+collars&s=review-rank&crid=2DGNRN9FKTMJ&qid=1668173387&sprefix=%2Caps%2C253&ref=sr_pg_1")
                //开启5个线程抓取
                .thread(1)
                .addPipeline(this.keystoPipeline)
                //启动爬虫
                .run();
    }
}

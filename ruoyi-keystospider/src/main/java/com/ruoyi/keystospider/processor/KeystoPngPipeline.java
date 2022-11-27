package com.ruoyi.keystospider.processor;

import com.ruoyi.keystospider.domain.KeystoPngimg;
import com.ruoyi.keystospider.service.IKeystoPngimgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Slf4j
public class KeystoPngPipeline implements Pipeline {

    @Autowired
    private IKeystoPngimgService keystoPngimgService;

    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        KeystoPngimg keystoPngimg=resultItems.get("keystoPngimg");
        if(keystoPngimg!=null){
            try {
                int i = keystoPngimgService.insertKeystoPngimg(keystoPngimg);
                if(i>0){
                    log.info("成功写入数据库id:"+i);
                }
            }catch (Exception e){
                log.info("入库失败");
                log.info(e.getMessage());

            }
        }
    }
}

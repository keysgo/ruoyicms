package com.ruoyi.keystospider.processor;

import com.ruoyi.keystospider.domain.KeystoProduct;
import com.ruoyi.keystospider.service.IKeystoProductService;
import com.ruoyi.keystospider.service.IKeystoSpiderConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

@Component
public class KeystoPipeline implements Pipeline {
    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */

    @Autowired
    private IKeystoSpiderConfigService keystoSpiderConfigService;

    @Autowired
    private IKeystoProductService keystoProductService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        System.out.println("开始入库");
        System.out.println("KeystoPipeline");
        KeystoProduct keystoProduct = resultItems.get("keystoProduct");
        if(keystoProduct!=null){
            try {
                System.out.println("进入try");
                System.out.println("进入try");
                int i = this.keystoProductService.insertKeystoProduct(keystoProduct);
                if(i>0){
                    System.out.println("成功写入数据库id:"+i);
                }
            }catch (Exception e){
                System.out.println("入库失败");
                System.out.println(e.getMessage());

            }

        }
    }

}

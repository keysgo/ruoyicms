package com.ruoyi.keystospider.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.keystospider.processor.KeystoProcessor;
import com.ruoyi.keystospider.service.IKeystoSpiderConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keystospider/spider")
public class SpiderController extends BaseController {

    @Autowired
    private KeystoProcessor keystoProcessor;

    @Autowired
    private IKeystoSpiderConfigService keystoSpiderConfigService;

    @GetMapping("/list")
    public String list(){
        keystoProcessor.run();
        return "keystospider/spider/index";
    }

    @GetMapping("/list3")
    public String list1(){
        keystoProcessor.run();
        return "keystospider/spider/index";
    }
}

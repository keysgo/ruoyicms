package com.ruoyi.keystospider.controller;

import com.ruoyi.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keysgo")

public class KeystoIndexController{

    @RequestMapping("/index")
    public int index(){
        System.out.println("index");
//        return "keystospider/home/index";
        return 0;

    }



}

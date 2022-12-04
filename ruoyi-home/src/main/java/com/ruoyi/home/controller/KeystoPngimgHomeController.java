package com.ruoyi.home.controller;

import java.util.List;

import com.ruoyi.home.config.HomeConfig;
import com.ruoyi.home.domain.KeystoPngingType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.home.domain.KeystoPngimgHome;
import com.ruoyi.home.service.IKeystoPngimgHomeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * png前端Controller
 * 
 * @author keysto
 * @date 2022-11-30
 */
@Controller
@RequestMapping("/home")
public class KeystoPngimgHomeController extends BaseController {

    @Autowired
    private HomeConfig homeConfig;

    @Autowired
    private IKeystoPngimgHomeService keystoPngimgHomeService;

    /**
     * 首页展示
     */
    @GetMapping("/")
    public String homeList(Model model) {

        List<KeystoPngingType> keystoPngingTypes = keystoPngimgHomeService.selectKeystoPngimgTypeList();
        model.addAttribute("keystoPngingTypes", keystoPngingTypes);
        model.addAttribute("homeConfig",homeConfig);
        return "home/pnghome/index";
    }

    /***
     * 分类页面展示
     * @param type
     * @param model
     * @return
     */
    @GetMapping("/type/{type}")
    public String type(@PathVariable("type") String type, Model model) {
        KeystoPngimgHome keystoPngimgHome = new KeystoPngimgHome();
        keystoPngimgHome.setType(type);
        List<KeystoPngimgHome> keystoPngimgHomes = keystoPngimgHomeService.selectKeystoPngimgHomeList(keystoPngimgHome);
        model.addAttribute("keystoPngimgHomes", keystoPngimgHomes);
        model.addAttribute("homeConfig",homeConfig);
        return "home/pnghome/type";
    }


    @GetMapping("/png/{id}")
    public String png(@PathVariable("id") Long id,Model model){
        KeystoPngimgHome keystoPngimgHome = keystoPngimgHomeService.selectKeystoPngimgHomeById(id);
        model.addAttribute("png", keystoPngimgHome);
        model.addAttribute("homeConfig",homeConfig);
        return "home/pnghome/png";
    }

    @PostMapping("/search/")
    public String search(String type, Model model) {
        KeystoPngimgHome keystoPngimgHome = new KeystoPngimgHome();
        keystoPngimgHome.setType(type);
        List<KeystoPngimgHome> keystoPngimgHomes = keystoPngimgHomeService.selectKeystoPngimgHomeList(keystoPngimgHome);
        model.addAttribute("keystoPngimgHomes", keystoPngimgHomes);
        model.addAttribute("homeConfig",homeConfig);
        return "home/pnghome/search";
    }










}

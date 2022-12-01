package com.ruoyi.home.controller;

import java.util.List;

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
@RequestMapping("/home/pnghome")
public class KeystoPngimgHomeController extends BaseController {
    private String prefix = "home/pnghome";

    @Autowired
    private IKeystoPngimgHomeService keystoPngimgHomeService;

    @RequiresPermissions("home:pnghome:view")
    @GetMapping()
    public String pnghome() {
        return prefix + "/pnghome";
    }

    /**
     * 查询png前端列表
     */
    @RequiresPermissions("home:pnghome:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoPngimgHome keystoPngimgHome) {
        startPage();
        List<KeystoPngimgHome> list = keystoPngimgHomeService.selectKeystoPngimgHomeList(keystoPngimgHome);
        return getDataTable(list);
    }

    /**
     * 导出png前端列表
     */
    @RequiresPermissions("home:pnghome:export")
    @Log(title = "png前端", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoPngimgHome keystoPngimgHome) {
        List<KeystoPngimgHome> list = keystoPngimgHomeService.selectKeystoPngimgHomeList(keystoPngimgHome);
        ExcelUtil<KeystoPngimgHome> util = new ExcelUtil<KeystoPngimgHome>(KeystoPngimgHome.class);
        return util.exportExcel(list, "png前端数据");
    }

    /**
     * 新增png前端
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存png前端
     */
    @RequiresPermissions("home:pnghome:add")
    @Log(title = "png前端", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoPngimgHome keystoPngimgHome) {
        return toAjax(keystoPngimgHomeService.insertKeystoPngimgHome(keystoPngimgHome));
    }

    /**
     * 修改png前端
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        KeystoPngimgHome keystoPngimgHome = keystoPngimgHomeService.selectKeystoPngimgHomeById(id);
        mmap.put("keystoPngimgHome", keystoPngimgHome);
        return prefix + "/edit";
    }

    /**
     * 修改保存png前端
     */
    @RequiresPermissions("home:pnghome:edit")
    @Log(title = "png前端", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoPngimgHome keystoPngimgHome) {
        return toAjax(keystoPngimgHomeService.updateKeystoPngimgHome(keystoPngimgHome));
    }

    /**
     * 删除png前端
     */
    @RequiresPermissions("home:pnghome:remove")
    @Log(title = "png前端", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(keystoPngimgHomeService.deleteKeystoPngimgHomeByIds(ids));
    }


    /**
     * 首页展示
     */
    @GetMapping("/index")
    public String homeList(Model model) {

        List<KeystoPngingType> keystoPngingTypes = keystoPngimgHomeService.selectKeystoPngimgTypeList();
        model.addAttribute("keystoPngingTypes", keystoPngingTypes);
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
        return "home/pnghome/type";
    }

    @GetMapping("/type/test")
    public String testType() {
        return "home/pnghome/test2";
    }




    /**
     * 首页展示
     */
    @PostMapping("/index")
    @ResponseBody
    public TableDataInfo homeList(KeystoPngimgHome keystoPngimgHome)
    {
        startPage();  // 此方法配合前端完成自动分页
        List<KeystoPngingType> keystoPngingTypes = keystoPngimgHomeService.selectKeystoPngimgTypeList();
        return getDataTable(keystoPngingTypes);
    }







}

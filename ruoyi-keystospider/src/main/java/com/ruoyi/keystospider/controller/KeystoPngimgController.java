package com.ruoyi.keystospider.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.keystospider.domain.KeystoPngimg;
import com.ruoyi.keystospider.service.IKeystoPngimgService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * png图片Controller
 * 
 * @author ruoyi
 * @date 2022-11-27
 */
@Controller
@RequestMapping("/keystospider/pngimg")
public class KeystoPngimgController extends BaseController
{
    private String prefix = "keystospider/pngimg";

    @Autowired
    private IKeystoPngimgService keystoPngimgService;

    @RequiresPermissions("keystospider:pngimg:view")
    @GetMapping()
    public String pngimg()
    {
        return prefix + "/pngimg";
    }

    /**
     * 查询png图片列表
     */
    @RequiresPermissions("keystospider:pngimg:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KeystoPngimg keystoPngimg)
    {
        startPage();
        List<KeystoPngimg> list = keystoPngimgService.selectKeystoPngimgList(keystoPngimg);
        return getDataTable(list);
    }

    /**
     * 导出png图片列表
     */
    @RequiresPermissions("keystospider:pngimg:export")
    @Log(title = "png图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KeystoPngimg keystoPngimg)
    {
        List<KeystoPngimg> list = keystoPngimgService.selectKeystoPngimgList(keystoPngimg);
        ExcelUtil<KeystoPngimg> util = new ExcelUtil<KeystoPngimg>(KeystoPngimg.class);
        return util.exportExcel(list, "png图片数据");
    }

    /**
     * 新增png图片
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存png图片
     */
    @RequiresPermissions("keystospider:pngimg:add")
    @Log(title = "png图片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KeystoPngimg keystoPngimg)
    {
        return toAjax(keystoPngimgService.insertKeystoPngimg(keystoPngimg));
    }

    /**
     * 修改png图片
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        KeystoPngimg keystoPngimg = keystoPngimgService.selectKeystoPngimgById(id);
        mmap.put("keystoPngimg", keystoPngimg);
        return prefix + "/edit";
    }

    /**
     * 修改保存png图片
     */
    @RequiresPermissions("keystospider:pngimg:edit")
    @Log(title = "png图片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KeystoPngimg keystoPngimg)
    {
        return toAjax(keystoPngimgService.updateKeystoPngimg(keystoPngimg));
    }

    /**
     * 删除png图片
     */
    @RequiresPermissions("keystospider:pngimg:remove")
    @Log(title = "png图片", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(keystoPngimgService.deleteKeystoPngimgByIds(ids));
    }
}

package com.ruoyi.cms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.cms.domain.Article;
import com.ruoyi.cms.domain.ArticleModel;
import com.ruoyi.cms.domain.Category;
import com.ruoyi.cms.domain.Tags;
import com.ruoyi.cms.service.IArticleService;
import com.ruoyi.cms.service.ICategoryService;
import com.ruoyi.cms.service.ITagsService;
import com.ruoyi.cms.util.CmsConstants;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.plugs.common.config.Global;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.plugs.common.exception.BusinessException;
import com.ruoyi.plugs.common.utils.ServletUtils;
import com.ruoyi.system.service.ISysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章管理Controller
 *
 * @author wujiyue
 * @date 2019-10-28
 */
@Controller
@RequestMapping("/cms/article")
public class ArticleController extends BaseController
{
    private String prefix = "cms/article";

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITagsService tagsService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    private ISysConfigService configService;

    private String getEditorType(){
        return configService.selectConfigByKey(CmsConstants.KEY_EDITOR_TYPE);
    }

    @RequiresPermissions("cms:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章管理列表
     */
    @RequiresPermissions("cms:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Article article)
    {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }
    /**
     *这个接口对应 ueditor.config.js 中的，服务器统一请求接口路径
     *
     * */
   /* @GetMapping("/init/config")
    public String initConfig(){
        return "redirect:/ajax/libs/ueditor/1.4.3/config.json";
    }

    @PostMapping("/init/config")
    @ResponseBody
    public String upfile(String action, MultipartFile upfile, HttpServletRequest request){
        //图片
        String uploadimage="uploadimage";
        //视频
        String uploadscrawl="uploadscrawl";
        if (action.equals(uploadimage)||action.equals(uploadscrawl)){
            // 图片上传文件
            try {
                String pathUrl = FileUploadUtils.upload(Global.getProfile(), upfile);
                // 上传成功后返回的json数据
                *//*
                 * {"state": "SUCCESS","original": "Hydrangeas.jpg","size": "595284","title":
                 * "1551927256870045443.jpg","type": ".jpg","url":
                 * "/upload/image/20190307/1551927256870045443.jpg"}
                 *//*
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("state", "SUCCESS") ;
                map.put("original", upfile.getName()) ;
                map.put("size", upfile.getSize()) ;
                map.put("title", upfile.getName()) ;
                map.put("type", upfile.getContentType()) ;
                map.put("url", pathUrl) ;
                String result = JSON.toJSONString(map);
                System.out.println("json : " + result);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "上传失败";
    }*/
    /**
     * 导出文章管理列表
     */
    @RequiresPermissions("cms:article:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Article article)
    {
        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增文章管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<Tags> tags=tagsService.selectTagsAll();
        mmap.put("tags",tags);

        String editorType = getEditorType();
        if(CmsConstants.EDITOR_TYPE_EDITORMD.equals(editorType)){
            return prefix + "/add_editormd";
        }else{
            return prefix + "/add";
        }
    }

    /**
     * 新增保存文章管理
     */
    @RequiresPermissions("cms:article:add")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Article article)
    {
        if(StringUtils.isNotEmpty(article.getDescription())){
            if(article.getDescription().length()>250){
                String str=article.getDescription().substring(0,250);
                str+="...";
                article.setDescription(str);
            }
        }
        return toAjax(articleService.insertArticle(article));
    }

    /**
     * 修改文章管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        Article article = articleService.selectArticleById(id);
        mmap.put("article", article);
        String tagIds=article.getTags();
        List<Tags> tags= tagsService.selectSelectedTagsAll(tagIds);
        mmap.put("tags", tags);
        String editorType = getEditorType();
        if(CmsConstants.EDITOR_TYPE_EDITORMD.equals(editorType)){
            return prefix + "/edit_editormd";
        }else{
            return prefix + "/edit";
        }
    }

    /**
     * 修改保存文章管理
     */
    @RequiresPermissions("cms:article:edit")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Article article)
    {
        return toAjax(articleService.updateArticle(article));
    }

    /**
     * 删除文章管理
     */
    @RequiresPermissions("cms:article:remove")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(articleService.deleteArticleByIds(ids));
    }

    @RequestMapping ("/detail/{id}")
    public String article_detail(@PathVariable String id, Model model){

        Article article= articleService.selectArticleById(id);
        Category category=categoryService.selectCategoryById(Long.valueOf(article.getCategoryId()));
        if(article==null){
            throw new BusinessException("您要访问的文章不存在!");
        }
        String article_model=  article.getArticleModel();//文章模型
        if(ArticleModel.DUOGUYU.getVal().equals(article_model)){
            List<Tags> fullTabs=tagsService.selectBlogTabs();
            model.addAttribute("fullTabs",fullTabs);
            String tagIds=article.getTags();
            if(StringUtils.isNotEmpty(tagIds)){
                String[] arr= Convert.toStrArray(tagIds);
                List<Tags> tagsList=new ArrayList<Tags>();
                Tags tmp=null;
                for(String tid:arr){
                    //检测每个标签再数据库cms_tag表中是否存在（根据名称），如果存在记下id，不存在则新增并记下id
                    tmp=tagsService.selectTagsById(Long.valueOf(tid));
                    if(tmp!=null){
                        tagsList.add(tmp);
                    }
                }
                model.addAttribute("tagsList",tagsList);//这个值用于输出模板文件的标签
            }
            Map dataMap= JSONObject.parseObject(JSON.toJSONString(article), Map.class);
            model.addAllAttributes(dataMap);
            return prefix+"/article-duoguyu";
        }else{

            model.addAttribute("categoryName",article.getCategory().getCategoryName());
            model.addAttribute("article",article);
            return prefix+"/article-jxhx";
        }


    }



    /**
     * 上传图片(markdown编辑器上传图片使用)
     */
    @PostMapping("/uploadImage")
    @ResponseBody
    public Object uploadImage(@RequestParam("editormd-image-file") MultipartFile file) throws Exception
    {
        try
        {
            /*// 上传的后台只需要返回一个 JSON 数据，结构如下：
                 {
                 success : 0 | 1,           // 0 表示上传失败，1 表示上传成功
                 message : "提示的信息，上传成功或上传失败及错误信息等。",
                 url     : "图片地址"        // 上传成功时才返回
                 }
                 */

            // 上传图片并返回新文件名称
            String path = FileUploadUtils.upload(Global.getUploadPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            Map map=new HashMap();
            map.put("success",1);
            map.put("url",path);
            map.put("message","上传成功!");
            return map;
        }
        catch (Exception e)
        {
            Map map=new HashMap();
            map.put("success",0);
            map.put("url","");
            map.put("message","上传失败!"+e.getMessage());
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/batchPublish/{ids}", method = RequestMethod.POST)
    public Object batchPublish(@PathVariable String[] ids) {
        try{
            articleService.batchPublish(ids);
            return success("批量发布成功！");
        }catch (Exception e){
            return error("批量发布失败！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/sortInCategory", method = RequestMethod.POST)
    public AjaxResult sortInCategory(String categoryId) {
        try{
            List<Map> list=  articleService.sortInCategory(categoryId);
            return AjaxResult.success("获取排序文章成功！",list);
        }catch (Exception e){
            return error("获取排序文章失败！");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/saveSort", method = RequestMethod.POST)
    public AjaxResult saveSort(HttpServletRequest request) {
        try{
            Map map= ServletUtils.getMap(request);
            AjaxResult res=  articleService.saveSort(map);
            return res;
        }catch (Exception e){
            return error("排序失败！");
        }
    }

}

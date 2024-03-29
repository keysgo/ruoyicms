package com.ruoyi.cms.service;

import com.ruoyi.cms.domain.CmsTemplate;
import java.util.List;

/**
 * 模板Service接口
 *
 * @author wujiyue
 * @date 2019-11-17
 */
public interface ICmsTemplateService
{
    /**
     * 查询模板
     *
     * @param templateId 模板ID
     * @return 模板
     */
    public CmsTemplate selectTemplateById(Long templateId);
    /**
     * 查询模板
     *
     * @param templateCode 模板代码
     * @return 模板
     */
    public CmsTemplate selectTemplateByCode(String templateCode);
    /**
     * 查询模板列表
     *
     * @param template 模板
     * @return 模板集合
     */
    public List<CmsTemplate> selectTemplateList(CmsTemplate template);

    /**
     * 新增模板
     *
     * @param template 模板
     * @return 结果
     */
    public int insertTemplate(CmsTemplate template);

    /**
     * 修改模板
     *
     * @param template 模板
     * @return 结果
     */
    public int updateTemplate(CmsTemplate template);

    /**
     * 批量删除模板
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTemplateByIds(String ids);

    /**
     * 删除模板信息
     *
     * @param templateId 模板ID
     * @return 结果
     */
    public int deleteTemplateById(Long templateId);
}

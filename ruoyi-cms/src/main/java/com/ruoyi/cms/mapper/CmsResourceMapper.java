package com.ruoyi.cms.mapper;

import com.ruoyi.cms.domain.CmsResource;
import java.util.List;

/**
 * 资源Mapper接口
 *
 * @author wujiyue
 * @date 2019-11-23
 */
public interface CmsResourceMapper
{
    /**
     * 查询资源
     *
     * @param id 资源ID
     * @return 资源
     */
    public CmsResource selectResourceById(String id);

    /**
     * 查询资源列表
     *
     * @param resource 资源
     * @return 资源集合
     */
    public List<CmsResource> selectResourceList(CmsResource resource);

    /**
     * 新增资源
     *
     * @param resource 资源
     * @return 结果
     */
    public int insertResource(CmsResource resource);

    /**
     * 修改资源
     *
     * @param resource 资源
     * @return 结果
     */
    public int updateResource(CmsResource resource);

    /**
     * 删除资源
     *
     * @param id 资源ID
     * @return 结果
     */
    public int deleteResourceById(String id);

    /**
     * 批量删除资源
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResourceByIds(String[] ids);

    /**
     * 点赞+1
     * @param id
     * @return
     */
    public int upVote(String id);
    /**
     * 点击数+1
     * @param id
     * @return
     */
    public int resourceLook(String id);

}

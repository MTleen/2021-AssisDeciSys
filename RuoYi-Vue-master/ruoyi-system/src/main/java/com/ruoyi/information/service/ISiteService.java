package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.Site;

/**
 * 队站信息Service接口
 * 
 * @author  Mathripper
 * @date 2021-11-16
 */
public interface ISiteService 
{
    /**
     * 查询队站信息
     * 
     * @param siteid 队站信息主键
     * @return 队站信息
     */
    public Site selectSiteBySiteid(Long siteid);

    /**
     * 查询队站信息列表
     * 
     * @param site 队站信息
     * @return 队站信息集合
     */
    public List<Site> selectSiteList(Site site);

    /**
     * 新增队站信息
     * 
     * @param site 队站信息
     * @return 结果
     */
    public int insertSite(Site site);

    /**
     * 修改队站信息
     * 
     * @param site 队站信息
     * @return 结果
     */
    public int updateSite(Site site);

    /**
     * 批量删除队站信息
     * 
     * @param siteids 需要删除的队站信息主键集合
     * @return 结果
     */
    public int deleteSiteBySiteids(Long[] siteids);

    /**
     * 删除队站信息信息
     * 
     * @param siteid 队站信息主键
     * @return 结果
     */
    public int deleteSiteBySiteid(Long siteid);
}

package com.ruoyi.information.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.information.mapper.SiteMapper;
import com.ruoyi.information.domain.Site;
import com.ruoyi.information.service.ISiteService;

/**
 * 队站信息Service业务层处理
 * 
 * @author  Mathripper
 * @date 2021-11-16
 */
@Service
public class SiteServiceImpl implements ISiteService 
{
    @Autowired
    private SiteMapper siteMapper;

    /**
     * 查询队站信息
     * 
     * @param siteid 队站信息主键
     * @return 队站信息
     */
    @Override
    public Site selectSiteBySiteid(Long siteid)
    {
        return siteMapper.selectSiteBySiteid(siteid);
    }

    /**
     * 查询队站信息列表
     * 
     * @param site 队站信息
     * @return 队站信息
     */
    @Override
    public List<Site> selectSiteList(Site site)
    {
        return siteMapper.selectSiteList(site);
    }

    /**
     * 新增队站信息
     * 
     * @param site 队站信息
     * @return 结果
     */
    @Override
    public int insertSite(Site site)
    {
        return siteMapper.insertSite(site);
    }

    /**
     * 修改队站信息
     * 
     * @param site 队站信息
     * @return 结果
     */
    @Override
    public int updateSite(Site site)
    {
        return siteMapper.updateSite(site);
    }

    /**
     * 批量删除队站信息
     * 
     * @param siteids 需要删除的队站信息主键
     * @return 结果
     */
    @Override
    public int deleteSiteBySiteids(Long[] siteids)
    {
        return siteMapper.deleteSiteBySiteids(siteids);
    }

    /**
     * 删除队站信息信息
     * 
     * @param siteid 队站信息主键
     * @return 结果
     */
    @Override
    public int deleteSiteBySiteid(Long siteid)
    {
        return siteMapper.deleteSiteBySiteid(siteid);
    }
}

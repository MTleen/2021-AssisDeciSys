package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.SecurityMapper;
import com.ruoyi.knowledge.domain.Security;
import com.ruoyi.knowledge.service.ISecurityService;

/**
 * 安全知识库Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
@Service
public class SecurityServiceImpl implements ISecurityService 
{
    @Autowired
    private SecurityMapper securityMapper;

    /**
     * 查询安全知识库
     * 
     * @param informid 安全知识库主键
     * @return 安全知识库
     */
    @Override
    public Security selectSecurityByInformid(Integer informid)
    {
        return securityMapper.selectSecurityByInformid(informid);
    }

    /**
     * 查询安全知识库列表
     * 
     * @param security 安全知识库
     * @return 安全知识库
     */
    @Override
    public List<Security> selectSecurityList(Security security)
    {
        return securityMapper.selectSecurityList(security);
    }

    /**
     * 新增安全知识库
     * 
     * @param security 安全知识库
     * @return 结果
     */
    @Override
    public int insertSecurity(Security security)
    {
        return securityMapper.insertSecurity(security);
    }

    /**
     * 修改安全知识库
     * 
     * @param security 安全知识库
     * @return 结果
     */
    @Override
    public int updateSecurity(Security security)
    {
        return securityMapper.updateSecurity(security);
    }

    /**
     * 批量删除安全知识库
     * 
     * @param informids 需要删除的安全知识库主键
     * @return 结果
     */
    @Override
    public int deleteSecurityByInformids(Integer[] informids)
    {
        return securityMapper.deleteSecurityByInformids(informids);
    }

    /**
     * 删除安全知识库信息
     * 
     * @param informid 安全知识库主键
     * @return 结果
     */
    @Override
    public int deleteSecurityByInformid(Integer informid)
    {
        return securityMapper.deleteSecurityByInformid(informid);
    }
}

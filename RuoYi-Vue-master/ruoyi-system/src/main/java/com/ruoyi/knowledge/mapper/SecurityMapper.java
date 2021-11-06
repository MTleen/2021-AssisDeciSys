package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Security;

/**
 * 安全知识库Mapper接口
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
public interface SecurityMapper 
{
    /**
     * 查询安全知识库
     * 
     * @param informid 安全知识库主键
     * @return 安全知识库
     */
    public Security selectSecurityByInformid(Integer informid);

    /**
     * 查询安全知识库列表
     * 
     * @param security 安全知识库
     * @return 安全知识库集合
     */
    public List<Security> selectSecurityList(Security security);

    /**
     * 新增安全知识库
     * 
     * @param security 安全知识库
     * @return 结果
     */
    public int insertSecurity(Security security);

    /**
     * 修改安全知识库
     * 
     * @param security 安全知识库
     * @return 结果
     */
    public int updateSecurity(Security security);

    /**
     * 删除安全知识库
     * 
     * @param informid 安全知识库主键
     * @return 结果
     */
    public int deleteSecurityByInformid(Integer informid);

    /**
     * 批量删除安全知识库
     * 
     * @param informids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSecurityByInformids(Integer[] informids);
}

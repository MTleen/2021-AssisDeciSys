package com.ruoyi.information.service;

import java.util.List;
import com.ruoyi.information.domain.Admin;

/**
 * 权限表管理Service接口
 * 
 * @author Mathripper
 * @date 2021-10-18
 */
public interface IAdminService 
{
    /**
     * 查询权限表管理
     * 
     * @param adminid 权限表管理主键
     * @return 权限表管理
     */
    public Admin selectAdminByAdminid(Long adminid);

    /**
     * 查询权限表管理列表
     * 
     * @param admin 权限表管理
     * @return 权限表管理集合
     */
    public List<Admin> selectAdminList(Admin admin);

    /**
     * 新增权限表管理
     * 
     * @param admin 权限表管理
     * @return 结果
     */
    public int insertAdmin(Admin admin);

    /**
     * 修改权限表管理
     * 
     * @param admin 权限表管理
     * @return 结果
     */
    public int updateAdmin(Admin admin);

    /**
     * 批量删除权限表管理
     * 
     * @param adminids 需要删除的权限表管理主键集合
     * @return 结果
     */
    public int deleteAdminByAdminids(Long[] adminids);

    /**
     * 删除权限表管理信息
     * 
     * @param adminid 权限表管理主键
     * @return 结果
     */
    public int deleteAdminByAdminid(Long adminid);
}

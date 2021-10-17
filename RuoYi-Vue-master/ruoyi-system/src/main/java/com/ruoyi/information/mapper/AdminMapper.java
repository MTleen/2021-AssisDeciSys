package com.ruoyi.information.mapper;

import java.util.List;
import com.ruoyi.information.domain.Admin;

/**
 * 权限管理Mapper接口
 * 
 * @author wuliangrui
 * @date 2021-10-15
 */
public interface AdminMapper 
{
    /**
     * 查询权限管理
     * 
     * @param adminid 权限管理主键
     * @return 权限管理
     */
    public Admin selectAdminByAdminid(Long adminid);

    /**
     * 查询权限管理列表
     * 
     * @param admin 权限管理
     * @return 权限管理集合
     */
    public List<Admin> selectAdminList(Admin admin);

    /**
     * 新增权限管理
     * 
     * @param admin 权限管理
     * @return 结果
     */
    public int insertAdmin(Admin admin);

    /**
     * 修改权限管理
     * 
     * @param admin 权限管理
     * @return 结果
     */
    public int updateAdmin(Admin admin);

    /**
     * 删除权限管理
     * 
     * @param adminid 权限管理主键
     * @return 结果
     */
    public int deleteAdminByAdminid(Long adminid);

    /**
     * 批量删除权限管理
     * 
     * @param adminids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdminByAdminids(Long[] adminids);
}

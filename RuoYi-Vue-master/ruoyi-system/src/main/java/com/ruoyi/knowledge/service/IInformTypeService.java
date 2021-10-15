package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.InformType;

/**
 * 提示信息类型表Service接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface IInformTypeService 
{
    /**
     * 查询提示信息类型表
     * 
     * @param typeid 提示信息类型表主键
     * @return 提示信息类型表
     */
    public InformType selectInformTypeByTypeid(Long typeid);

    /**
     * 查询提示信息类型表列表
     * 
     * @param informType 提示信息类型表
     * @return 提示信息类型表集合
     */
    public List<InformType> selectInformTypeList(InformType informType);

    /**
     * 新增提示信息类型表
     * 
     * @param informType 提示信息类型表
     * @return 结果
     */
    public int insertInformType(InformType informType);

    /**
     * 修改提示信息类型表
     * 
     * @param informType 提示信息类型表
     * @return 结果
     */
    public int updateInformType(InformType informType);

    /**
     * 批量删除提示信息类型表
     * 
     * @param typeids 需要删除的提示信息类型表主键集合
     * @return 结果
     */
    public int deleteInformTypeByTypeids(Long[] typeids);

    /**
     * 删除提示信息类型表信息
     * 
     * @param typeid 提示信息类型表主键
     * @return 结果
     */
    public int deleteInformTypeByTypeid(Long typeid);
}

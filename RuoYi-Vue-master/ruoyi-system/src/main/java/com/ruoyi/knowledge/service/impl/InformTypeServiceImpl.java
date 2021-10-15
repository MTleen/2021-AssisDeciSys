package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.InformTypeMapper;
import com.ruoyi.knowledge.domain.InformType;
import com.ruoyi.knowledge.service.IInformTypeService;

/**
 * 提示信息类型表Service业务层处理
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@Service
public class InformTypeServiceImpl implements IInformTypeService 
{
    @Autowired
    private InformTypeMapper informTypeMapper;

    /**
     * 查询提示信息类型表
     * 
     * @param typeid 提示信息类型表主键
     * @return 提示信息类型表
     */
    @Override
    public InformType selectInformTypeByTypeid(Long typeid)
    {
        return informTypeMapper.selectInformTypeByTypeid(typeid);
    }

    /**
     * 查询提示信息类型表列表
     * 
     * @param informType 提示信息类型表
     * @return 提示信息类型表
     */
    @Override
    public List<InformType> selectInformTypeList(InformType informType)
    {
        return informTypeMapper.selectInformTypeList(informType);
    }

    /**
     * 新增提示信息类型表
     * 
     * @param informType 提示信息类型表
     * @return 结果
     */
    @Override
    public int insertInformType(InformType informType)
    {
        return informTypeMapper.insertInformType(informType);
    }

    /**
     * 修改提示信息类型表
     * 
     * @param informType 提示信息类型表
     * @return 结果
     */
    @Override
    public int updateInformType(InformType informType)
    {
        return informTypeMapper.updateInformType(informType);
    }

    /**
     * 批量删除提示信息类型表
     * 
     * @param typeids 需要删除的提示信息类型表主键
     * @return 结果
     */
    @Override
    public int deleteInformTypeByTypeids(Long[] typeids)
    {
        return informTypeMapper.deleteInformTypeByTypeids(typeids);
    }

    /**
     * 删除提示信息类型表信息
     * 
     * @param typeid 提示信息类型表主键
     * @return 结果
     */
    @Override
    public int deleteInformTypeByTypeid(Long typeid)
    {
        return informTypeMapper.deleteInformTypeByTypeid(typeid);
    }
}

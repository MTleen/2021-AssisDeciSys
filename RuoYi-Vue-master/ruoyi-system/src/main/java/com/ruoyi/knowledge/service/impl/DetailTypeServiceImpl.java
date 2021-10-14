package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.DetailTypeMapper;
import com.ruoyi.knowledge.domain.DetailType;
import com.ruoyi.knowledge.service.IDetailTypeService;

/**
 * 详细类型表Service业务层处理
 * 
 * @author xiaoyu
 * @date 2021-10-14
 */
@Service
public class DetailTypeServiceImpl implements IDetailTypeService 
{
    @Autowired
    private DetailTypeMapper detailTypeMapper;

    /**
     * 查询详细类型表
     * 
     * @param typeid 详细类型表主键
     * @return 详细类型表
     */
    @Override
    public DetailType selectDetailTypeByTypeid(Long typeid)
    {
        return detailTypeMapper.selectDetailTypeByTypeid(typeid);
    }

    /**
     * 查询详细类型表列表
     * 
     * @param detailType 详细类型表
     * @return 详细类型表
     */
    @Override
    public List<DetailType> selectDetailTypeList(DetailType detailType)
    {
        return detailTypeMapper.selectDetailTypeList(detailType);
    }

    /**
     * 新增详细类型表
     * 
     * @param detailType 详细类型表
     * @return 结果
     */
    @Override
    public int insertDetailType(DetailType detailType)
    {
        return detailTypeMapper.insertDetailType(detailType);
    }

    /**
     * 修改详细类型表
     * 
     * @param detailType 详细类型表
     * @return 结果
     */
    @Override
    public int updateDetailType(DetailType detailType)
    {
        return detailTypeMapper.updateDetailType(detailType);
    }

    /**
     * 批量删除详细类型表
     * 
     * @param typeids 需要删除的详细类型表主键
     * @return 结果
     */
    @Override
    public int deleteDetailTypeByTypeids(Long[] typeids)
    {
        return detailTypeMapper.deleteDetailTypeByTypeids(typeids);
    }

    /**
     * 删除详细类型表信息
     * 
     * @param typeid 详细类型表主键
     * @return 结果
     */
    @Override
    public int deleteDetailTypeByTypeid(Long typeid)
    {
        return detailTypeMapper.deleteDetailTypeByTypeid(typeid);
    }
}

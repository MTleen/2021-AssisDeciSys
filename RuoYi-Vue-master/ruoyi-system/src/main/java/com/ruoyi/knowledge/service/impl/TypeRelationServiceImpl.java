package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.TypeRelationMapper;
import com.ruoyi.knowledge.domain.TypeRelation;
import com.ruoyi.knowledge.service.ITypeRelationService;

/**
 * 标签关系Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
@Service
public class TypeRelationServiceImpl implements ITypeRelationService 
{
    @Autowired
    private TypeRelationMapper typeRelationMapper;

    /**
     * 查询标签关系
     * 
     * @param id 标签关系主键
     * @return 标签关系
     */
    @Override
    public TypeRelation selectTypeRelationById(Long id)
    {
        return typeRelationMapper.selectTypeRelationById(id);
    }

    /**
     * 查询标签关系列表
     * 
     * @param typeRelation 标签关系
     * @return 标签关系
     */
    @Override
    public List<TypeRelation> selectTypeRelationList(TypeRelation typeRelation)
    {
        return typeRelationMapper.selectTypeRelationList(typeRelation);
    }

    /**
     * 新增标签关系
     * 
     * @param typeRelation 标签关系
     * @return 结果
     */
    @Override
    public int insertTypeRelation(TypeRelation typeRelation)
    {
        return typeRelationMapper.insertTypeRelation(typeRelation);
    }

    /**
     * 修改标签关系
     * 
     * @param typeRelation 标签关系
     * @return 结果
     */
    @Override
    public int updateTypeRelation(TypeRelation typeRelation)
    {
        return typeRelationMapper.updateTypeRelation(typeRelation);
    }

    /**
     * 批量删除标签关系
     * 
     * @param ids 需要删除的标签关系主键
     * @return 结果
     */
    @Override
    public int deleteTypeRelationByIds(Long[] ids)
    {
        return typeRelationMapper.deleteTypeRelationByIds(ids);
    }

    /**
     * 删除标签关系信息
     * 
     * @param id 标签关系主键
     * @return 结果
     */
    @Override
    public int deleteTypeRelationById(Long id)
    {
        return typeRelationMapper.deleteTypeRelationById(id);
    }
}

package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.TypeRelation;

/**
 * 标签关系Mapper接口
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
public interface TypeRelationMapper 
{
    /**
     * 查询标签关系
     * 
     * @param id 标签关系主键
     * @return 标签关系
     */
    public TypeRelation selectTypeRelationById(Long id);

    /**
     * 查询标签关系列表
     * 
     * @param typeRelation 标签关系
     * @return 标签关系集合
     */
    public List<TypeRelation> selectTypeRelationList(TypeRelation typeRelation);

    /**
     * 新增标签关系
     * 
     * @param typeRelation 标签关系
     * @return 结果
     */
    public int insertTypeRelation(TypeRelation typeRelation);

    /**
     * 修改标签关系
     * 
     * @param typeRelation 标签关系
     * @return 结果
     */
    public int updateTypeRelation(TypeRelation typeRelation);

    /**
     * 删除标签关系
     * 
     * @param id 标签关系主键
     * @return 结果
     */
    public int deleteTypeRelationById(Long id);

    /**
     * 批量删除标签关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTypeRelationByIds(Long[] ids);
}

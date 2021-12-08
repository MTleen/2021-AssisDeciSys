package com.ruoyi.knowledge.service;

import java.util.List;

import com.ruoyi.knowledge.domain.DetailType;

/**
 * 详细类型表Service接口
 *
 * @author Mathripper
 * @date 2021-11-05
 */
public interface IDetailTypeService {
    /**
     * 查询详细类型表
     *
     * @param typeid 详细类型表主键
     * @return 详细类型表
     */
    public DetailType selectDetailTypeByTypeid(Long typeid);

    /**
     * 查询详细类型表列表
     *
     * @param detailType 详细类型表
     * @return 详细类型表集合
     */
    public List<DetailType> selectDetailTypeList(DetailType detailType);

    /**
     * 新增详细类型表
     *
     * @param detailType 详细类型表
     * @return 结果
     */
    public int insertDetailType(DetailType detailType);

    /**
     * 修改详细类型表
     *
     * @param detailType 详细类型表
     * @return 结果
     */
    public int updateDetailType(DetailType detailType);

    /**
     * 批量删除详细类型表
     *
     * @param typeids 需要删除的详细类型表主键集合
     * @return 结果
     */
    public int deleteDetailTypeByTypeids(Long[] typeids);

    /**
     * 删除详细类型表信息
     *
     * @param typeid 详细类型表主键
     * @return 结果
     */
    public int deleteDetailTypeByTypeid(Long typeid);

    /**
     * 循环插入 TypeRelation 表
     *
     * @param detailType 详细类型表
     */
    public void updateTypeRelation(DetailType detailType);
}
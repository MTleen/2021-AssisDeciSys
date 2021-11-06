package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.DisposeObj;

/**
 * 处置对象Service接口
 *
 * @author Mathripper
 * @date 2021-11-05
 */
public interface IDisposeObjService
{
    /**
     * 查询处置对象
     *
     * @param objid 处置对象主键
     * @return 处置对象
     */
    public DisposeObj selectDisposeObjByObjid(Long objid);

    /**
     * 查询处置对象列表
     *
     * @param disposeObj 处置对象
     * @return 处置对象集合
     */
    public List<DisposeObj> selectDisposeObjList(DisposeObj disposeObj);

    /**
     * 新增处置对象
     *
     * @param disposeObj 处置对象
     * @return 结果
     */
    public int insertDisposeObj(DisposeObj disposeObj);

    /**
     * 修改处置对象
     *
     * @param disposeObj 处置对象
     * @return 结果
     */
    public int updateDisposeObj(DisposeObj disposeObj);

    /**
     * 批量删除处置对象
     *
     * @param objids 需要删除的处置对象主键集合
     * @return 结果
     */
    public int deleteDisposeObjByObjids(Long[] objids);

    /**
     * 删除处置对象信息
     *
     * @param objid 处置对象主键
     * @return 结果
     */
    public int deleteDisposeObjByObjid(Long objid);
}
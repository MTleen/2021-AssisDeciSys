package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.DisposeObj;

/**
 * 处置对象Mapper接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface DisposeObjMapper 
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
     * 删除处置对象
     * 
     * @param objid 处置对象主键
     * @return 结果
     */
    public int deleteDisposeObjByObjid(Long objid);

    /**
     * 批量删除处置对象
     * 
     * @param objids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDisposeObjByObjids(Long[] objids);
}

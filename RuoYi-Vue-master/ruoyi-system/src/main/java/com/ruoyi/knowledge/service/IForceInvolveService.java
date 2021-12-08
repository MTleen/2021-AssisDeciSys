package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.ForceInvolve;

/**
 * 参战力量Service接口
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
public interface IForceInvolveService 
{
    /**
     * 查询参战力量
     * 
     * @param id 参战力量主键
     * @return 参战力量
     */
    public ForceInvolve selectForceInvolveById(Long id);

    /**
     * 查询参战力量列表
     * 
     * @param forceInvolve 参战力量
     * @return 参战力量集合
     */
    public List<ForceInvolve> selectForceInvolveList(ForceInvolve forceInvolve);

    /**
     * 新增参战力量
     * 
     * @param forceInvolve 参战力量
     * @return 结果
     */
    public int insertForceInvolve(ForceInvolve forceInvolve);

    /**
     * 修改参战力量
     * 
     * @param forceInvolve 参战力量
     * @return 结果
     */
    public int updateForceInvolve(ForceInvolve forceInvolve);

    /**
     * 批量删除参战力量
     * 
     * @param ids 需要删除的参战力量主键集合
     * @return 结果
     */
    public int deleteForceInvolveByIds(Long[] ids);

    /**
     * 删除参战力量信息
     * 
     * @param id 参战力量主键
     * @return 结果
     */
    public int deleteForceInvolveById(Long id);
}

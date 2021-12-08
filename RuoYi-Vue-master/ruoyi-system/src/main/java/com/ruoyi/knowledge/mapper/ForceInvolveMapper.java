package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.ForceInvolve;

/**
 * 参战力量Mapper接口
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
public interface ForceInvolveMapper 
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
     * 删除参战力量
     * 
     * @param id 参战力量主键
     * @return 结果
     */
    public int deleteForceInvolveById(Long id);

    /**
     * 批量删除参战力量
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteForceInvolveByIds(Long[] ids);

    /**
     * 根据 cautionID 删除参战力量
     *
     * @param id 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteForceInvolveByCautionId(Long id);
}

package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.ForceInvolveMapper;
import com.ruoyi.knowledge.domain.ForceInvolve;
import com.ruoyi.knowledge.service.IForceInvolveService;

/**
 * 参战力量Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-12-08
 */
@Service
public class ForceInvolveServiceImpl implements IForceInvolveService 
{
    @Autowired
    private ForceInvolveMapper forceInvolveMapper;

    /**
     * 查询参战力量
     * 
     * @param id 参战力量主键
     * @return 参战力量
     */
    @Override
    public ForceInvolve selectForceInvolveById(Long id)
    {
        return forceInvolveMapper.selectForceInvolveById(id);
    }

    /**
     * 查询参战力量列表
     * 
     * @param forceInvolve 参战力量
     * @return 参战力量
     */
    @Override
    public List<ForceInvolve> selectForceInvolveList(ForceInvolve forceInvolve)
    {
        return forceInvolveMapper.selectForceInvolveList(forceInvolve);
    }

    /**
     * 新增参战力量
     * 
     * @param forceInvolve 参战力量
     * @return 结果
     */
    @Override
    public int insertForceInvolve(ForceInvolve forceInvolve)
    {
        return forceInvolveMapper.insertForceInvolve(forceInvolve);
    }

    /**
     * 修改参战力量
     * 
     * @param forceInvolve 参战力量
     * @return 结果
     */
    @Override
    public int updateForceInvolve(ForceInvolve forceInvolve)
    {
        return forceInvolveMapper.updateForceInvolve(forceInvolve);
    }

    /**
     * 批量删除参战力量
     * 
     * @param ids 需要删除的参战力量主键
     * @return 结果
     */
    @Override
    public int deleteForceInvolveByIds(Long[] ids)
    {
        return forceInvolveMapper.deleteForceInvolveByIds(ids);
    }

    /**
     * 删除参战力量信息
     * 
     * @param id 参战力量主键
     * @return 结果
     */
    @Override
    public int deleteForceInvolveById(Long id)
    {
        return forceInvolveMapper.deleteForceInvolveById(id);
    }
}

package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.SpecialMapper;
import com.ruoyi.knowledge.domain.Special;
import com.ruoyi.knowledge.service.ISpecialService;

/**
 * 专项知识库Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
@Service
public class SpecialServiceImpl implements ISpecialService 
{
    @Autowired
    private SpecialMapper specialMapper;

    /**
     * 查询专项知识库
     * 
     * @param informid 专项知识库主键
     * @return 专项知识库
     */
    @Override
    public Special selectSpecialByInformid(Integer informid)
    {
        return specialMapper.selectSpecialByInformid(informid);
    }

    /**
     * 查询专项知识库列表
     * 
     * @param special 专项知识库
     * @return 专项知识库
     */
    @Override
    public List<Special> selectSpecialList(Special special)
    {
        return specialMapper.selectSpecialList(special);
    }

    /**
     * 新增专项知识库
     * 
     * @param special 专项知识库
     * @return 结果
     */
    @Override
    public int insertSpecial(Special special)
    {
        return specialMapper.insertSpecial(special);
    }

    /**
     * 修改专项知识库
     * 
     * @param special 专项知识库
     * @return 结果
     */
    @Override
    public int updateSpecial(Special special)
    {
        return specialMapper.updateSpecial(special);
    }

    /**
     * 批量删除专项知识库
     * 
     * @param informids 需要删除的专项知识库主键
     * @return 结果
     */
    @Override
    public int deleteSpecialByInformids(Integer[] informids)
    {
        return specialMapper.deleteSpecialByInformids(informids);
    }

    /**
     * 删除专项知识库信息
     * 
     * @param informid 专项知识库主键
     * @return 结果
     */
    @Override
    public int deleteSpecialByInformid(Integer informid)
    {
        return specialMapper.deleteSpecialByInformid(informid);
    }
}

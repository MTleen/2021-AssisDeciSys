package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.DisasterTypeMapper;
import com.ruoyi.knowledge.domain.DisasterType;
import com.ruoyi.knowledge.service.IDisasterTypeService;

/**
 * 险情类型Service业务层处理
 * 
 * @author Mathripper
 * @date 2021-10-14
 */
@Service
public class DisasterTypeServiceImpl implements IDisasterTypeService 
{
    @Autowired
    private DisasterTypeMapper disasterTypeMapper;

    /**
     * 查询险情类型
     * 
     * @param typeid 险情类型主键
     * @return 险情类型
     */
    @Override
    public DisasterType selectDisasterTypeByTypeid(Long typeid)
    {
        return disasterTypeMapper.selectDisasterTypeByTypeid(typeid);
    }

    /**
     * 查询险情类型列表
     * 
     * @param disasterType 险情类型
     * @return 险情类型
     */
    @Override
    public List<DisasterType> selectDisasterTypeList(DisasterType disasterType)
    {
        return disasterTypeMapper.selectDisasterTypeList(disasterType);
    }

    /**
     * 新增险情类型
     * 
     * @param disasterType 险情类型
     * @return 结果
     */
    @Override
    public int insertDisasterType(DisasterType disasterType)
    {
        return disasterTypeMapper.insertDisasterType(disasterType);
    }

    /**
     * 修改险情类型
     * 
     * @param disasterType 险情类型
     * @return 结果
     */
    @Override
    public int updateDisasterType(DisasterType disasterType)
    {
        return disasterTypeMapper.updateDisasterType(disasterType);
    }

    /**
     * 批量删除险情类型
     * 
     * @param typeids 需要删除的险情类型主键
     * @return 结果
     */
    @Override
    public int deleteDisasterTypeByTypeids(Long[] typeids)
    {
        return disasterTypeMapper.deleteDisasterTypeByTypeids(typeids);
    }

    /**
     * 删除险情类型信息
     * 
     * @param typeid 险情类型主键
     * @return 结果
     */
    @Override
    public int deleteDisasterTypeByTypeid(Long typeid)
    {
        return disasterTypeMapper.deleteDisasterTypeByTypeid(typeid);
    }
}

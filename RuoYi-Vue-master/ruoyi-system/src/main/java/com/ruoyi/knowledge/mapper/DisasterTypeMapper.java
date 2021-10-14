package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.DisasterType;

/**
 * 险情类型Mapper接口
 * 
 * @author Mathripper
 * @date 2021-10-14
 */
public interface DisasterTypeMapper 
{
    /**
     * 查询险情类型
     * 
     * @param typeid 险情类型主键
     * @return 险情类型
     */
    public DisasterType selectDisasterTypeByTypeid(Long typeid);

    /**
     * 查询险情类型列表
     * 
     * @param disasterType 险情类型
     * @return 险情类型集合
     */
    public List<DisasterType> selectDisasterTypeList(DisasterType disasterType);

    /**
     * 新增险情类型
     * 
     * @param disasterType 险情类型
     * @return 结果
     */
    public int insertDisasterType(DisasterType disasterType);

    /**
     * 修改险情类型
     * 
     * @param disasterType 险情类型
     * @return 结果
     */
    public int updateDisasterType(DisasterType disasterType);

    /**
     * 删除险情类型
     * 
     * @param typeid 险情类型主键
     * @return 结果
     */
    public int deleteDisasterTypeByTypeid(Long typeid);

    /**
     * 批量删除险情类型
     * 
     * @param typeids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDisasterTypeByTypeids(Long[] typeids);
}

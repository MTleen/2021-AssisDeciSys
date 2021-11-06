package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Special;

/**
 * 专项知识库Mapper接口
 * 
 * @author Mathripper
 * @date 2021-11-06
 */
public interface SpecialMapper 
{
    /**
     * 查询专项知识库
     * 
     * @param informid 专项知识库主键
     * @return 专项知识库
     */
    public Special selectSpecialByInformid(Integer informid);

    /**
     * 查询专项知识库列表
     * 
     * @param special 专项知识库
     * @return 专项知识库集合
     */
    public List<Special> selectSpecialList(Special special);

    /**
     * 新增专项知识库
     * 
     * @param special 专项知识库
     * @return 结果
     */
    public int insertSpecial(Special special);

    /**
     * 修改专项知识库
     * 
     * @param special 专项知识库
     * @return 结果
     */
    public int updateSpecial(Special special);

    /**
     * 删除专项知识库
     * 
     * @param informid 专项知识库主键
     * @return 结果
     */
    public int deleteSpecialByInformid(Integer informid);

    /**
     * 批量删除专项知识库
     * 
     * @param informids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpecialByInformids(Integer[] informids);
}

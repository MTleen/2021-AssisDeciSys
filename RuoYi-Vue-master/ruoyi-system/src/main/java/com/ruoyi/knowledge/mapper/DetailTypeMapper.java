package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.DetailType;

/**
 * 详细类型表Mapper接口
 * 
 * @author xiaoyu
 * @date 2021-10-14
 */
public interface DetailTypeMapper 
{
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
     * 删除详细类型表
     * 
     * @param typeid 详细类型表主键
     * @return 结果
     */
    public int deleteDetailTypeByTypeid(Long typeid);

    /**
     * 批量删除详细类型表
     * 
     * @param typeids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDetailTypeByTypeids(Long[] typeids);
}

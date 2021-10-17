package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Label4;

/**
 * 四级标签Mapper接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface Label4Mapper 
{
    /**
     * 查询四级标签
     * 
     * @param labelid 四级标签主键
     * @return 四级标签
     */
    public Label4 selectLabel4ByLabelid(Long labelid);

    /**
     * 查询四级标签列表
     * 
     * @param label4 四级标签
     * @return 四级标签集合
     */
    public List<Label4> selectLabel4List(Label4 label4);

    /**
     * 新增四级标签
     * 
     * @param label4 四级标签
     * @return 结果
     */
    public int insertLabel4(Label4 label4);

    /**
     * 修改四级标签
     * 
     * @param label4 四级标签
     * @return 结果
     */
    public int updateLabel4(Label4 label4);

    /**
     * 删除四级标签
     * 
     * @param labelid 四级标签主键
     * @return 结果
     */
    public int deleteLabel4ByLabelid(Long labelid);

    /**
     * 批量删除四级标签
     * 
     * @param labelids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLabel4ByLabelids(Long[] labelids);
}

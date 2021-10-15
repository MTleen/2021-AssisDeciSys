package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.Label4Mapper;
import com.ruoyi.knowledge.domain.Label4;
import com.ruoyi.knowledge.service.ILabel4Service;

/**
 * 四级标签Service业务层处理
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@Service
public class Label4ServiceImpl implements ILabel4Service 
{
    @Autowired
    private Label4Mapper label4Mapper;

    /**
     * 查询四级标签
     * 
     * @param labelid 四级标签主键
     * @return 四级标签
     */
    @Override
    public Label4 selectLabel4ByLabelid(Long labelid)
    {
        return label4Mapper.selectLabel4ByLabelid(labelid);
    }

    /**
     * 查询四级标签列表
     * 
     * @param label4 四级标签
     * @return 四级标签
     */
    @Override
    public List<Label4> selectLabel4List(Label4 label4)
    {
        return label4Mapper.selectLabel4List(label4);
    }

    /**
     * 新增四级标签
     * 
     * @param label4 四级标签
     * @return 结果
     */
    @Override
    public int insertLabel4(Label4 label4)
    {
        return label4Mapper.insertLabel4(label4);
    }

    /**
     * 修改四级标签
     * 
     * @param label4 四级标签
     * @return 结果
     */
    @Override
    public int updateLabel4(Label4 label4)
    {
        return label4Mapper.updateLabel4(label4);
    }

    /**
     * 批量删除四级标签
     * 
     * @param labelids 需要删除的四级标签主键
     * @return 结果
     */
    @Override
    public int deleteLabel4ByLabelids(Long[] labelids)
    {
        return label4Mapper.deleteLabel4ByLabelids(labelids);
    }

    /**
     * 删除四级标签信息
     * 
     * @param labelid 四级标签主键
     * @return 结果
     */
    @Override
    public int deleteLabel4ByLabelid(Long labelid)
    {
        return label4Mapper.deleteLabel4ByLabelid(labelid);
    }
}

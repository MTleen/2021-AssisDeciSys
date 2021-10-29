package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.domain.Kwords;
import com.ruoyi.knowledge.domain.Rule;

/**
 * 提示信息表Mapper接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface KnowledgeMapper 
{
    /**
     * 查询提示信息表
     * 
     * @param informid 提示信息表主键
     * @return 提示信息表
     */
    public Knowledge selectKnowledgeByInformid(Long informid);

    /**
     * 查询提示信息表列表
     * 
     * @param knowledge 提示信息表
     * @return 提示信息表集合
     */
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge);

    /**
     * 查询提示信息表列表
     * 
     * @return 提规则表集合
     */
    public List<Rule> selectRuleList();

    /**
     * 匹配提示信息
     * 
     * @param Kwrods 提示信息表
     * @return 提示信息表集合
     */
    public List<Knowledge> matchKnowledgeList(Kwords kwords);

    /**
     * 新增提示信息表
     * 
     * @param knowledge 提示信息表
     * @return 结果
     */
    public int insertKnowledge(Knowledge knowledge);

    /**
     * 修改提示信息表
     * 
     * @param knowledge 提示信息表
     * @return 结果
     */
    public int updateKnowledge(Knowledge knowledge);

    /**
     * 删除提示信息表
     * 
     * @param informid 提示信息表主键
     * @return 结果
     */
    public int deleteKnowledgeByInformid(Long informid);

    /**
     * 批量删除提示信息表
     * 
     * @param informids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKnowledgeByInformids(Long[] informids);
}

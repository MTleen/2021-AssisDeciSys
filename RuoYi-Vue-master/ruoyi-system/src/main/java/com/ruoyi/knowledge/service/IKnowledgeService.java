package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.domain.Kwords;

/**
 * 提示信息表Service接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface IKnowledgeService 
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
     * @return 规则表集合
     */
    public List<Rule> selectRuleList();
    
    /**
     * 匹配提示信息表
     * 
     * @param kwords 提示信息表
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
     * 批量删除提示信息表
     * 
     * @param informids 需要删除的提示信息表主键集合
     * @return 结果
     */
    public int deleteKnowledgeByInformids(Long[] informids);

    /**
     * 删除提示信息表信息
     * 
     * @param informid 提示信息表主键
     * @return 结果
     */
    public int deleteKnowledgeByInformid(Long informid);
}

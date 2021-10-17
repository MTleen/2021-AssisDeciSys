package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Rule;

/**
 * 规则表Mapper接口
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
public interface RuleMapper 
{
    /**
     * 查询规则表
     * 
     * @param ruleid 规则表主键
     * @return 规则表
     */
    public Rule selectRuleByRuleid(Long ruleid);

    /**
     * 查询规则表列表
     * 
     * @param rule 规则表
     * @return 规则表集合
     */
    public List<Rule> selectRuleList(Rule rule);

    /**
     * 新增规则表
     * 
     * @param rule 规则表
     * @return 结果
     */
    public int insertRule(Rule rule);

    /**
     * 修改规则表
     * 
     * @param rule 规则表
     * @return 结果
     */
    public int updateRule(Rule rule);

    /**
     * 删除规则表
     * 
     * @param ruleid 规则表主键
     * @return 结果
     */
    public int deleteRuleByRuleid(Long ruleid);

    /**
     * 批量删除规则表
     * 
     * @param ruleids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRuleByRuleids(Long[] ruleids);
}

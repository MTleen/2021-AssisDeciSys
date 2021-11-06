package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Rule;

/**
 * 发送规则Mapper接口
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public interface RuleMapper
{
    /**
     * 查询发送规则
     *
     * @param ruleid 发送规则主键
     * @return 发送规则
     */
    public Rule selectRuleByRuleid(Long ruleid);

    /**
     * 查询发送规则列表
     *
     * @param rule 发送规则
     * @return 发送规则集合
     */
    public List<Rule> selectRuleList(Rule rule);

    /**
     * 新增发送规则
     *
     * @param rule 发送规则
     * @return 结果
     */
    public int insertRule(Rule rule);

    /**
     * 修改发送规则
     *
     * @param rule 发送规则
     * @return 结果
     */
    public int updateRule(Rule rule);

    /**
     * 删除发送规则
     *
     * @param ruleid 发送规则主键
     * @return 结果
     */
    public int deleteRuleByRuleid(Long ruleid);

    /**
     * 批量删除发送规则
     *
     * @param ruleids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRuleByRuleids(Long[] ruleids);
}
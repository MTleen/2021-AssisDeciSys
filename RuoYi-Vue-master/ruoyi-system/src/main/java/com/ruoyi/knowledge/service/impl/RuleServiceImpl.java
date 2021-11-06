package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.RuleMapper;
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.service.IRuleService;

/**
 * 发送规则Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-06
 */
@Service
public class RuleServiceImpl implements IRuleService
{
    @Autowired
    private RuleMapper ruleMapper;

    /**
     * 查询发送规则
     *
     * @param ruleid 发送规则主键
     * @return 发送规则
     */
    @Override
    public Rule selectRuleByRuleid(Long ruleid)
    {
        return ruleMapper.selectRuleByRuleid(ruleid);
    }

    /**
     * 查询发送规则列表
     *
     * @param rule 发送规则
     * @return 发送规则
     */
    @Override
    public List<Rule> selectRuleList(Rule rule)
    {
        return ruleMapper.selectRuleList(rule);
    }

    /**
     * 新增发送规则
     *
     * @param rule 发送规则
     * @return 结果
     */
    @Override
    public int insertRule(Rule rule)
    {
        return ruleMapper.insertRule(rule);
    }

    /**
     * 修改发送规则
     *
     * @param rule 发送规则
     * @return 结果
     */
    @Override
    public int updateRule(Rule rule)
    {
        return ruleMapper.updateRule(rule);
    }

    /**
     * 批量删除发送规则
     *
     * @param ruleids 需要删除的发送规则主键
     * @return 结果
     */
    @Override
    public int deleteRuleByRuleids(Long[] ruleids)
    {
        return ruleMapper.deleteRuleByRuleids(ruleids);
    }

    /**
     * 删除发送规则信息
     *
     * @param ruleid 发送规则主键
     * @return 结果
     */
    @Override
    public int deleteRuleByRuleid(Long ruleid)
    {
        return ruleMapper.deleteRuleByRuleid(ruleid);
    }
}
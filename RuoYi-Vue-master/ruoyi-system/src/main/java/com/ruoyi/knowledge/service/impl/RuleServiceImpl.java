package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.RuleMapper;
import com.ruoyi.knowledge.domain.Rule;
import com.ruoyi.knowledge.service.IRuleService;

/**
 * 规则表Service业务层处理
 * 
 * @author xiaoyu
 * @date 2021-10-15
 */
@Service
public class RuleServiceImpl implements IRuleService 
{
    @Autowired
    private RuleMapper ruleMapper;

    /**
     * 查询规则表
     * 
     * @param ruleid 规则表主键
     * @return 规则表
     */
    @Override
    public Rule selectRuleByRuleid(Long ruleid)
    {
        return ruleMapper.selectRuleByRuleid(ruleid);
    }

    /**
     * 查询规则表列表
     * 
     * @param rule 规则表
     * @return 规则表
     */
    @Override
    public List<Rule> selectRuleList(Rule rule)
    {
        return ruleMapper.selectRuleList(rule);
    }

    /**
     * 新增规则表
     * 
     * @param rule 规则表
     * @return 结果
     */
    @Override
    public int insertRule(Rule rule)
    {
        return ruleMapper.insertRule(rule);
    }

    /**
     * 修改规则表
     * 
     * @param rule 规则表
     * @return 结果
     */
    @Override
    public int updateRule(Rule rule)
    {
        return ruleMapper.updateRule(rule);
    }

    /**
     * 批量删除规则表
     * 
     * @param ruleids 需要删除的规则表主键
     * @return 结果
     */
    @Override
    public int deleteRuleByRuleids(Long[] ruleids)
    {
        return ruleMapper.deleteRuleByRuleids(ruleids);
    }

    /**
     * 删除规则表信息
     * 
     * @param ruleid 规则表主键
     * @return 结果
     */
    @Override
    public int deleteRuleByRuleid(Long ruleid)
    {
        return ruleMapper.deleteRuleByRuleid(ruleid);
    }
}

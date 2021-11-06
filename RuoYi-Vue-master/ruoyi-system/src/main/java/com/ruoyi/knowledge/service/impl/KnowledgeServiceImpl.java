package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.KnowledgeMapper;
import com.ruoyi.knowledge.domain.Knowledge;
import com.ruoyi.knowledge.service.IKnowledgeService;

/**
 * 通用知识库Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-06
 */
@Service
public class KnowledgeServiceImpl implements IKnowledgeService
{
    @Autowired
    private KnowledgeMapper knowledgeMapper;

    /**
     * 查询通用知识库
     *
     * @param informid 通用知识库主键
     * @return 通用知识库
     */
    @Override
    public Knowledge selectKnowledgeByInformid(Long informid)
    {
        return knowledgeMapper.selectKnowledgeByInformid(informid);
    }

    /**
     * 查询通用知识库列表
     *
     * @param knowledge 通用知识库
     * @return 通用知识库
     */
    @Override
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge)
    {
        return knowledgeMapper.selectKnowledgeList(knowledge);
    }

    /**
     * 新增通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    @Override
    public int insertKnowledge(Knowledge knowledge)
    {
        return knowledgeMapper.insertKnowledge(knowledge);
    }

    /**
     * 修改通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    @Override
    public int updateKnowledge(Knowledge knowledge)
    {
        return knowledgeMapper.updateKnowledge(knowledge);
    }

    /**
     * 批量删除通用知识库
     *
     * @param informids 需要删除的通用知识库主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeByInformids(Long[] informids)
    {
        return knowledgeMapper.deleteKnowledgeByInformids(informids);
    }

    /**
     * 删除通用知识库信息
     *
     * @param informid 通用知识库主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeByInformid(Long informid)
    {
        return knowledgeMapper.deleteKnowledgeByInformid(informid);
    }
}
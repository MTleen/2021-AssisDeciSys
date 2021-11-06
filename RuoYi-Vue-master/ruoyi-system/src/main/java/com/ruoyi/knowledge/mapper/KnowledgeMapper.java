package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Knowledge;

/**
 * 通用知识库Mapper接口
 *
 * @author Mathripper
 * @date 2021-11-06
 */
public interface KnowledgeMapper
{
    /**
     * 查询通用知识库
     *
     * @param informid 通用知识库主键
     * @return 通用知识库
     */
    public Knowledge selectKnowledgeByInformid(Long informid);

    /**
     * 查询通用知识库列表
     *
     * @param knowledge 通用知识库
     * @return 通用知识库集合
     */
    public List<Knowledge> selectKnowledgeList(Knowledge knowledge);

    /**
     * 新增通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    public int insertKnowledge(Knowledge knowledge);

    /**
     * 修改通用知识库
     *
     * @param knowledge 通用知识库
     * @return 结果
     */
    public int updateKnowledge(Knowledge knowledge);

    /**
     * 删除通用知识库
     *
     * @param informid 通用知识库主键
     * @return 结果
     */
    public int deleteKnowledgeByInformid(Long informid);

    /**
     * 批量删除通用知识库
     *
     * @param informids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKnowledgeByInformids(Long[] informids);
}
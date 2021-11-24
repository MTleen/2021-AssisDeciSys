package com.ruoyi.knowledge.mapper;

import java.util.Date;
import java.util.List;

import com.ruoyi.knowledge.domain.*;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 小程序查询
     *
     *
     * @return 结果
     */
    public String selecttelebyOpenID(@Param("openid") String openid);
    public Boolean selectStatusbyCaution(@Param("cautionid") String cautionid);
    public List<History> selectLibrarybyCaution(@Param("cautionid") String cautionid,@Param("tele") String tele,@Param("sendtime") Date sendtime);
    public List<History> selectCautionbytele(@Param("tele") String tele);
    public String selectDisaster(@Param("disastertype") String disastertype);
    public List<History> selectInformIDbytele(@Param("tele") String tele, @Param("cautionid") String cautionid,@Param("sendtime") Date sendtime,@Param("library") Integer library);
    public List<History> selectInformIDbycau(@Param("tele") String tele, @Param("cautionid") String cautionid,@Param("sendtime") Date sendtime,@Param("library") Integer library);
    public List<History> selectInformIDbytele1(@Param("tele") String tele, @Param("cautionid") String cautionid, @Param("sendtime") Date sendtime,@Param("library") Integer library);
    public List<Knowledge> selectKnow1(@Param("informid") Long informid);
    public List<Security> selectKnow2(@Param("informid") Long informid);
    public List<Record> selectRecord1(@Param("tele") String tele, @Param("sendtime1") Date sendtime1);
    public List<Record> selectRecord2(@Param("cautionid") String cautionid);
}
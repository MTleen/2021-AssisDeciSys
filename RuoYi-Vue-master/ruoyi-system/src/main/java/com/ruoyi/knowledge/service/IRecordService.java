package com.ruoyi.knowledge.service;

import java.util.List;
import com.ruoyi.knowledge.domain.Record;

/**
 * 出警记录表Service接口
 *
 * @author Mathripper
 * @date 2021-11-10
 */
public interface IRecordService
{
    /**
     * 查询出警记录表
     *
     * @param cautionid 出警记录表主键
     * @return 出警记录表
     */
    public Record selectRecordByCautionid(String cautionid);

    /**
     * 查询出警记录表列表
     *
     * @param record 出警记录表
     * @return 出警记录表集合
     */
    public List<Record> selectRecordList(Record record);

    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    public int insertRecord(Record record);

    /**
     * 修改出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    public int updateRecord(Record record);

    /**
     * 批量删除出警记录表
     *
     * @param cautionids 需要删除的出警记录表主键集合
     * @return 结果
     */
    public int deleteRecordByCautionids(String[] cautionids);

    /**
     * 删除出警记录表信息
     *
     * @param cautionid 出警记录表主键
     * @return 结果
     */
    public int deleteRecordByCautionid(String cautionid);

    /**
     * 循环更新 ForceInvolve 表
     *
     * @param record 出警记录
     */
    public void updateForceInvolveLoop(Record record);
}
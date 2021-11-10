package com.ruoyi.knowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.knowledge.mapper.RecordMapper;
import com.ruoyi.knowledge.domain.Record;
import com.ruoyi.knowledge.service.IRecordService;

/**
 * 出警记录表Service业务层处理
 *
 * @author Mathripper
 * @date 2021-11-10
 */
@Service
public class RecordServiceImpl implements IRecordService
{
    @Autowired
    private RecordMapper recordMapper;

    /**
     * 查询出警记录表
     *
     * @param cautionid 出警记录表主键
     * @return 出警记录表
     */
    @Override
    public Record selectRecordByCautionid(String cautionid)
    {
        return recordMapper.selectRecordByCautionid(cautionid);
    }

    /**
     * 查询出警记录表列表
     *
     * @param record 出警记录表
     * @return 出警记录表
     */
    @Override
    public List<Record> selectRecordList(Record record)
    {
        return recordMapper.selectRecordList(record);
    }

    /**
     * 新增出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    @Override
    public int insertRecord(Record record)
    {
        return recordMapper.insertRecord(record);
    }

    /**
     * 修改出警记录表
     *
     * @param record 出警记录表
     * @return 结果
     */
    @Override
    public int updateRecord(Record record)
    {
        return recordMapper.updateRecord(record);
    }

    /**
     * 批量删除出警记录表
     *
     * @param cautionids 需要删除的出警记录表主键
     * @return 结果
     */
    @Override
    public int deleteRecordByCautionids(String[] cautionids)
    {
        return recordMapper.deleteRecordByCautionids(cautionids);
    }

    /**
     * 删除出警记录表信息
     *
     * @param cautionid 出警记录表主键
     * @return 结果
     */
    @Override
    public int deleteRecordByCautionid(String cautionid)
    {
        return recordMapper.deleteRecordByCautionid(cautionid);
    }
}
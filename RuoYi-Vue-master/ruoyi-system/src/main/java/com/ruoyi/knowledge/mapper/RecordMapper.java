package com.ruoyi.knowledge.mapper;

import java.util.List;
import com.ruoyi.knowledge.domain.Record;

/**
 * 出警记录表Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-15
 */
public interface RecordMapper 
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
     * 删除出警记录表
     * 
     * @param cautionid 出警记录表主键
     * @return 结果
     */
    public int deleteRecordByCautionid(String cautionid);

    /**
     * 批量删除出警记录表
     * 
     * @param cautionids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecordByCautionids(String[] cautionids);
}

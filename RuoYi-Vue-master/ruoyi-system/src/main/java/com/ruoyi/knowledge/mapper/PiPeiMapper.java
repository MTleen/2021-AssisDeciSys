package com.ruoyi.knowledge.mapper;

import com.ruoyi.knowledge.domain.PiPei;

import java.util.List;


/**
 * 出警记录表Mapper接口
 *
 * @author ruoyi
 * @date 2021-10-15
 */
public interface PiPeiMapper {


        /**
         * 查询出警记录表列表
         *
         * @param pipei 出警记录表
         * @return 出警记录表集合
         */
        public List<PiPei> selectPiPeiList(PiPei pipei);

        /**
         * 新增出警记录表
         *
         * @param pipei 出警记录表
         * @return 结果
         */
        public int insertPiPei(PiPei pipei);

        /**
         * 修改出警记录表
         *
         * @param pipei 出警记录表
         * @return 结果
         */
        public int updatePiPei(PiPei pipei);


    }





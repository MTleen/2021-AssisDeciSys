<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple-dark" align='center'>
          <div class="block">
            <el-date-picker
              v-model="value2"
              type="daterange"
              align="right"
              unlink-panels
              range-separator="至"
              start-placeholder="开始日期"
              end-placeholder="结束日期"
              :picker-options="pickerOptions">
            </el-date-picker>
            <el-radio-group v-model="AllOrPart" style="margin-left:15px;">
              <el-radio-button label="全部"></el-radio-button>
              <el-radio-button label="已处理"></el-radio-button>
              <el-radio-button label="未处理"></el-radio-button>
            </el-radio-group>
          </div>
        </div>

      </el-col>
    </el-row>

    <div style="margin-top: 20px; background: white;padding: 20px 20px 30px 30px;">
      <el-row :gutter="40">
        <el-col :span="14">
          <div class="grid-content bg-purple">
            <el-table :v-loading="loading" :data="recordList" stripe height="900" :header-cell-style="tableHeaderColor">
              <el-table-column label="序号" align="center" type="index"></el-table-column>
              <el-table-column label="案件编号" align="center" prop="cautionid" width='80'>
              </el-table-column>
              <el-table-column label="灾情类型" align="center" prop="distypeid" width='120'>
                <template slot-scope="scope">
                  {{$root.totalDisType[scope.row.distypeid]}}
                </template>
              </el-table-column>
              <el-table-column label="案发地址" align="center" prop="location" :show-overflow-tooltip="false">
              </el-table-column>
              <el-table-column label="立案时间" align="center" prop="cautiontime" width="180">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.cautiontime) }}</span>
                </template>
              </el-table-column>
              <el-table-column label="状态" align="center" prop="status" width='120'>
                <!-- <template slot-scope="scope">
                  <dict-tag :options="statusOptions" :value="scope.row.status"/>
                </template> -->
              </el-table-column>
              <el-table-column fixed="right" label="操作" align="center" width='150'
                               class-name="small-padding fixed-width">
                <template slot-scope="scope">
                  <el-button
                    size="mini"
                    type="primary"
                    class="btn-style">推送
                  </el-button>
                  <el-button size="mini" type="success" class="btn-style" @click="handleHisQuery(scope.row.cautionid)">
                    查看
                  </el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
          <div class="block" style="margin-top: 30px;float:right">
            <el-pagination
              v-show="total>0"
              :total="total"
              :page.sync="recordQueryParams.pageNum"
              :limit.sync="recordQueryParams.pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              @pagination="listRecordInfo">
            </el-pagination>
          </div>
        </el-col>

        <el-col :span="10">
          <div class="grid-content bg-purple">
            <el-table :v-loading="hisLoading" :data="historyList" stripe height="900"
                      :header-cell-style="tableHeaderColor">
              <el-table-column label="序号" align="center" type="index"/>
              <el-table-column label="提示信息" align="center" prop="informid"/>
              <el-table-column label="推送对象" align="center" prop="positionid">
                <template slot-scope="scope">
                  <span>{{ $root.totalSites[scope.row.positionid] + "/" + scope.row.tele}}</span>
                </template>
              </el-table-column>
              <el-table-column label="发送时间" align="center" prop="sendtime" width="180">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.sendtime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
                </template>
              </el-table-column>
              <el-table-column label="知识类型" align="center" prop="librarytype">
                <template slot-scope="scope">
                  <span>{{ $root.totalLibType[scope.row.librarytype] }}</span>
                </template>
              </el-table-column>
              <!--              <el-table-column label="序号" align="center" prop="caseNumber" width="60">-->
              <!--              </el-table-column>-->
              <!--              <el-table-column label="人员" align="center" prop="casePerson" width='100'>-->
              <!--              </el-table-column>-->
              <!--              <el-table-column label="全部" align="center" prop="caseIcon" width='80'-->
              <!--                               :filters="[{text:'指挥员', value:'1'},{text:'司通员', value:'2'},{text:'战斗员', value:'3'}]"-->
              <!--                               :filter-method="filterTag"-->
              <!--              >-->
              <!--                <template slot-scope="scope">-->
              <!--                  <i class='el-icon-question' v-if="scope.row.caseIcon === '1'">-->
              <!--                  </i>-->
              <!--                  <i class='el-icon-message-solid' v-if="scope.row.caseIcon === '2'">-->
              <!--                  </i>-->
              <!--                  <i class='el-icon-s-management' v-if="scope.row.caseIcon === '3'">-->
              <!--                  </i>-->
              <!--                </template>-->
              <!--              </el-table-column>-->
              <!--              <el-table-column label="内容详情" align="center" prop="caseContent">-->
              <!--              </el-table-column>-->
            </el-table>
          </div>
        </el-col>
      </el-row>

    </div>


  </div>


</template>
<script>
import {listHistory, getHistory, delHistory, addHistory, updateHistory, exportHistory} from "@/api/knowledge/history";
import {listRecord, getRecord, delRecord, addRecord, updateRecord, exportRecord} from "@/api/knowledge/record";
import history from "@/views/knowledge/history"

export default {
  data() {
    return {
      AllOrPart: '全部',
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        cautionid: null,
        positionid: null,
        sendtime: null,
        librarytype: null
      },
      recordQueryParams: {
        pageNum: 1,
        pageSize: 10,
        cautiontime: null,
        location: null,
        distypeid: null,
        dillobject: null,
        siteid: null,
        truckid: null,
        status: null,
        keywords: null,
        siteid2: null
      },
      historyList: [],
      recordList: [],
      loading: false,
      hisLoading: false,
      typeList: [{
        cautionID: '1',
        caseType: '火灾',
        caseAdress: '上海市普陀区',
        createTime: '2021-10-9',
        status: '待处理',
      }],
      total: 0,
      hisTotal: 0,
      pickerOptions: {
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
            picker.$emit('pick', [start, end]);
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
            picker.$emit('pick', [start, end]);
          }
        }]
      },
      value1: '',
      value2: ''
    };
  },
  created() {
    this.handleRecordQuery()
  },
  methods: {
    filterTag(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    //设置表头行的样式
    tableHeaderColor({row, column, rowIndex, columnIndex}) {
      return 'background-color:rgb(145, 211, 252);color:black;font-wight:500;text-align:center'
    },
    handleRecordQuery(){
      this.recordQueryParams.pageNum = 1
      this.listRecordInfo()
    },
    handleHisQuery(cautionID) {
      this.queryParams.cautionid = cautionID
      this.queryParams.pageNum = 1
      this.listHisInfo()
    },
    listHisInfo() {
      this.hisLoading = true;
      listHistory(this.queryParams).then(response => {
        this.historyList = response.rows;
        this.hisTotal = response.total;
        this.hisLoading = false;
      });
    },
    listRecordInfo(){
      this.loading = true
      listRecord(this.recordQueryParams).then(response => {
        this.recordList = response.rows
        this.total = response.total
        this.loading = false
      })
    }
  }
}
</script>
<style>
</style>

}
};
<style>

.btn-style {
  min-width: 50px;
  min-height: 25px;
}
</style>

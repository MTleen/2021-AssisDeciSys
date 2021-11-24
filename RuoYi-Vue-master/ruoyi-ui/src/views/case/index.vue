<template>
  <div class="app-container">
    <el-row>
      <el-col :span="24">
        <div class="grid-content bg-purple-dark" align='center'>
          <div class="block">
            <CusDatePicker :sendtimes="sendtimes" @change="handleChange"></CusDatePicker>
            <el-radio-group v-model="AllOrPart" style="margin-left:15px;">
              <el-radio-button label="全部"></el-radio-button>
              <el-radio-button label="已处理"></el-radio-button>
              <el-radio-button label="未处理"></el-radio-button>
            </el-radio-group>
          </div>
        </div>

      </el-col>
    </el-row>

    <div style="margin-top: 20px; background: white; padding: 20px 20px 30px 30px;">
      <el-row :gutter="40">
        <el-col :span="13">
          <div class="grid-content bg-purple">
            <div class="table-height">
            <el-table :v-loading="loading" :data="recordList" stripe max-height="100%" :header-cell-style="tableHeaderColor">
              <el-table-column label="序号" align="center" type="index"></el-table-column>
              <el-table-column label="案件编号" align="center" prop="cautionid" width='80'>
              </el-table-column>
              <el-table-column label="灾情类型" align="center" prop="distypeid" width='120'>
                <template slot-scope="scope">
                  {{ $root.totalDisType[scope.row.distypeid] }}
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
                    class="btn-style"
                    @click="handleSendInfo(scope.row)">推送
                  </el-button>
                  <el-button size="mini" type="success" class="btn-style" @click="handleHisQuery(scope.row.cautionid)">
                    查看
                  </el-button>
                </template>
              </el-table-column>
            </el-table>
            </div>
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

        <el-col :span="11">
          <div class="grid-content bg-purple">
            <el-table :v-loading="hisLoading" :data="historyList" stripe
                      :header-cell-style="tableHeaderColor" max-height="600" >
              <el-table-column label="序号" align="center" type="index"/>
              <el-table-column label="提示信息" align="left" prop="informid"/>
              <el-table-column label="推送对象" align="center" prop="positionid" width="150">
                <template slot-scope="scope">
                  <span>{{ $root.totalSites[scope.row.positionid] + "/" + scope.row.tele }}</span>
                </template>
              </el-table-column>
              <el-table-column label="发送时间" align="center" prop="sendtime" width="150">
                <template slot-scope="scope">
                  <span>{{ parseTime(scope.row.sendtime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
                </template>
              </el-table-column>
              <el-table-column label="知识类型" align="center" prop="librarytype" width="100">
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
import {listHistory} from "@/api/knowledge/history";
import {listRecord} from "@/api/knowledge/record";

export default {
  data() {
    return {
      AllOrPart: '全部',
      sendtimes: [],
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
        cautiontimeStart: null,
        cautiontimeEnd: null,
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
      value1: '',
      value2: ''
    };
  },
  created() {
    this.handleRecordQuery()
  },
  methods: {
    handleChange(val){
      this.sendtimes = val
      this.handleRecordQuery()
    },
    filterTag(value, row, column) {
      const property = column['property'];
      return row[property] === value;
    },
    //设置表头行的样式
    tableHeaderColor({row, column, rowIndex, columnIndex}) {
      return 'background-color:rgb(167, 196, 237);color:black;font-wight:500;text-align:center'
    },
    handleRecordQuery() {
      this.recordQueryParams.pageNum = 1
      if (this.sendtimes && this.sendtimes.length > 0){
        this.recordQueryParams.cautiontimeStart = this.sendtimes[0]
        this.recordQueryParams.cautiontimeEnd = this.sendtimes[1]
      }else{
        this.recordQueryParams.cautiontimeStart = null
        this.recordQueryParams.cautiontimeEnd = null
      }
      this.listRecordInfo()
    },
    handleHisQuery(cautionID) {
      this.queryParams.cautionid = cautionID
      this.queryParams.pageNum = 1
      this.listHisInfo()
    },
    handleSendInfo(caution) {
      console.log(caution)
      console.log(this.$router)
      caution.cautiontime = Date.parse(caution.cautiontime)
      this.$router.push({path: '/index', query: caution})
    },
    listHisInfo() {
      this.hisLoading = true;
      listHistory(this.queryParams).then(response => {
        this.historyList = response.rows;
        this.hisTotal = response.total;
        this.hisLoading = false;
      });
    },
    listRecordInfo() {
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
.table-height{
   max-height: calc(65vh);
}
.btn-style {
  min-width: 50px;
  min-height: 25px;
}
</style>

<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-position="right"
             label-width="98px">


      <el-form-item label="地址" prop="location">
        <el-input
          v-model="queryParams.location"
          placeholder="请输入地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="灾情类型" prop="distypeid">
        <el-select v-model="queryParams.distypeid" placeholder="请选择灾情类型" clearable size="small">
          <el-option v-for="(value, key, index) in $root.totalDisType"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="处置对象" prop="dillobject">
        <el-select v-model="queryParams.dillobject" placeholder="请选择处置对象" clearable size="small">
          <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="详细类型" prop="typename">
        <el-select v-model="queryParams.detailtype" filterable placeholder="请选择详细类型" clearable size="small">
          <el-option v-for="(value, key, index) in totalDetailType"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="主管队站" prop="siteid">
        <el-select v-model="queryParams.siteid" placeholder="请选择主管队站" clearable size="small">
          <el-option v-for="(value, key, index) in $root.totalSites"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="参战力量" prop="siteid2">
        <el-select v-model="queryParams.siteid2List" placeholder="请选择参战力量" clearable multiple size="small">
          <el-option v-for="(value, key, index) in $root.totalSites"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="任务执行状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择任务执行状态" clearable size="small">
          <el-option v-for="(value, key, index) in cautionStatus"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="关键词" prop="keywords">
        <el-input
          v-model="queryParams.keywords"
          placeholder="请输入关键词"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="时间" prop="cautiontime">
        <!--        <el-date-picker clearable size="small"-->
        <!--                        v-model="queryParams.cautiontime"-->
        <!--                        type="date"-->
        <!--                        value-format="yyyy-MM-dd"-->
        <!--                        placeholder="选择时间">-->
        <!--        </el-date-picker>-->
        <CusDatePicker :sendtimes="sendtimes" @change="handleChange"></CusDatePicker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          disabled
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['knowledge:record:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['knowledge:record:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['knowledge:record:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['knowledge:record:export']"
        >导出
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          :disabled="ids.length === 0"
          type="success"
          plain
          size="mini"
          circle
          icon="el-icon-check"
          @click="handleComplete"
          v-hasPermi="['knowledge:record:edit']"
        ></el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="recordList" border @selection-change="handleSelectionChange"
              :row-class-name="tableRowClassName">
      <el-table-column type="selection" width="45" align="center"  />
      <el-table-column label="序号" align="center" type="index" width="50"></el-table-column>
      <el-table-column label="报警编号" align="center" prop="cautionid" width="75"/>
      <el-table-column label="时间" align="center" prop="cautiontime" width="160" sortable>
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.cautiontime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="地址" align="center" prop="location"/>
      <el-table-column label="灾情类型" align="center" prop="distypeid" width="75">
        <template slot-scope="scope">
          <span>{{ $root.totalDisType[scope.row.distypeid] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="处置对象" align="center" prop="dillobject">
        <template slot-scope="scope">
          <span>{{ $root.totalDisposeObj[scope.row.dillobject] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="详细类型" align="center" prop="detailtype">
        <template slot-scope="scope">
          <span>{{ totalDetailType[scope.row.detailtype] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="主管队站" align="center" prop="siteid" width="75">
        <template slot-scope="scope">
          <span>{{ $root.totalSites[scope.row.siteid] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="参战力量" align="center" prop="siteid2">
        <template slot-scope="scope">
          <span>{{ $root.parseString(scope.row.siteid2, $root.totalSites) }}</span>
        </template>
      </el-table-column>
      <!--      <el-table-column label="  出警车辆" align="center" prop="truckid" />-->
      <el-table-column label="任务执行状态" align="center" prop="status" width="100">
        <template slot-scope="scope">
          <span>{{ cautionStatus[scope.row.status] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="关键词" align="center" prop="keywords" />
      <el-table-column label="操作" align="center"  width="130" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            style="margin-left: 10px"
            size="mini"
            type="text"
            icon="el-icon-s-promotion"
            @click="handleSendInfo(scope.row)"
            v-hasPermi="['knowledge:record:edit']"
          >推送
          </el-button>
          <el-button
            style="margin-right: 10px"
            size="mini"
            type="text"
            icon="el-icon-message-solid"
            @click="handleHisQuery(scope.row.cautionid)"
            v-hasPermi="['knowledge:record:edit']"
          >查看
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['knowledge:record:edit']"
          >修改
          </el-button>
          <el-button
            style="margin-right: 10px"
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['knowledge:record:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <!--    <Pagination :total="total"></Pagination>-->

    <!-- 添加或修改出警记录表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px" style="width: 319px">
        <el-form-item label="时间" prop="cautiontime">
          <el-date-picker clearable size="small"
                          v-model="form.cautiontime"
                          type="datetime"
                          value-format="yyyy-MM-dd HH:mm:ss"
                          placeholder="选择时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="地址" prop="location">
          <el-input v-model="form.location" type="textarea"  autosize placeholder="请输入地址"/>
        </el-form-item>
        <el-form-item label="灾情类型" prop="distypeid">
          <el-select v-model="form.distypeid" placeholder="请选择灾情类型">
            <el-option v-for="(value, key, index) in $root.totalDisType"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="处置对象" prop="dillobject">
          <el-select v-model="form.dillobject" placeholder="请选择处置对象">
            <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="详细类型" prop="typename">
          <el-select v-model="form.detailtype" filterable placeholder="请选择详细类型" clearable>
            <el-option v-for="(value, key, index) in totalDetailType"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="主管队站" prop="siteid">
          <el-select v-model="form.siteid" placeholder="请选择主管单位">
            <el-option v-for="(value, key, index) in $root.totalSites"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="参战力量">
          <el-select v-model="form.siteid2List" placeholder="请选择参战力量" clearable multiple>
            <el-option v-for="(value, key, index) in $root.totalSites"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <!--        <el-form-item label="出警车辆" prop="truckid">-->
        <!--          <el-select v-model="form.truckid" placeholder="请选择出警车辆">-->
        <!--            <el-option label="请选择字典生成" value=""/>-->
        <!--          </el-select>-->
        <!--        </el-form-item>-->
        <el-form-item label="任务执行状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择任务执行状态">
            <el-option v-for="(value, key, index) in cautionStatus"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="关键词" prop="keywords">
          <el-input v-model="form.keywords" placeholder="请输入关键词"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!--    查看案件对应的历史发送信息-->
    <el-dialog :visible.sync="dialogTableVisible" width="70%" top:40vh center>
      <div class="grid-content bg-purple">
        <el-table :v-loading="hisLoading" :data="historyList" stripe border
                  :header-cell-style="tableHeaderColor" max-height="600">
          <el-table-column label="序号" align="center" type="index"/>
          <el-table-column label="提示信息" align="left" prop="informid"/>
          <el-table-column label="推送对象" align="center" prop="positionid" width="130">
            <template slot-scope="scope">
              <span>{{ $root.totalSites[scope.row.positionid] + "/" + scope.row.tele }}</span>
            </template>
          </el-table-column>
          <el-table-column label="发送时间" align="center" prop="sendtime" width="160">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.sendtime, '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
            </template>
          </el-table-column>
          <el-table-column label="知识类型" align="center" prop="librarytype" width="80">
            <template slot-scope="scope">
              <span>{{ $root.totalLibType[scope.row.librarytype] }}</span>
            </template>
          </el-table-column>
        </el-table>

        <pagination
          v-show="hisTotal>0"
          :total="hisTotal"
          :page.sync="hisQueryParams.pageNum"
          :limit.sync="hisQueryParams.pageSize"
          @pagination="listHisInfo"
        />
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listRecord, getRecord, delRecord, addRecord, updateRecord, exportRecord} from "@/api/knowledge/record";
import {listHistory} from "@/api/knowledge/history";
import {deepClone} from "@/utils";

export default {
  name: "Record",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 出警记录表表格数据
      recordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      sendtimes: [],
      // 查询参数
      queryParams: {
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
        siteid2: null,
        siteid2List: []
      },
      hisQueryParams: {
        pageNum: 1,
        pageSize: 20,
        positionid: null,
        sendtimeStart: null,
        sendtimeEnd: null,
        librarytype: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        cautiontime: [
          {required: true, message: "时间不能为空", trigger: "blur"}
        ],
        location: [
          {required: true, message: "地址不能为空", trigger: "blur"}
        ],
      },
      historyList: [],
      hisLoading: false,
      hisTotal: 0,
      dialogTableVisible: false,
      cautionStatus: {}
    };
  },
  computed: {
    totalDetailType: function () {
      let temp = {}
      return Object.assign(temp, this.$root.totalGeneralType, this.$root.totalSpecialType)
    }
  },
  created() {
    // 读取案件状态 dict
    this.$root.getDicts("sys_caution_status").then(response => {
      this.cautionStatus = this.$root.parseDicts(response.data)
    })
    this.getList();
  },
  methods: {
    // 接收 CusDatePicker 的日期值
    handleChange(sendtimes) {
      this.sendtimes = sendtimes
    },
    // 设置行的 highlight 显示
    tableRowClassName({row, rowIndex}) {
      if (row.status) {
        return 'success-row';
      }
      return '';
    },
    //设置表头行的样式
    tableHeaderColor({row, column, rowIndex, columnIndex}) {
      return 'background-color:rgb(167, 196, 237);color:black;font-wight:500;text-align:center'
    },
    // 二次发送信息
    handleSendInfo(caution) {
      caution.cautiontime = Date.parse(caution.cautiontime)
      this.$router.push({path: '/index', query: caution})
    },
    // 展示案件历史信息
    handleHisQuery(cautionID) {
      this.dialogTableVisible = true
      this.hisQueryParams.cautionid = cautionID
      this.hisQueryParams.pageNum = 1
      this.listHisInfo()
    },
    // 查询历史信息
    listHisInfo() {
      this.hisLoading = true;
      listHistory(this.hisQueryParams).then(response => {
        this.historyList = response.rows;
        this.hisTotal = response.total;
        this.hisLoading = false;
      });
    },
    /** 查询出警记录表列表 */
    getList() {
      this.loading = true;
      if (this.queryParams.siteid2List) {
        this.queryParams.siteid2 = this.queryParams.siteid2List.join(',')
      }
      listRecord(this.queryParams).then(response => {
        this.recordList = response.rows;
        // 把 int 类型的值转换成 str
        this.$root.num2str(this.recordList)
        console.log(this.recordList[0])
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        cautionid: null,
        cautiontime: null,
        location: null,
        distypeid: null,
        dillobject: null,
        siteid: null,
        truckid: null,
        detailtype: null,
        picture: null,
        label4: null,
        status: null,
        keywords: null,
        siteid2: null,
        siteid2List: []
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      if (this.sendtimes.length > 0) {
        this.queryParams.cautiontimeStart = this.sendtimes[0]
        this.queryParams.cautiontimeEnd = this.sendtimes[1]
      } else {
        this.queryParams.cautiontimeStart = null
        this.queryParams.cautiontimeEnd = null
      }
      // console.log(this.queryParams)
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.sendtimes = []
      this.queryParams.siteid2List = []
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.cautionid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加出警记录表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const cautionid = row.cautionid || this.ids
      getRecord(cautionid).then(response => {
        this.form = response.data;
        this.$root.num2str(this.form)
        this.open = true;
        this.title = "修改出警记录";
      });
    },
    handleComplete(){
      this.reset()
      const cautionids = this.ids
      for (let cid of cautionids){
        getRecord(cid).then(response => {
          this.form = response.data
          this.form.status = 0
          updateRecord(this.form).then(response => {
            this.open = false;
            this.getList();
          });
        })
      }
      this.msgSuccess('修改成功')
      this.ids = []
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.siteid2) {
            this.form.siteid2 = this.form.siteid2List.join(",");
          }
          if (this.form.cautionid != null) {
            updateRecord(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRecord(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const cautionids = row.cautionid || this.ids;
      this.$confirm('是否确认删除出警记录表编号为"' + cautionids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delRecord(cautionids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有出警记录表数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.exportLoading = true;
        return exportRecord(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>
<style>
.el-table .success-row {
  background: #fcf0f0;
}
</style>
<style scoped>
.el-date-editor .el-range-input {
  width: 70%;
}
</style>

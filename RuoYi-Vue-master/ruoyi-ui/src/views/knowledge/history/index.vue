<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <!--      <el-form-item label="队站" prop="positionid">-->
      <!--        <el-select-->
      <!--          v-model="queryParams.positionid"-->
      <!--          placeholder="请输入队站"-->
      <!--          filterable-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--        >-->
      <!--          <el-option v-for="(value, key, index) in $root.totalSites"-->
      <!--                     :key="key"-->
      <!--                     :label="value"-->
      <!--                     :value="key"/>-->
      <!--        </el-select>-->
      <!--      </el-form-item>-->
      <el-form-item label="发送时间" prop="sendtime">
        <CusDatePicker @change="handleChange" :sendtimes="sendtimes"></CusDatePicker>
      </el-form-item>
      <el-form-item label="知识类型" prop="librarytype">
        <el-select v-model="queryParams.librarytype" placeholder="请选择知识类型" clearable size="small">
          <el-option v-for="(value, key, index) in $root.totalLibType"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
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
          icon="el-icon-plus"
          size="mini"
          :disabled="single"
          @click="handleAdd"
          v-hasPermi="['knowledge:history:add']"
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
          v-hasPermi="['knowledge:history:edit']"
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
          v-hasPermi="['knowledge:history:remove']"
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
          v-hasPermi="['knowledge:history:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="historyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="序号" align="center" type="index" width="50"/>
      <el-table-column label="案件编号" align="center" prop="cautionid"/>
      <el-table-column label="提示信息" align="center" prop="informid"/>
      <el-table-column label="推送对象" align="center" prop="positionid">
        <template slot-scope="scope">
          <span>{{ $root.totalSites[scope.row.positionid] + "/" + scope.row.tele }}</span>
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
      <!--      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">-->
      <!--        <template slot-scope="scope">-->
      <!--          <el-button-->
      <!--            size="mini"-->
      <!--            type="text"-->
      <!--            icon="el-icon-edit"-->
      <!--            @click="handleUpdate(scope.row)"-->
      <!--            v-hasPermi="['knowledge:history:edit']"-->
      <!--          >修改-->
      <!--          </el-button>-->
      <!--          <el-button-->
      <!--            size="mini"-->
      <!--            type="text"-->
      <!--            icon="el-icon-delete"-->
      <!--            @click="handleDelete(scope.row)"-->
      <!--            v-hasPermi="['knowledge:history:remove']"-->
      <!--          >删除-->
      <!--          </el-button>-->
      <!--        </template>-->
      <!--      </el-table-column>-->
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改信息历史对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listHistory, getHistory, delHistory, addHistory, updateHistory, exportHistory} from "@/api/knowledge/history";

export default {
  name: "History",
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
      // 信息历史表格数据
      historyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      sendtimes: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        positionid: null,
        sendtimeStart: null,
        sendtimeEnd: null,
        librarytype: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询信息历史列表 */
    getList() {
      this.loading = true;
      listHistory(this.queryParams).then(response => {
        this.historyList = response.rows;
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
        index: null,
        cautionid: null,
        informid: null,
        positionid: null,
        sendtime: null,
        librarytype: null
      };
      this.resetForm("form");
    },
    // 接收 CusDatePicker 的日期值
    handleChange(sendtimes){
      this.sendtimes = sendtimes
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      if (this.sendtimes.length > 0){
        this.queryParams.sendtimeStart = this.sendtimes[0]
        this.queryParams.sendtimeEnd = this.sendtimes[1]
      }else{
        this.queryParams.sendtimeStart = null
        this.queryParams.sendtimeEnd = null
      }
      console.log(this.queryParams)
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.sendtimes = []
      // this.handleChange([])
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.index)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加信息历史";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const index = row.index || this.ids
      getHistory(index).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改信息历史";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.index != null) {
            updateHistory(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addHistory(this.form).then(response => {
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
      const indexs = row.index || this.ids;
      this.$confirm('是否确认删除信息历史编号为"' + indexs + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delHistory(indexs);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有信息历史数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.exportLoading = true;
        return exportHistory(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>

<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="80px">
      <el-form-item label="灾情类型" prop="disastertype">
        <el-select v-model="queryParams.disastertypeList" placeholder="请选择灾情类型" clearable filterable multiple size="small">
          <el-option v-for="(value, key, index) in $root.totalDisType"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="处置对象" prop="disposeobj">
        <el-select v-model="queryParams.disposeobjList" placeholder="请选择处置对象" clearable filterable multiple size="small">
          <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="通用类型" prop="detailtype">
        <el-select v-model="queryParams.detailtype" placeholder="请选择通用类型" clearable filterable size="small">
          <el-option v-for="(value, key, index) in $root.totalGeneralType"
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
          @click="handleAdd"
          v-hasPermi="['knowledge:knowledge:add']"
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
          v-hasPermi="['knowledge:knowledge:edit']"
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
          v-hasPermi="['knowledge:knowledge:remove']"
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
          v-hasPermi="['knowledge:knowledge:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="knowledgeList" border stripe @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <!--      <el-table-column label="详细类型" align="center" prop="informid" />-->
      <el-table-column label="序号" align="center" type="index" width="100"/>
      <el-table-column label="信息内容" align="left" prop="inform"/>
      <el-table-column label="灾情类型" align="center" prop="disastertype" width="150">
        <template slot-scope="scope">
          <span>{{ $root.parseString(scope.row.disastertype, $root.totalDisType) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="处置对象" align="center" prop="disposeobj" width="150">
        <template slot-scope="scope">
          <span>{{ $root.parseString(scope.row.disposeobj, $root.totalDisposeObj) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="通用类型" align="center" prop="detailtype" width="200">
        <template slot-scope="scope">
          <span>{{ $root.totalGeneralType[scope.row.detailtype] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="150">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['knowledge:knowledge:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['knowledge:knowledge:remove']"
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

    <!-- 添加或修改通用知识库对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="信息内容" prop="inform">
          <el-input v-model="form.inform" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="灾情类型" prop="disastertype">
          <el-select v-model="form.disastertype" placeholder="请选择灾情类型">
            <el-option v-for="(value, key, index) in $root.totalDisType"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="处置对象" prop="disposeobj">
          <el-select v-model="form.disposeobj" placeholder="请选择处置对象">
            <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="通用类型" prop="detailtype">
          <el-select v-model="form.detailtype" placeholder="请选择通用类型">
            <el-option v-for="(value, key, index) in $root.totalGeneralType"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {
  listKnowledge,
  getKnowledge,
  delKnowledge,
  addKnowledge,
  updateKnowledge,
  exportKnowledge
} from "@/api/knowledge/knowledge";

export default {
  name: "Knowledge",
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
      // 通用知识库表格数据
      knowledgeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 通用类型字典
      detailtypeOptions: [],
      // 提示信息类型字典
      informtypeidOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        inform: null,
        disastertype: null,
        disastertypeList: [],
        disposeobj: null,
        disposeobjList: [],
        detailtype: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inform: [
          {required: true, message: "信息内容不能为空", trigger: "blur"}
        ],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_notice_type").then(response => {
      this.detailtypeOptions = response.data;
    });
    this.getDicts("sys_job_status").then(response => {
      this.informtypeidOptions = response.data;
    });
  },
  methods: {
    /** 查询通用知识库列表 */
    getList() {
      this.loading = true;
      this.queryParams.disastertype = this.queryParams.disastertypeList.join(',')
      this.queryParams.disposeobj = this.queryParams.disposeobjList.join(',')
      listKnowledge(this.queryParams).then(response => {
        this.knowledgeList = response.rows;
        console.log(this.knowledgeList[0])
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
        informid: null,
        inform: null,
        weight: null,
        disastertype: null,
        disposeobj: null,
        detailtype: null,
        informtypeid: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.queryParams.disposeobjList = []
      this.queryParams.disastertypeList = []
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.informid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加通用知识库";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const informid = row.informid || this.ids
      getKnowledge(informid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改通用知识库";
      });
    },
    // parseString(str, dict) {
    //   let resStr = ''
    //   let strList = str ? str.split(',') : []
    //   for (let idx in strList) {
    //     resStr += dict[strList[idx]]
    //     resStr += idx == (strList.length - 1) ? '' : ', '
    //   }
    //   return resStr
    // },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.informid != null) {
            updateKnowledge(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addKnowledge(this.form).then(response => {
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
      const informids = row.informid || this.ids;
      this.$confirm('是否确认删除通用知识库编号为"' + informids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delKnowledge(informids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有通用知识库数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.exportLoading = true;
        return exportKnowledge(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>

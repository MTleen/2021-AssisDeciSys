<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="详细类型" prop="typename">
        <el-select v-model="queryParams.typename" filterable placeholder="请选择详细类型" clearable size="small">
          <el-option v-for="(value, key, index) in $root.totalDetailType"
                     :key="key"
                     :label="value[0]"
                     :value="value[0]"/>
        </el-select>
      </el-form-item>
      <el-form-item label="处置对象" prop="disposeobj">
        <el-select v-model="queryParams.disposeobj" filterable placeholder="请选择处置对象" clearable size="small">
          <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="通用/专项" prop="priority">
        <el-select v-model="queryParams.priority" filterable placeholder="请选择通用/专项" clearable size="small">
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
          @click="handleAdd"
          v-hasPermi="['knowledge:detailtype:add']"
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
          v-hasPermi="['knowledge:detailtype:edit']"
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
          v-hasPermi="['knowledge:detailtype:remove']"
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
          v-hasPermi="['knowledge:detailtype:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="detailtypeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <!--      <el-table-column label="类型 ID" align="center" prop="typeid" />-->
      <el-table-column label="序号" align="center" type="index" width="50"/>
      <el-table-column label="详细类型" align="center" prop="typename"/>
      <el-table-column label="处置对象" align="center">
        <template slot-scope="scope">
          <span>{{ $root.totalDisposeObj[scope.row.disposeobj] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="通用/专项" align="center">
        <template slot-scope="scope">
          <span>{{ $root.totalLibType[scope.row.priority] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['knowledge:detailtype:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['knowledge:detailtype:remove']"
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

    <!-- 添加或修改详细类型表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="详细类型" prop="typename">
          <el-input v-model="form.typename" placeholder="请输入详细类型"/>
        </el-form-item>
        <el-form-item label="处置对象" prop="disposeobj">
          <el-select filterable v-model="form.disposeobj" placeholder="请选择处置对象">
            <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="通用/专项" prop="priority">
          <el-select filterable v-model="form.priority" placeholder="请选择通用/专项">
            <el-option v-for="(value, key, index) in $root.totalLibType"
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
  listDetailtype,
  getDetailtype,
  delDetailtype,
  addDetailtype,
  updateDetailtype,
  exportDetailtype
} from "@/api/knowledge/detailtype";

export default {
  name: "Detailtype",
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
      // 详细类型表表格数据
      detailtypeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        typename: null,
        disposeobj: null,
        priority: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        typename: [
          {required: true, message: "类型名称不能为空", trigger: "change"}
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询详细类型表列表 */
    getList() {
      this.loading = true;
      listDetailtype(this.queryParams).then(response => {
        this.detailtypeList = response.rows;
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
        typeid: null,
        typename: null,
        disposeobj: null,
        priority: null
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
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.typeid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加详细类型表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const typeid = row.typeid || this.ids
      getDetailtype(typeid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改详细类型表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.typeid != null) {
            updateDetailtype(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addDetailtype(this.form).then(response => {
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
      const typeids = row.typeid || this.ids;
      this.$confirm('是否确认删除详细类型表编号为"' + typeids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delDetailtype(typeids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有详细类型表数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.exportLoading = true;
        return exportDetailtype(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>

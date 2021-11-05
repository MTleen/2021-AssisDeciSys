<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="岗位" prop="positionid">
        <el-select v-model="queryParams.positionid" placeholder="请选择岗位" clearable size="small">
          <el-option
            v-for="item in UserpositionList"
              :key="item.positionid"
              :label="item.positionname"
              :value="item.positionid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="接收数量" prop="num">
        <el-input
          v-model="queryParams.num"
          placeholder="请输入接收数量"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="信息类型" prop="informtype">
        <el-select v-model="queryParams.informtype" placeholder="请选择信息类型" clearable size="small">
          <el-option
            v-for="item in informtypeList"
              :key="item.typeid"
              :label="item.typename"
              :value="item.typeid"
          />
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
          v-hasPermi="['knowledge:rule:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['knowledge:rule:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['knowledge:rule:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['knowledge:rule:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>
<div style="margin-top: 20px; background: white;padding: 20px 20px 30px 30px;">
    <el-table v-loading="loading" :data="ruleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" width="50" align="center" />
      <el-table-column label="岗位" align="center" prop="positionid" />
      <el-table-column label="接收数量" align="center" prop="num" />
      <el-table-column label="信息类型" align="center" prop="informtype" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['knowledge:rule:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['knowledge:rule:remove']"
          >删除</el-button>
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
</div>
    <!-- 添加或修改规则表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="岗位" prop="positionid">
          <el-select v-model="form.positionid" placeholder="请选岗位">
            <el-option
            v-for="item in UserpositionList"
              :key="item.positionid"
              :label="item.positionname"
              :value="item.positionid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="接收数量" prop="num">
          <el-input v-model="form.num" placeholder="请输入接收数量" />
        </el-form-item>
        <el-form-item label="信息类型" prop="informtype">
          <el-select v-model="form.informtype" placeholder="请选择信息类型">
            <el-option
              v-for="item in informtypeList"
              :key="item.typeid"
              :label="item.typename"
              :value="item.typeid"
            />
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
import { listRule, getRule, delRule, addRule, updateRule, exportRule } from "@/api/knowledge/rule";
import { listInformtype } from '@/api/knowledge/informtype'
import { listUserposition } from "@/api/information/userposition";

export default {
  name: "Rule",
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
      // 规则表表格数据
      ruleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        informtype: null,
        num: null,
        positionid: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        positionid: [
          { required: true, message: '岗位不能为空', trigger: 'blur' }
        ],
        num: [
          { required: true, message: '接收数量不能为空', trigger: 'blur' }
        ],
        informtype: [
          { required: true, message: '信息类型不能为空', trigger: 'blur' }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getList2();
  },
  methods: {
    /** 查询规则表列表 */
    getList() {
      this.loading = true;
      listRule(this.queryParams).then(response => {
        this.ruleList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 获取字典
    getList2() {
      this.loading = true;
      //查询信息类型
      listInformtype(this.commonQueryParams).then(response => {
        this.informtypeList = response.rows;
      })
      //查询岗位类型
      listUserposition(this.commonQueryParams).then(response => {
        this.UserpositionList = response.rows;
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
        ruleid: null,
        informtype: null,
        num: null,
        positionid: null
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
      this.ids = selection.map(item => item.ruleid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加规则表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ruleid = row.ruleid || this.ids
      getRule(ruleid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改规则表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ruleid != null) {
            updateRule(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addRule(this.form).then(response => {
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
      const ruleids = row.ruleid || this.ids;
      this.$confirm('是否确认删除规则表编号为"' + ruleids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delRule(ruleids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有规则表数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportRule(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>

<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :model="queryParams" :inline="true" label-width="68px">
      <el-form-item label="险情类型" prop="disastertype">
        <el-select v-model="queryParams.disastertype" filterable placeholder="请选择险情类型" clearable size="small">
          <el-option
            v-for="item in disastertypeList"
            :key="item.typeid"
            :label="item.typename"
            :value="item.typeid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="处置对象" prop="disposeobj">
        <el-select v-model="queryParams.disposeobj" filterable placeholder="请选择处置对象" clearable size="small">
          <el-option
            v-for="item in disposeobjList"
            :key="item.objid"
            :label="item.objname"
            :value="item.objid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="详细类型" prop="detailtype">
        <el-select v-model="queryParams.detailtype" filterable placeholder="请选择详细类型" clearable size="small">
          <el-option
            v-for="item in detailtypeList"
            :key="item.typeid"
            :label="item.typename"
            :value="item.typeid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="四级标签" prop="label4">
        <el-select v-model="queryParams.label4" filterable placeholder="请选择四级标签" clearable size="small">
          <el-option
            v-for="item in label4List"
            :key="item.labelid"
            :label="item.labelname"
            :value="item.labelid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="信息类型" prop="informtypeid">
        <el-select v-model="queryParams.informtypeid" filterable placeholder="请选择信息类型" clearable size="small">
          <el-option
            v-for="item in informtypeList"
            :key="item.typeid"
            :label="item.typename"
            :value="item.typeid"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="权重" prop="weight">
        <el-input
          v-model="queryParams.weight"
          placeholder="请输入权重"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['knowledge:knowledge:add']"
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['knowledge:knowledge:edit']"
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['knowledge:knowledge:remove']"
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          v-hasPermi="['knowledge:knowledge:export']"
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          :loading="exportLoading"
          @click="handleExport"
        >导出</el-button>
      </el-col>
      <right-toolbar :show-search.sync="showSearch" @queryTable="getList" />
    </el-row>
<div style="margin-top: 20px; background: white;padding: 20px 20px 30px 30px;">
    <el-table v-loading="loading" :data="knowledgeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" type="index" width="50" align="center" />
      <el-table-column label="信息内容" align="center" prop="inform" />
      <el-table-column label="险情类型" align="center" prop="disastertype" />
      <el-table-column label="处置对象" align="center" prop="disposeobj" />
      <el-table-column label="详细类型" align="center" prop="detailtype" />
      <el-table-column label="四级标签" align="center" prop="label4" />
      <el-table-column label="信息类型" align="center" prop="informtypeid" />
      <el-table-column label="权重" align="center" prop="weight" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            v-hasPermi="['knowledge:knowledge:edit']"
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改</el-button>
          <el-button
            v-hasPermi="['knowledge:knowledge:remove']"
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
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
    <!-- 添加或修改提示信息表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="信息内容" prop="inform">
          <el-input v-model="form.inform" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="险情类型" prop="disastertype">
          <el-select v-model="form.disastertype" filterable placeholder="请选择险情类型" clearable size="small">
            <el-option
              v-for="item in disastertypeList"
              :key="item.typeid"
              :label="item.typename"
              :value="item.typeid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="处置对象" prop="disposeobj">
          <el-select v-model="form.disposeobj" filterable placeholder="请选择处置对象" clearable size="small">
            <el-option
              v-for="item in disposeobjList"
              :key="item.objid"
              :label="item.objname"
              :value="item.objid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="详细类型" prop="detailtype">
          <el-select v-model="form.detailtype" filterable placeholder="请选择详细类型" clearable size="small">
            <el-option
              v-for="item in detailtypeList"
              :key="item.typeid"
              :label="item.typename"
              :value="item.typeid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="四级标签" prop="label4">
          <el-select v-model="form.label4" filterable placeholder="请选择四级标签" clearable size="small">
            <el-option
              v-for="item in label4List"
              :key="item.labelid"
              :label="item.labelname"
              :value="item.labelid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="信息类型" prop="informtypeid">
          <el-select v-model="form.informtypeid" filterable placeholder="请选择信息类型" clearable size="small">
            <el-option
              v-for="item in informtypeList"
              :key="item.typeid"
              :label="item.typename"
              :value="item.typeid"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="权重" prop="weight">
          <el-input
            v-model="form.weight"
            placeholder="请输入权重"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
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
import { listKnowledge, getKnowledge, delKnowledge, addKnowledge, updateKnowledge, exportKnowledge } from '@/api/knowledge/knowledge'
import { listDisastertype } from '@/api/knowledge/disastertype'
import { listDisposeobj } from '@/api/knowledge/disposeobj'
import { listDetailtype } from '@/api/knowledge/detailtype'
import { listLabel4 } from '@/api/knowledge/label4'
import { listInformtype } from '@/api/knowledge/informtype'

export default {
  name: 'Knowledge',
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
      // 提示信息表表格数据
      knowledgeList: [],
      disastertypeList: [],
      disposeobjList: [],
      detailtypeList: [],
      label4List: [],
      informtypeList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        inform: null,
        weight: null,
        disastertype: null,
        disposeobj: null,
        detailtype: null,
        label4: null,
        informtypeid: null
      },
      commonQueryParams: {
        pageNum: 1,
        pageSize: this.MAXCOUNT
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        inform: [
          { required: true, message: '信息内容不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询提示信息表列表 */
    getList() {
      this.loading = true
      listKnowledge(this.queryParams).then(response => {
        this.knowledgeList = response.rows
        console.log(this.knowledgeList)
        this.total = response.total
        // this.loading = false;
      })
      // 查询所有险情类型
      listDisastertype(this.commonQueryParams).then(response => {
        this.disastertypeList = response.rows
        // console.log('险情类型')
        // console.log(this.disastertypeList)
      })
      // 查询所有处置对象
      listDisposeobj(this.commomQueryParams).then(response => {
        this.disposeobjList = response.rows
      })
      // 查询所有详细类型
      listDetailtype(this.commomQueryParams).then(response => {
        this.detailtypeList = response.rows
        // console.log(this.detailtypeList)
      })
      // 查询所有四级标签
      listLabel4(this.commonQueryParams).then(response => {
        this.label4List = response.rows
      })
      listInformtype(this.commonQueryParams).then(response => {
        this.informtypeList = response.rows
      })
      this.loading = false
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
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
        label4: null,
        informtypeid: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.informid)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加提示信息表'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const informid = row.informid || this.ids
      getKnowledge(informid).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改提示信息表'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.informid != null) {
            updateKnowledge(this.form).then(response => {
              this.msgSuccess('修改成功')
              this.open = false
              this.getList()
            })
          } else {
            addKnowledge(this.form).then(response => {
              this.msgSuccess('新增成功')
              this.open = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const informids = row.informid || this.ids
      this.$confirm('是否确认删除提示信息表编号为"' + informids + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(function() {
        return delKnowledge(informids)
      }).then(() => {
        this.getList()
        this.msgSuccess('删除成功')
      }).catch(() => {})
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams
      this.$confirm('是否确认导出所有提示信息表数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.exportLoading = true
        return exportKnowledge(queryParams)
      }).then(response => {
        this.download(response.msg)
        this.exportLoading = false
      }).catch(() => {})
    }
  }
}
</script>

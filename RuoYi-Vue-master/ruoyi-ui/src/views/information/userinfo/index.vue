<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-select v-model="queryParams.gender" placeholder="请选择性别" clearable size="small">
          <el-option v-for="(value, key, index) in $root.GENDER"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <!--      <el-form-item label="年龄" prop="age">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.age"-->
      <!--          placeholder="请输入年龄"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item label="岗位" prop="positionid">
        <el-select v-model="queryParams.positionid" placeholder="请选择岗位" clearable filterable size="small">
          <el-option v-for="(value, key, index) in $root.totalUserPositions"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <el-form-item label="队站" prop="siteid">
        <el-select v-model="queryParams.siteid" placeholder="请选择队站" clearable filterable size="small">
          <el-option v-for="(value, key, index) in $root.totalSites"
                     :key="key"
                     :label="value"
                     :value="key"/>
        </el-select>
      </el-form-item>
      <!--      <el-form-item label="账号" prop="account">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.account"-->
      <!--          placeholder="请输入账号"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <!--      <el-form-item label="密码" prop="password">-->
      <!--        <el-input-->
      <!--          v-model="queryParams.password"-->
      <!--          placeholder="请输入密码"-->
      <!--          clearable-->
      <!--          size="small"-->
      <!--          @keyup.enter.native="handleQuery"-->
      <!--        />-->
      <!--      </el-form-item>-->
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable size="small">
          <el-option v-for="(value, key, index) in userStatus"
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
          v-hasPermi="['information:userinfo:add']"
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
          v-hasPermi="['information:userinfo:edit']"
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
          v-hasPermi="['information:userinfo:remove']"
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
          v-hasPermi="['information:userinfo:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userinfoList" border stripe @selection-change="handleSelectionChange" label-width="85px">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="姓名" align="center" prop="username" width="120"/>
      <el-table-column label="性别" align="center" prop="gender" width="65" >
        <template slot-scope="scope">
          {{ $root.GENDER[scope.row.gender] }}
        </template>
      </el-table-column>
      <el-table-column label="年龄" align="center" prop="age" sortable width="90">
        <template slot-scope="scope">
          <span>{{getAge(scope.row.age)}}</span>
        </template>
      </el-table-column>
      <el-table-column label="手机号" align="center" prop="tele" width="120"/>
      <el-table-column label="岗位" align="center" prop="positionid" width="110">
        <template slot-scope="scope">
          {{ $root.totalUserPositions[scope.row.positionid] }}
        </template>
      </el-table-column>
      <el-table-column label="队站" align="center" prop="siteid"  width="130">
        <template slot-scope="scope">
          {{ $root.totalSites[scope.row.siteid] }}
        </template>
      </el-table-column>
      <!--      <el-table-column label="账号" align="center" prop="account"/>-->
      <!--      <el-table-column label="密码" align="center" prop="password"/>-->
      <el-table-column label="状态" align="center" prop="status" width="100">
        <template slot-scope="scope">
          <span>{{ userStatus[scope.row.status] }}</span>
        </template>
      </el-table-column>
      <el-table-column label="微信 openid" align="center" prop="openid"/>
      <el-table-column label="企业微信 id" align="center" prop="userid"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="130">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['information:userinfo:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['information:userinfo:remove']"
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

    <!-- 添加或修改用户信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="450px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="95px"  style="width: 74%">
        <el-form-item label="手机号" prop="tele">
          <el-input v-model="form.tele" clearable placeholder="请输入手机号"/>
        </el-form-item>
        <el-form-item label="姓名" prop="username">
          <el-input c v-model="form.username" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="form.gender" placeholder="请选择性别" clearable filterable>
            <el-option v-for="(value, key, index) in $root.GENDER"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="age">
          <el-date-picker
            style="width: 208px;"
            v-model="form.age"
            size="small"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="岗位" prop="positionid">
          <el-select v-model="form.positionid" filterable clearable>
            <el-option v-for="(value, key, index) in $root.totalUserPositions"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="队站" prop="siteid">
          <el-select v-model="form.siteid" placeholder="请选择队站" clearable filterable>
            <el-option v-for="(value, key, index) in $root.totalSites"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <!--        <el-form-item label="账号" prop="account">-->
        <!--          <el-input v-model="form.account" placeholder="请输入账号"/>-->
        <!--        </el-form-item>-->
        <!--        <el-form-item label="密码" prop="password">-->
        <!--          <el-input v-model="form.password" placeholder="请输入密码"/>-->
        <!--        </el-form-item>-->
        <el-form-item label="状态">
          <el-select v-model="form.status"  placeholder="请选择状态" filterable clearable size="small" >
            <el-option v-for="(value, key, index) in userStatus"
                       :key="key"
                       :label="value"
                       :value="key"/>
          </el-select>
        </el-form-item>
        <el-form-item label="微信 openid" prop="openid">
          <el-input v-model="form.openid" placeholder="请输入微信 openid" type="textarea" autosize />
        </el-form-item>
        <el-form-item label="企业微信 id" prop="userid">
          <el-input v-model="form.userid" placeholder="请输入企业微信 id" type="textarea" autosize />
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
  listUserinfo,
  getUserinfo,
  delUserinfo,
  addUserinfo,
  updateUserinfo,
  exportUserinfo
} from "@/api/information/userinfo";

export default {
  name: "Userinfo",
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
      // 用户信息表格数据
      userinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: null,
        gender: null,
        age: null,
        positionid: null,
        siteid: null,
        account: null,
        password: null,
        status: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        username: [
          {required: true, message: "姓名不能为空", trigger: "blur"}
        ],
        gender: [
          {required: true, message: "性别不能为空", trigger: "blur"}
        ],
      },
      userStatus: null
    };
  },
  computed: {
    ageComputed: function (date) {
      return new Date().getFullYear() - new Date(date).getFullYear()
    }
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询用户信息列表 */
    getList() {
      this.loading = true;
      this.$root.getDicts('sys_user_status').then(response => {
        this.userStatus = this.$root.parseDicts(response.data)
      })
      listUserinfo(this.queryParams).then(response => {
        this.userinfoList = response.rows;
        console.log(this.userinfoList[0])
        this.total = response.total;
        this.loading = false;
      });
    },
    getAge(date) {
      return new Date().getFullYear() - new Date(date).getFullYear()
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      // this.form = {
      //   tele: null,
      //   username: null,
      //   gender: null,
      //   age: null,
      //   positionid: null,
      //   truckid: null,
      //   siteid: null,
      //   account: null,
      //   password: null,
      //   adminid: null,
      //   status: 0,
      //   openid: null,
      //   userid: null
      // };
      this.form = {}
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
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加用户信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const idx = row.id || this.ids
      getUserinfo(idx).then(response => {
        this.form = response.data;
        this.$root.num2str(this.form)
        this.open = true;
        this.title = "修改用户信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateUserinfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUserinfo(this.form).then(response => {
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
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除用户信息编号为"' + ids + '"的数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(function () {
        return delUserinfo(ids);
      }).then(() => {
        this.getList();
        this.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有用户信息数据项?', "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.exportLoading = true;
        return exportUserinfo(queryParams);
      }).then(response => {
        this.download(response.msg);
        this.exportLoading = false;
      }).catch(() => {
      });
    }
  }
};
</script>
<style scoped>
.el-date-editor{
  width:210px
}
</style>

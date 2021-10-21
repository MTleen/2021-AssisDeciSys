<template>
  <div class="app-container">
    <div class="top-style">
      <el-form ref="form" :model="form" :inline="true" label-width="80px">
        <el-form-item label="地址:" prop="location" style="margin-top: 20px">
          <el-input v-model="form.name" size="small" clearable />
        </el-form-item>

        <el-form-item label="时间:" prop="time" style="margin-top: 20px">
          <el-input v-model="form.time" size="small" clearable />
        </el-form-item>

        <el-form-item label="案情类型:" prop="type" style="margin-top: 20px">
          <el-select v-model="form.type" clearable size="small">
            <el-option label="高层建筑火灾" value="高层建筑火灾" />
            <el-option label="低层建筑火灾" value="高层建筑火灾" />
          </el-select>
        </el-form-item>

        <el-form-item label="处置对象:" prop="person" style="margin-top: 20px">
          <el-input v-model="form.person" clearable size="small" />
        </el-form-item>

        <el-form-item label="队站:" prop="station" style="margin-top: 20px">
          <el-input v-model="form.station" clearable size="small" />
        </el-form-item>

        <el-form-item label="消防车:" prop="car" style="margin-top: 20px">
          <el-select v-model="form.car" clearable size="small">
            <el-option label="全部" value="全部" />
            <el-option label="部分" value="部分" />
          </el-select>
        </el-form-item>

        <el-form-item label="关键词:" prop="keyWord" style="margin-top: 20px">
          <el-input v-model="form.keyWord" clearable size="small" placeholder="请输入关键词" />

        </el-form-item>

        <el-form-item>
          <el-button icon="el-icon-search" type="info" size="small" style="margin-top: 23px">查询</el-button>
        </el-form-item>

      </el-form>
    </div>

    <el-row :gutter="30" style="margin-top: 30px">
      <el-col :span="8">
        <el-card class="box-card" background-color="cadetblue">
          <div style="padding: 2px;" icon="el-icon-plus">
            <span style="font-size:20px">指挥员</span>

          </div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="box-card">
          <div style="padding: 2px;">
            <span style="font-size:20px" icon="el-icon-eleme">战斗员</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card class="box-card">
          <div style="padding: 2px;">
            <span style="font-size:20px">司通员</span>
          </div>
        </el-card>
      </el-col>
    </el-row>

    <el-row :gutter="30" style="margin-top: 30px">
      <el-col :span="8">
        <div class="grid-content bg-purple">
          <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="zhihuiData" stripe>
            <el-table-column type="selection" width="55" />

            <el-table-column label="序号" align="center" prop="ZHId">
              <template slot-scope="scope">{{ scope.row.ZHId }}</template>
            </el-table-column>

            <el-table-column label="内容详情" align="center" prop="ZHcontent" :show-overflow-tooltip="false" />
            <el-table-column
              label="全部"
              align="center"
              prop="ZHIcon"
              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
              :filter-method="filterTag"
            />
          </el-table>

          <div align="right" class="fujian-style">
            <el-form ref="form" :model="tipForm" inline="true" label-width="80px" style="margin-top: 23px">
              <el-form-item label="" prop="tip">
                <el-input v-model="tipForm.tip" size="small" clearable="" />
              </el-form-item>
              <el-button scopped: style="margin-top: 3px" type="" size="small" icon="el-icon-plus">附件上传</el-button>
            </el-form>
          </div>

        </div>
      </el-col>

      <el-col :span="8">
        <div class="grid-content bg-purple">
          <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="zhandouData" stripe>
            <el-table-column type="selection" width="55" />

            <el-table-column label="序号" align="center" prop="ZDId">
              <template slot-scope="scope">{{ scope.row.ZDId }}</template>
            </el-table-column>
            <el-table-column label="内容详情" align="center" prop="ZDcontent" :show-overflow-tooltip="false" />
            <el-table-column
              label="全部"
              align="center"
              prop="ZDIcon"
              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
              :filter-method="filterTag"
            />
          </el-table>

          <div align="right" class="fujian-style">
            <el-form ref="form" :model="tipForm" inline="true" label-width="80px">
              <el-form-item label="" prop="tip">
                <el-input v-model="tipForm.tip" size="small" />
              </el-form-item>
              <el-button scopped: style="margin-top: 3px" type="" size="small" icon="el-icon-plus">附件上传</el-button>
            </el-form>
          </div>

        </div>
      </el-col>

      <el-col :span="8">
        <div align:="right" class="grid-content bg-purple">
          <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="sitongData" stripe>
            <el-table-column type="selection" width="55" />

            <el-table-column label="序号" align="center" prop="STId">
              <template slot-scope="scope">{{ scope.row.STId }}</template>
            </el-table-column>
            <el-table-column label="内容详情" align="center" prop="STcontent" :show-overflow-tooltip="false" />
            <el-table-column
              label="全部"
              align="center"
              prop="STIcon"
              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
              :filter-method="filterTag"
            />

          </el-table>

          <div align="right" class="fujian-style">
            <el-form ref="form" :model="tipForm" inline="true" label-width="80px">
              <el-form-item label="" prop="tip">
                <el-input v-model="tipForm.tip" size="small" />
              </el-form-item>
              <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px">附件上传</el-button>
            </el-form>
          </div>

        </div>

      </el-col>

      <div align="center">
        <el-button style="margin-top: 40px" type="primary">倒计时30s</el-button>
      </div>

    </el-row>

  </div>
</template>
<script>
export default {
  data() {
    return {
      form: {
        name: '',
        time: '',
        type: '',
        person: '',
        station: '',
        car: '',
        keyWord: ''
      },
      tipForm: {
        tip: ''
      },
      zhihuiData: [{
        ZHId: '1',
        ZHcontent: '存在高空坠落',
        ZHIcon: '1'
      },
      {
        ZHId: '2',
        ZHcontent: '存在失联迷失',
        ZHIcon: '2'
      }],

      zhandouData: [{
        ZDId: '1',
        ZDcontent: '严格落实一线指挥',
        ZDIcon: '1'
      }, {
        ZDId: '2',
        ZDcontent: '合理选择进攻途径',
        ZDIcon: '3'
      }],

      sitongData: [{
        STId: '1',
        STcontent: '利用防烟楼梯登高',
        STIcon: '1'
      }, {
        STId: '2',
        STcontent: '严禁停靠着火层或穿越着火层',
        STIcon: '3'
      }]

    }
  },

  methods: {
    filterTag(value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    onSubmit() {
      console.log('submit!')
    }
  }
}
</script>
<style scoped>
.el-card {
    background-color: #409EFF;
    /* padding: 10px 20px; */
    color:#fff;
    text-align:center
  }
.fujian-style{
    margin-top: 20px;
    vertical-align: middle ;
}
.top-style{
    background: lightskyblue;
}
</style>

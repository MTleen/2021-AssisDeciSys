<template>
  <div class="app-container">
    <div class="top-style">
      <el-form  label-position="left" ref="form" :model="form" :inline="true" label-width="80px">
        <el-row style="margin-top: 15px">
          <el-form-item label="案发地址:" prop="location" style="margin-left: 4%">
            <el-input v-model="form.name" size="small" clearable />
          </el-form-item>

          <el-form-item label="立案时间:" prop="time" style="margin-left: 4%">
            <el-input v-model="form.time" size="small" clearable />
          </el-form-item>

          <el-form-item label="险情类型:" prop="type"  style="margin-left: 4%">
            <el-select v-model="form.type" clearable size="small">
              <el-option label="高层建筑火灾" value="高层建筑火灾" />
              <el-option label="低层建筑火灾" value="高层建筑火灾" />
            </el-select>
          </el-form-item>
        
          <el-form-item label="处置对象:" prop="person" style="margin-left: 4%">
            <el-input v-model="form.person" clearable size="small" />
          </el-form-item>
        </el-row>

        <el-row style="margin-top: 2px">
          <el-form-item label="所属队站:" prop="station" style="margin-left: 4%">
            <el-select v-model="form.station" clearable size="small">
              <el-option label="宝山支队" value="宝山支队" />
            </el-select>
          </el-form-item>

          <el-form-item label="消防车:" prop="car" style="margin-left: 4%">
            <el-select v-model="form.car" clearable size="small">
              <el-option label="全部" value="全部" />
              <el-option label="部分" value="部分" />
            </el-select>
          </el-form-item>

          <el-form-item label="关键词:" prop="keyWord" style="margin-left: 4%">
            <el-input v-model="form.keyWord" clearable  style="width: 165px;" size="small" prefix-icon=" el-icon-search"  placeholder="请输入关键词" />
            
          </el-form-item>

          <el-form-item >
            <el-button  type="info" size="small" style="margin-left: -10px; width:50px;" >搜索</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </div>

    <!-- <el-row :gutter="30" style="margin-top: 30px;">
      <el-col :span="8" style="height:40px;">
        <el-card background-color="cadetblue" shadow="always" style="height:40px; " >
          <div >
            <span style="font-size:20px">指挥员</span>
          </div>
        </el-card>
      </el-col>
      
      <el-col :span="8">
        <el-card style="height: 40px;">
          <div >
            <span style="font-size:20px" >战斗员</span>
          </div>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card style="height: 40px;">
            <span style="font-size:20px">司通员</span>
        </el-card>
        </el-col>
      </el-row> -->
  <div class="table-style">
    <el-row :gutter="30" style="margin-top: 30px;">
    <el-col :span="8" >
      <el-card >
        <i class="el-icon-s-flag" style="float:left; padding: 4px 0px 4px 4px;"></i>
          <a style="font-size:16px;float:left; padding-left: 5px;">指挥员</a>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card  >
          <i class="el-icon-service" style="float:left; padding: 4px 0px 4px 4px;"></i>
           <span style="font-size:16px;float:left;padding-left: 5px;">战斗员</span>
        </el-card>
      </el-col>
      <el-col :span="8">
        <el-card >
          <i class="el-icon-phone-outline" style="float:left; padding: 4px 0px 4px 4px;"></i>
           <span style="font-size:16px;float:left; padding-left:5px; ">司通员</span>
        </el-card>
      </el-col>
    </el-row>


    <el-row :gutter="30" >
      <el-col :span="8">
        <div class="grid-content bg-purple" >
          <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="zhihuiData"   height="650" stripe>
            <el-table-column type="selection" align="center" width="50"  />

            <el-table-column label="序号" align="center" prop="ZHId"  width="50">
              <template slot-scope="scope">{{ scope.row.ZHId }}</template>
            </el-table-column>

            <el-table-column label="内容详情" align="center"  prop="ZHcontent" :show-overflow-tooltip="false" />
            <el-table-column
              width="60"
              label="全部"
              align="center"
              prop="ZHIcon"
              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
              :filter-method="filterTag">

              <template slot-scope="scope">
                <i class='el-icon-question'  v-if="scope.row.ZHIcon === '1'" >
                </i>
                <i class='el-icon-message-solid'  v-if="scope.row.ZHIcon === '2'" >
                </i>
                <i class='el-icon-s-management'  v-if="scope.row.ZHIcon === '3'" >
                </i>
              </template>
            </el-table-column>
          </el-table>

          <div align="left" class="fujian-style">
            <el-form ref="form" :model="tipForm" >
              <el-form-item label="" prop="tip">
                <el-col :span="16">
                  <el-input v-model="tipForm.tip" size="small"  placeholder="请输入特别警示..." style="float:left;" />
                </el-col> 
                <el-col :span="8">
                 <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px; float:right;">附件上传</el-button>
                </el-col>
              </el-form-item>
            </el-form>
          </div>

        </div>
      </el-col>

      <el-col :span="8">
        <div class="grid-content bg-purple">
          <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="zhandouData"  height="650" stripe>
            <el-table-column type="selection"  align="center" width="50" />

            <el-table-column label="序号" align="center" prop="ZDId"  width="50">
              <template slot-scope="scope">{{ scope.row.ZDId }}</template>
            </el-table-column>
            <el-table-column label="内容详情" align="center" prop="ZDcontent" :show-overflow-tooltip="false" />
            <el-table-column
              width="60"
              label="全部"
              align="center"
              prop="ZDIcon"
              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
              :filter-method="filterTag">

              <template slot-scope="scope">
                <i class='el-icon-question'  v-if="scope.row.ZDIcon === '1'" >
                </i>
                <i class='el-icon-message-solid'  v-if="scope.row.ZDIcon === '2'" >
                </i>
                <i class='el-icon-s-management'  v-if="scope.row.ZDIcon === '3'" >
                </i>
              </template>

            </el-table-column>
          </el-table>

         <div align="right" class="fujian-style">
             <el-form ref="form" :model="tipForm" >
              <el-form-item label="" prop="tip">
                <el-col :span="16">
                  <el-input v-model="tipForm.tip" size="small"  placeholder="请输入特别警示..." style="float:left;" />
                </el-col> 
                <el-col :span="8">
                 <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px; float:right;">附件上传</el-button>
                </el-col>
              </el-form-item>
            </el-form>
          </div>

        </div>
      </el-col>

      <el-col :span="8">
        <div align:="right" class="grid-content bg-purple">
          <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="sitongData"  height="650" stripe>
            <el-table-column type="selection" align="center" width="50" />

            <el-table-column label="序号" align="center" prop="STId"  width="50">
              <template slot-scope="scope">{{ scope.row.STId }}</template>
            </el-table-column>
            <el-table-column label="内容详情" align="center" prop="STcontent" :show-overflow-tooltip="false" />
            <el-table-column 
              width="60"
              label="全部"
              align="center"
              prop="STIcon"
              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
              :filter-method="filterTag" 
              filter-placement="bottom-end">

              <template slot-scope="scope">
                <i class='el-icon-question'  v-if="scope.row.STIcon === '1'" >
                </i>
                <i class='el-icon-message-solid'  v-if="scope.row.STIcon === '2'" >
                </i>
                <i class='el-icon-s-management'  v-if="scope.row.STIcon === '3'" >
                </i>
              </template>

           </el-table-column>

          </el-table>

          <div align="right" class="fujian-style">
             <el-form ref="form" :model="tipForm" >
              <el-form-item label="" prop="tip">
                <el-col :span="16">
                  <el-input v-model="tipForm.tip" size="small"  placeholder="请输入特别警示..." style="float:left;" />
                </el-col> 
                <el-col :span="8">
                 <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px; float:right;">附件上传</el-button>
                </el-col>
              </el-form-item>
            </el-form>
          </div>

        </div>

      </el-col>
    </el-row>

    <div align="center">
        <el-button style="margin-top: 40px" type="primary">倒计时30s</el-button>
    </div>
  </div>
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
<style >
.el-table--medium th, .el-table--medium td {
    padding: 2px 0;
    padding-top: 2px;
    padding-right: 0px;
    padding-bottom: 2px;
    padding-left: 0px;
}

.el-card {
    background-color: #409EFF;
    /* padding: 10px 20px; */
    color:black;
    text-align:center
  }
.icon-style{
  padding: 8px 0px 10px 10px;
}
.fujian-style{
  width: 100%;
    margin-top: 10px;
    vertical-align: middle ;
    float: left;
}
.top-style{
   background: rgb(145, 211, 252);
}
.el-card{
    height:40px; 
    background: lightskyblue;  
}
.el-card__body{
    padding: 8px 0px 10px 10px;
}
.table-style{
  background: white;
  padding: 20px 20px 30px 30px;
}
/* .app-container{
  background: rgb(145, 211, 252);
} */
.app-main{
      background: rgb(145, 211, 252);
}

</style>

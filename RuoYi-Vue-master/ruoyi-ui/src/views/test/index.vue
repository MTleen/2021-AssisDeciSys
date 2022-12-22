<template>
    <div class="app-container">
        <el-form ref="form" :model="form" inline="true" label-width="80px">
            <el-form-item label="地址:" prop="location">
                <el-input v-model="form.name"  size="small"></el-input>
            </el-form-item>

            <el-form-item label="时间:" prop="time">
                <el-input v-model="form.time"  size="small"></el-input>
            </el-form-item>

            <el-form-item label="案情类型:" prop="type">
                <el-select v-model="form.type"  size="small">
                    <el-option label="高层建筑火灾" value="高层建筑火灾"></el-option>
                    <el-option label="低层建筑火灾" value="高层建筑火灾"></el-option>
                </el-select>
            </el-form-item>

             <el-form-item label="处置对象:" prop="person">
                <el-input v-model="form.person"  size="small"></el-input>
            </el-form-item>
        </el-form>

        <el-form ref="form" :model="form" inline="true" label-width="80px">
            <el-form-item label="队站:" prop="station" >
                <el-input v-model="form.station"  size="small"></el-input>
            </el-form-item>

            <el-form-item label="消防车:" prop="car">
                <el-select v-model="form.car"  size="small">
                    <el-option label="全部" value="全部"></el-option>
                    <el-option label="部分" value="部分"></el-option>
                </el-select>
            </el-form-item>

             <el-form-item label="关键词:" prop="keyWord">
                <el-input v-model="form.keyWord"  size="small" placeholder="请输入关键词"></el-input>
                
            </el-form-item>
            <el-button inline="true" type="info" round size="small">查询</el-button>
        </el-form>

        <el-row :gutter="30" style="margin-top: 30px">
            <el-col :span="8">
                <el-card class="box-card" >
                    <div style="padding: 9px;">
                    <span>指挥员</span>
                    </div>
                </el-card>
            </el-col>
            <el-col :span="8">
                <el-card class="box-card">
                    <div style="padding: 9px;">
                    <span>战斗员</span>
                    </div>
                </el-card>
            </el-col>
            <el-col :span="8">
                <el-card class="box-card">
                    <div style="padding: 9px;">
                    <span >司通员</span>
                    </div>
                </el-card>
            </el-col>
        </el-row>


        <el-row :gutter="30" style="margin-top: 30px">
             <el-col :span="8">
                <div class="grid-content bg-purple">
                    <el-table  v-loading="loading" :data="zhihuiData" stripe  >
                    <el-table-column type="selection"  width="55">
                    </el-table-column>

                    <el-table-column label="序号" align="center" prop="ZHId" >
                        <template slot-scope="scope">{{ scope.row.ZHId }}</template>
                    </el-table-column>

                    <el-table-column label="内容详情" align="center" prop="ZHcontent" :show-overflow-tooltip="true">
                    </el-table-column>  
                    <el-table-column label="全部" align="center" prop="ZHIcon"
                        :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
                        :filter-method="filterTag"
                        >
                    </el-table-column>
                    </el-table>
                </div>
             </el-col>

              <el-col :span="8">
                <div class="grid-content bg-purple">
                    <el-table  v-loading="loading" :data="zhandouData" stripe  >
                    <el-table-column type="selection"  width="55">
                    </el-table-column>

                    <el-table-column label="序号" align="center" prop="ZDId" >
                        <template slot-scope="scope">{{ scope.row.ZDId }}</template>
                    </el-table-column>
                    <el-table-column label="内容详情" align="center" prop="ZDcontent" :show-overflow-tooltip="true">
                    </el-table-column>  
                    <el-table-column label="全部" align="center" prop="ZDIcon"
                        :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
                        :filter-method="filterTag"
                        >
                    </el-table-column>
                    </el-table>
                </div>
             </el-col> 
             
             <el-col :span="8">
                <div class="grid-content bg-purple">
                    <el-table  v-loading="loading" :data="sitongData" stripe  >
                    <el-table-column type="selection"  width="55">
                    </el-table-column>

                    <el-table-column label="序号" align="center" prop="STId" >
                         <template slot-scope="scope">{{ scope.row.STId }}</template>
                    </el-table-column>
                    <el-table-column label="内容详情" align="center" prop="STcontent" :show-overflow-tooltip="true">
                    </el-table-column>  
                    <el-table-column label="全部" align="center" prop="STIcon"
                        :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"
                        :filter-method="filterTag"
                        >
                    </el-table-column>
                    </el-table>
                </div>
             </el-col>

        </el-row>

        <el-row style="margin-top: 50px">
             <el-form ref="form" :model="tipForm" inline="true" label-width="80px">
                <el-form-item label="" prop="tip">
                <el-input v-model="tipForm.tip"  size="small"></el-input>
                </el-form-item>
                <el-button type=""  size="small">附件上传</el-button>
             </el-form>
        </el-row>


    </div>
</template>
<script>
  export default {
    data() {
      return {
        form: {
          name:'1',
          time:'2',
          type:'3',
          person:'4',
          station:'5',
          car:'6',
          keyWord:'7',
        },
        tipForm: {
            tip:'8'
        },
        zhihuiData: [{
            ZHId:'1',
            ZHcontent:'存在高空坠落',
            ZHIcon:'1',
        },
        {
            ZHId:'2',
            ZHcontent:'严格落实一线指挥',
            ZHIcon:'2',
        }],

        zhandouData: [{
            ZDId:'1',
            ZDcontent:'存在高空坠落',
            ZDIcon:'1',
        },{
            ZDId:'2',
            ZDcontent:'加油冲',
            ZDIcon:'3',
        }],

         sitongData: [{
            STId:'1',
            STcontent:'存在高空坠落',
            STIcon:'1',
        },{
            STId:'2',
            STcontent:'加油冲',
            STIcon:'3',
        }]
      
      }
    },

    methods: {
        filterTag(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      },
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>
<template>
  <div  class="app-container">
  <el-row>
    <el-col :span="24">
      <div class="grid-content bg-purple-dark" style="margin-">
        <div class="block">
          <el-date-picker
            v-model="value2"
            type="daterange"
            align="right"
            unlink-panels
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            :picker-options="pickerOptions">
          </el-date-picker>
          <!-- <el-button type="primary" plain>全部</el-button>
          <el-button type="primary" plain>待处理</el-button>
          <el-button type="primary" plain>未处理</el-button> -->
            <el-radio-group v-model="AllOrPart">
              <el-radio-button label="全部"></el-radio-button>
              <el-radio-button label="已处理"></el-radio-button>
              <el-radio-button label="未处理"></el-radio-button>
            </el-radio-group>
        </div>
      </div> 
        
    </el-col>
  </el-row>

  <div style="margin-top: 30px">
  <el-row :gutter="40">
    <el-col :span="16">
      <div class="grid-content bg-purple">
        <el-table  v-loading="loading" :data="typeList" stripe border :header-cell-style="tableHeaderColor" >
          <el-table-column label="序号" align="center" prop="caseId" >
          </el-table-column>
          <el-table-column label="案件类型" align="center" prop="caseType" :show-overflow-tooltip="true">
          </el-table-column>
          <el-table-column label="案发地址" align="center" prop="caseAdress" :show-overflow-tooltip="false" >
          </el-table-column>
          <el-table-column label="立案时间" align="center" prop="createTime" width="180">
            <template slot-scope="scope">
              <span>{{ parseTime(scope.row.createTime) }}</span>
            </template>
          </el-table-column>
          <el-table-column label="状态" align="center" prop="status">
            <template slot-scope="scope">
              <dict-tag :options="statusOptions" :value="scope.row.status"/>
            </template>
          </el-table-column>
          <el-table-column fixed="right" label="操作" align="center" class-name="small-padding fixed-width">
            <template >
              <el-button type="primary" >推送</el-button>
              <el-button type="success" >查看</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="block" style="margin-top: 30px">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[10, 20, 30, 40]"
          :page-size="20"
          layout="total, sizes, prev, pager, next, jumper"
          :total="100">
        </el-pagination>
      </div>
    </el-col>
  
    <el-col :span="8">
      <div class="grid-content bg-purple">
        <el-table v-loading="loading" :data="dataTable" stripe border  :header-cell-style="tableHeaderColor">
          <el-table-column label="序号" align="center" prop="caseNumber" >
          </el-table-column>
          <el-table-column label="人员" align="center" prop="casePerson" >
          </el-table-column>
          <el-table-column label="全部" align="center" prop="caseIcon"
          :filters="[{text:'指挥员', value:'指挥员'},{text:'司通员', value:'司通员'},{text:'战斗员', value:'战斗员'}]"
          :filter-method="filterTag"
          >
          <!-- <template slot-scope="scope">
           <el-column
          :type="scope.row.tag === '指挥员' ? 'primary' : 'success'"
          disable-transitions>{{scope.row.tag}}</el-column>
          </template> -->

          </el-table-column>
          <el-table-column label="内容详情" align="center" prop="caseContent" >
          </el-table-column>
        </el-table>
      </div>
    </el-col>
  </el-row>

  </div>

  
</div>
   


</template>
<script>
  export default {
    data() {
      return {
        AllOrPart:'全部',
        typeList:[{
        caseId:'1',
        caseType:'火灾',
        caseAdress:'上海市普陀区',
        createTime:'2021-10-9',
        status:'待处理',
        },{
        caseId:'2',
        caseType:'社会救助',
        caseAdress:'上海市宝山区2218弄10号1001室',
        createTime:'2021-10-7',
        status:'已处理',
        }
      ],
       dataTable:[{
        caseNumber:'1',
        casePerson:'抢救员',
        caseIcon:'指挥员',
        caseContent:'准备出发',
        },
        {
        caseNumber:'2',
        casePerson:'驾驶员',
        caseIcon:'司通员',
        caseContent:'要去开车',
        },
      ],
        pickerOptions: {
          shortcuts: [{
            text: '最近一周',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近一个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
              picker.$emit('pick', [start, end]);
            }
          }, {
            text: '最近三个月',
            onClick(picker) {
              const end = new Date();
              const start = new Date();
              start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
              picker.$emit('pick', [start, end]);
            }
          }]
        },
        value1: '',
        value2: ''
      };
    },
    methods: {
        filterTag(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      },
       //设置表头行的样式
      tableHeaderColor({row,column,rowIndex,columnIndex}){
        return 'background-color:#409EFF;color:#fff;font-wight:500;text-align:center'
 
      }
    }
  }
</script>
<style>
</style>

    }
  };
</script>
<style>

</style>

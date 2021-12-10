<template>
  <div class="app-container">
    <div class="top-style">
      <el-form label-position="left" ref="cautionForm" :model="form" :rules="rules" :inline="true" label-width="80px">
        <el-row style="margin-top: 15px">
          <el-form-item label="案发地址:" prop="address" style="">
            <el-input v-model="form.address"  placeholder="请输入案发地址" size="small" clearable/>
          </el-form-item>
          <el-form-item label="立案时间:" prop="date">
            <el-date-picker clearable size="small"
                            v-model="form.date"
                            type="datetime"
                            style="width: 214px;"
                            value-format="timestamp"
                            placeholder="选择立案时间">
            </el-date-picker>
          </el-form-item>

          <el-form-item label="灾情类型:" prop="distype" style="">
            <el-select v-model="form.distype" filterable clearable size="small">
              <el-option v-for="(value, key, index) in $root.totalDisType"
                         :key="key"
                         :label="value"
                         :value="key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="处置对象:" prop="disposeObj" style="">
            <el-select v-model="form.disposeObj" filterable clearable size="small">
              <el-option v-for="(value, key, index) in $root.totalDisposeObj"
                         :key="key"
                         :label="value"
                         :value="key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="通用类型:" prop="generalType" style="">
            <el-select v-model="form.generalType" filterable clearable size="small">
              <el-option v-for="(value, key, index) in $root.totalGeneralType"
                         :key="key"
                         :label="value"
                         :value="key"/>
            </el-select>
          </el-form-item>

          <!--        <el-row style="margin-top: 2px">-->
          <el-form-item label="主管队站:" prop="siteID1" style="">
            <el-select v-model="form.siteID1" filterable clearable size="small">
              <el-option v-for="(value, key, index) in $root.totalSites"
                         :key="key"
                         :label="value"
                         :value="key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="参战力量:" prop="siteID2" style="">
            <el-select v-model="form.siteID2" filterable clearable multiple size="small">
              <el-option v-for="(value, key, index) in $root.totalSites"
                         :key="key"
                         :label="value"
                         :value="key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="专项类型:" prop="specialType" style="">
            <el-select v-model="form.specialType" clearable size="small">
              <el-option v-for="(value, key, index) in $root.totalSpecialType"
                         :key="key"
                         :label="value"
                         :value="key"/>
            </el-select>
          </el-form-item>

          <el-form-item label="关键词:" prop="keyWords" style="">
            <el-input v-model="form.keyWords" clearable style="width: 214px;" size="small" prefix-icon=" el-icon-search"
                      placeholder="请输入关键词"/>
          </el-form-item>

          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>


          <!-- </el-row>

          <el-row style="margin-top: 2px"> -->

        </el-row>
      </el-form>
    </div>


    <div class="table-style" :height="screenHeight">
      <!--      <el-row :gutter="30" style="margin-top: 20px;">-->
      <!--        <el-col :span="24">-->
      <!--          <el-card>-->
      <!--            <i class="el-icon-s-flag" style="text-align:center; padding: 4px 0px 4px 4px;"></i>-->
      <!--            <a style=" font-size:16px;text-align:center; padding-left: 5px;">指挥员</a>-->
      <!--          </el-card>-->
      <!--        </el-col>-->

      <!--        &lt;!&ndash; <el-col :span="8">-->
      <!--          <el-card>-->
      <!--            <i class="el-icon-service" style="float:left; padding: 4px 0px 4px 4px;"></i>-->
      <!--            <span style="font-size:16px;float:left;padding-left: 5px;">战斗员</span>-->
      <!--          </el-card>-->
      <!--        </el-col> -->
      <!--        <el-col :span="8">-->
      <!--          <el-card>-->
      <!--            <i class="el-icon-phone-outline" style="float:left; padding: 4px 0px 4px 4px;"></i>-->
      <!--            <span style="font-size:16px;float:left; padding-left:5px; ">司通员</span>-->
      <!--          </el-card>-->
      <!--        </el-col> &ndash;&gt;-->

      <!--      </el-row>-->


      <el-row :gutter="30">
        <el-col :span="24">
          <div class="grid-content bg-purple">
            <div class="table-height">
              <el-table :v-loading="loading" :cell-style="{padding:'2px'}" :data="informList" border stripe
                        @selection-change="handleSelectChange" max-height="600">
                <el-table-column type="selection" align="center" width="50"/>

                <!--              <el-table-column label="序号" align="center" prop="ZHId" width="50">-->
                <!--                <template slot-scope="scope">{{ scope.row.ZHId }}</template>-->
                <!--              </el-table-column>-->
                <el-table-column type="index" label="序号" align="center" width="50"></el-table-column>

                <el-table-column label="提示信息" align="left" prop="inform" :show-overflow-tooltip="false"/>
                <el-table-column label="信息类型" align="center" width="200" prop="librarytype">
                  <template slot-scope="scope">
                    {{
                      scope.row.librarytype === 1 ? $root.totalGeneralType[scope.row.detailtype] : $root.totalSpecialType[scope.row.detailtype]
                    }}
                  </template>
                </el-table-column>
                <!--                            <el-table-column-->
                <!--                              width="60"-->
                <!--                              label="信息类型"-->
                <!--                              align="center"-->
                <!--                              prop="detailtype"-->
                <!--                              :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"-->
                <!--                              :filter-method="filterTag">-->

                <!--                <template slot-scope="scope">-->
                <!--                  <i class='el-icon-question' v-if="scope.row.ZHIcon === '1'">-->
                <!--                  </i>-->
                <!--                  <i class='el-icon-message-solid' v-if="scope.row.ZHIcon === '2'">-->
                <!--                  </i>-->
                <!--                  <i class='el-icon-s-management' v-if="scope.row.ZHIcon === '3'">-->
                <!--                  </i>-->
                <!--                </template>-->
                <!--              </el-table-column>-->
              </el-table>
            </div>
            <pagination
              v-show="total>0"
              :total="total"
              :page.sync="form.pageNum"
              :limit.sync="form.pageSize"
              :pager-count="pagerCount"
              @pagination="getInfo"
            />

            <!-- <div align="left" class="fujian-style">
              <el-form ref="form" :model="customerInfo">
                <el-form-item label="" prop="tip">
                <div class="width:100px">
                  <el-col :span="16" style=" padding-left: 0px; padding-right: 0px;">
                    <el-input v-model="customerInfo" size="small" placeholder="请输入特别警示..." style="float:left;"/>
                  </el-col>
                </div>
                <div>
                  <el-col :span="8" style=" padding-left: 0px; padding-right: 0px;">
                    <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px; float:right;">
                      附件上传
                    </el-button>
                  </el-col>
                </div>
                </el-form-item>
              </el-form>
            </div> -->

            <el-form ref="form" :model="customerInfo">
              <el-form-item label="" prop="tip">
                <div class="fujian-style">
                  <div style="margin-right:10px; width:40%">
                    <el-input v-model="customerInfo" size="small" placeholder="请输入特别警示..." style="width:100%"
                              @focus="resetTimer"/>
                  </div>
                  <!--                    <div>-->
                  <!--                      <el-button type="" size="small" icon="el-icon-plus" scopped: style=" ">-->
                  <!--                        附件上传-->
                  <!--                      </el-button>-->
                  <!--                    </div>-->
                </div>
              </el-form-item>
            </el-form>
          </div>

          <div align="center">
            <el-button style="margin-top: 40px" type="primary" v-if="seconds > 0">{{ seconds }} s</el-button>
            <el-button style="margin-top: 40px;margin-bottom:20px" type="primary" size="middle" v-else @click="sendInfo"
                       :disabled="informList.length === 0">发 送
            </el-button>
          </div>
        </el-col>

        <!--        <el-col :span="8">-->
        <!--          <div class="grid-content bg-purple">-->
        <!--            <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="zhandouData" stripe>-->
        <!--              <el-table-column type="selection" align="center" width="50"/>-->

        <!--              <el-table-column label="序号" align="center" prop="ZDId" width="50">-->
        <!--                <template slot-scope="scope">{{ scope.row.ZDId }}</template>-->
        <!--              </el-table-column>-->
        <!--              <el-table-column label="内容详情" align="center" prop="ZDcontent" :show-overflow-tooltip="false"/>-->
        <!--              <el-table-column-->
        <!--                width="60"-->
        <!--                label="全部"-->
        <!--                align="center"-->
        <!--                prop="ZDIcon"-->
        <!--                :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"-->
        <!--                :filter-method="filterTag">-->

        <!--                <template slot-scope="scope">-->
        <!--                  <i class='el-icon-question' v-if="scope.row.ZDIcon === '1'">-->
        <!--                  </i>-->
        <!--                  <i class='el-icon-message-solid' v-if="scope.row.ZDIcon === '2'">-->
        <!--                  </i>-->
        <!--                  <i class='el-icon-s-management' v-if="scope.row.ZDIcon === '3'">-->
        <!--                  </i>-->
        <!--                </template>-->

        <!--              </el-table-column>-->
        <!--            </el-table>-->

        <!--            <div align="right" class="fujian-style">-->
        <!--              <el-form ref="form" :model="tipForm">-->
        <!--                <el-form-item label="" prop="tip">-->
        <!--                  <el-col :span="16" style=" padding-left: 0px; padding-right: 0px;">-->
        <!--                    <el-input v-model="tipForm.tip" size="small" placeholder="请输入特别警示..." style="float:left;"/>-->
        <!--                  </el-col>-->
        <!--                  <el-col :span="8" style=" padding-left: 0px; padding-right: 0px;">-->
        <!--                    <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px; float:right;">-->
        <!--                      附件上传-->
        <!--                    </el-button>-->
        <!--                  </el-col>-->
        <!--                </el-form-item>-->
        <!--              </el-form>-->
        <!--            </div>-->

        <!--          </div>-->
        <!--        </el-col>-->

        <!--        <el-col :span="8">-->
        <!--          <div align:="right" class="grid-content bg-purple">-->
        <!--            <el-table v-loading="loading" :cell-style="{padding:'2px'}" :data="sitongData" stripe>-->
        <!--              <el-table-column type="selection" align="center" width="50"/>-->

        <!--              <el-table-column label="序号" align="center" prop="STId" width="50">-->
        <!--                <template slot-scope="scope">{{ scope.row.STId }}</template>-->
        <!--              </el-table-column>-->
        <!--              <el-table-column label="内容详情" align="center" prop="STcontent" :show-overflow-tooltip="false"/>-->
        <!--              <el-table-column-->
        <!--                width="60"-->
        <!--                label="全部"-->
        <!--                align="center"-->
        <!--                prop="STIcon"-->
        <!--                :filters="[{text:'1', value:'1'},{text:'2', value:'2'},{text:'3', value:'3'}]"-->
        <!--                :filter-method="filterTag"-->
        <!--                filter-placement="bottom-end">-->

        <!--                <template slot-scope="scope">-->
        <!--                  <i class='el-icon-question' v-if="scope.row.STIcon === '1'">-->
        <!--                  </i>-->
        <!--                  <i class='el-icon-message-solid' v-if="scope.row.STIcon === '2'">-->
        <!--                  </i>-->
        <!--                  <i class='el-icon-s-management' v-if="scope.row.STIcon === '3'">-->
        <!--                  </i>-->
        <!--                </template>-->

        <!--              </el-table-column>-->

        <!--            </el-table>-->

        <!--            <div align="right" class="fujian-style">-->
        <!--              <el-form ref="form" :model="tipForm">-->
        <!--                <el-form-item label="" prop="tip">-->
        <!--                  <el-col :span="16" style=" padding-left: 0px; padding-right: 0px;">-->
        <!--                    <el-input v-model="tipForm.tip" size="small" placeholder="请输入特别警示..."-->
        <!--                              style="float:left; width: 100%; "/>-->
        <!--                  </el-col>-->
        <!--                  <el-col :span="8" style=" padding-left: 0px; padding-right: 0px;">-->
        <!--                    <el-button type="" size="small" icon="el-icon-plus" scopped: style="margin-top: 3px; float:right;">-->
        <!--                      附件上传-->
        <!--                    </el-button>-->
        <!--                  </el-col>-->
        <!--                </el-form-item>-->
        <!--              </el-form>-->
        <!--            </div>-->

        <!--          </div>-->

        <!--        </el-col>-->
      </el-row>
    </div>
  </div>
</template>
<script>

import {listKnowledge} from "@/api/knowledge/knowledge";
import {listSpecial} from "@/api/knowledge/special";
import {sendMessage} from "@/api/msg";

export default {
  data() {
    return {
      loading: false,
      seconds: 0,
      total: 0,
      timerId: null,
      pagerCount: 2,
      form: {
        pageNum: 1,
        pageSize: 10,
        cautionID: null,
        keyWords: null,
        inform: [],
        address: null,
        date: null,
        distype: null,
        disposeObj: null,
        generalType: null,
        specialType: null,
        securityType: null,
        siteID1: null,
        siteID2: null,
      },
      customerInfo: null,
      informList: [],
      generalInfo: [],
      specialInfo: [],
      securityInfo: [],
      screenHeight: document.body.clientHeight,
      rules: {
        address: [
          {required: true, message: "地址不能为空", trigger: "blur"}
        ],
        date: [
          {required: true, message: "立案时间不能为空", trigger: "blur"}
        ],
        distype: [
          {required: true, message: "灾情类型不能为空", trigger: "blur"}
        ],
        siteID1: [
          {required: true, message: "主管队站不能为空", trigger: "blur"}
        ]
      }
    }
  },
  created() {
    this.$root.loadGlobalData()
    let queryParameters = this.$route.query
    if (queryParameters && queryParameters) {
      this.form.cautionID = queryParameters.cautionid
      this.form.date = queryParameters.cautiontime
      this.form.distype = queryParameters.distypeid
      this.form.disposeObj = queryParameters.dillobject
      this.form.address = queryParameters.location
      this.form.siteID1 = queryParameters.siteid
      this.form.siteID2 = queryParameters.siteid2 ? queryParameters.siteid2.split(',') : []
      if (queryParameters.detailtype in this.$root.totalGeneralType) {
        this.form.generalType = queryParameters.detailtype
      } else {
        this.form.specialType = queryParameters.detailtype
      }
      console.log(this.form)
    }
  },
  mounted() {
    const that = this
    window.onresize = () => {
      return (() => {
        window.screenHeight = document.body.clientHeight
        that.screenHeight = window.screenHeight
      })()
    }
  },
  methods: {
    /** 搜索按钮操作 */
    handleQuery() {
      this.$refs['cautionForm'].validate(valid =>{
        if (valid){
          this.resetTimer()
          this.form.pageNum = 1
          this.getInfo()
        }
      })
    },
    // 发送消息
    sendInfo() {
      // 判断自定义消息是否为 null，若不为 null 则加入 inform 列表
      if (this.customerInfo) {
        this.form.inform.push({informid: null, inform: this.customerInfo, librarytype: null})
      }
      console.log('this.form:', this.form)
      sendMessage(this.form).then(response => {
        if (response.code === 200) {
          this.msgSuccess("消息推送成功");
        } else (
          this.msgError("消息推送失败\n" + response.data)
        )
      })
      // console.log('send info')
    },
    // 倒计时结束自动发送
    autoSend() {
      console.log(this.informList)
      if (this.informList.length > 0) {
        this.seconds = 30
        // 倒计时 30 s
        this.timerId = setInterval(args => {
          this.seconds--
          if (this.seconds === 0) {
            clearInterval(this.timerId)
            this.sendInfo()
          }
        }, 1000)
      }
    },
    // 多选消息
    handleSelectChange(val) {
      this.resetTimer()
      console.log(val)
      this.form.inform = val
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.form = {}
      this.form['pageNum'] = 1
      this.form['pageSize'] = 10
      this.informList = []
      this.resetForm('cautionForm')
      this.resetTimer()
    },
    filterTag(value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    onSubmit() {
      console.log('submit!')
    },
    // 匹配提示信息
    getInfo() {
      this.loading = true
      // 若存在专项类型，则匹配专项库
      if (this.form.specialType) {
        let queryParams = {
          pageNum: this.form.pageNum,
          pageSize: this.form.pageSize,
          detailtype: this.form.sepcialType,
          inform: this.form.keyWords
        }
        listSpecial(queryParams).then(response => {
          this.informList = response.rows
          this.total = response.total
          this.loading = false
          this.autoSend()
        })
      } else {
        let queryParams = {
          pageNum: this.form.pageNum,
          pageSize: this.form.pageSize,
          disastertype: this.form.distype,
          disposeobj: this.form.disposeObj,
          detailtype: this.form.generalType,
          inform: this.form.keyWords
        }
        listKnowledge(queryParams).then(response => {
          this.informList = response.rows
          this.total = response.total
          this.loading = false
          this.autoSend()
        })
      }
    },
    // 取消倒计时
    resetTimer() {
      if (this.timerId) {
        clearInterval(this.timerId)
        this.seconds = 0
      }
    }
  }
}
</script>
<style>
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
  color: black;
  text-align: center
}

.icon-style {
  padding: 8px 0px 10px 10px;
}

.fujian-style {
  width: 100%;
  margin-top: 30px;
  vertical-align: middle;
  float: left;
  display: flex;
  justify-content: flex-end;
}


.el-card {
  height: 40px;
  background: lightskyblue;
}

.el-card__body {
  padding: 8px 0px 10px 10px;
}

.table-style {
  background: white;
  padding: 5px 20px 30px 30px;
  /* height: 100%; */
  max-height: calc(70vh);
}

.el-form-item {
  margin-bottom: 5px;
}

element.style {
  padding-left: 0px;
  padding-right: 0px;
}

/* .el-date-editor.el-input, .el-date-editor.el-input__inner{
  width: 208px;
} */
/* .el-input {
  width: 208px;
} */

</style>

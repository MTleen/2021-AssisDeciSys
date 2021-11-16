/*
 * @Description:
 * @Author: Shengxiang Hu
 * @Date: 2021-10-14 19:50:08
 * @LastEditors: Shengxiang Hu
 * @LastEditTime: 2021-10-20 14:32:37
 * @FilePath: \2021-AssisDeciSys\RuoYi-Vue-master\ruoyi-ui\src\main.js
 */
import Vue from 'vue'

import Cookies from 'js-cookie'

import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import '@/assets/styles/index.scss' // global css
import '@/assets/styles/ruoyi.scss' // ruoyi css
import App from './App'
import store from './store'
import router from './router'
import directive from './directive' //directive

import './assets/icons' // icon
import './permission' // permission control
import {getDicts} from "@/api/system/dict/data";
import {getConfigKey} from "@/api/system/config";
import {
  parseTime,
  resetForm,
  addDateRange,
  selectDictLabel,
  selectDictLabels,
  download,
  handleTree
} from "@/utils/ruoyi";
import Pagination from "@/components/Pagination";
// 自定义表格工具组件
import RightToolbar from "@/components/RightToolbar"
// 富文本组件
import Editor from "@/components/Editor"
// 文件上传组件
import FileUpload from "@/components/FileUpload"
// 图片上传组件
import ImageUpload from "@/components/ImageUpload"
// 字典标签组件
import DictTag from '@/components/DictTag'
// 日期选择组件
import CusDatePicker from "@/components/CusDatePicker";
// 头部标签组件
import VueMeta from 'vue-meta'
import {getToken} from '@/utils/auth'
import {listDisastertype} from "@/api/knowledge/disastertype";
import {listDetailtype} from "@/api/knowledge/detailtype";
import {listDisposeobj} from "@/api/knowledge/disposeobj";
import {listSite} from "@/api/information/site";

import axios from 'axios'

// 全局方法挂载
Vue.prototype.getDicts = getDicts
Vue.prototype.getConfigKey = getConfigKey
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.selectDictLabel = selectDictLabel
Vue.prototype.selectDictLabels = selectDictLabels
Vue.prototype.download = download
Vue.prototype.handleTree = handleTree
// 一次性读取数据库的最大记录数
Vue.prototype.MAXCOUNT = 1024

Vue.prototype.$axios = axios
Vue.prototype.HOST = '/weather'

Vue.prototype.totalDetailType = {}
Vue.prototype.totalDisposeObj = {}
Vue.prototype.totalDisType = {}
Vue.prototype.totalSites = {}

// 判断是否登录，如果已登录加载全局对象
Vue.prototype.loadGlobalData = function () {
  if (getToken() && Object.keys(Vue.prototype.totalDisType).length === 0) {
    console.log('加载全局对象')
    let commonQueryParams = {
      pageNum: 1,
      pageSize: Vue.prototype.MAXCOUNT
    }
    // load all disaster type
    listDisastertype(commonQueryParams).then(response => {
      let totalDisType = {}
      for (let row of response.rows) {
        totalDisType[row.typeid] = row.typename
      }
      Vue.prototype.totalDisType = totalDisType
    })
    // load all detail type
    listDetailtype(commonQueryParams).then(response => {
      let totalDetailType = {}
      // console.log(response.rows)
      for (let row of response.rows) {
        totalDetailType[row.typeid] = [row.typename, row.priority]
      }
      Vue.prototype.totalDetailType = totalDetailType
    })
    // load all dispose objects
    listDisposeobj(commonQueryParams).then(response => {
      // console.log(this.prototype)
      let totalDisposeObj = {}
      // console.log(response.rows)
      for (let row of response.rows) {
        totalDisposeObj[row.objid] = row.objname
      }
      Vue.prototype.totalDisposeObj = totalDisposeObj;
    })
    // load all sites
    listSite(commonQueryParams).then(response => {
      let totalSite = {}
      for(let row of response.rows){
        totalSite[row.siteid]  =row.sitename
      }
      Vue.prototype.totalSites = totalSite;
    })
    // Vue.prototype.totalSites = {1: '大场支队', 2: '杨行支队', 3: '顾村支队'}
    // load all library types
    Vue.prototype.totalLibType = { 1: '通用', 3: '专项', 2: '安全'}
  }
}

Vue.prototype.loadGlobalData()

Vue.prototype.msgSuccess = function (msg) {
  this.$message({showClose: true, message: msg, type: "success"});
}

Vue.prototype.msgError = function (msg) {
  this.$message({showClose: true, message: msg, type: "error"});
}

Vue.prototype.msgInfo = function (msg) {
  this.$message.info(msg);
}

// 全局组件挂载
Vue.component('DictTag', DictTag)
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)
Vue.component('Editor', Editor)
Vue.component('FileUpload', FileUpload)
Vue.component('ImageUpload', ImageUpload)
Vue.component('CusDatePicker', CusDatePicker)

Vue.use(directive)
Vue.use(VueMeta)

/**
 * If you don't want to use mock-server
 * you want to use MockJs for mock api
 * you can execute: mockXHR()
 *
 * Currently MockJs will be used in the production environment,
 * please remove it before going online! ! !
 */

Vue.use(Element, {
  size: Cookies.get('size') || 'medium' // set element-ui default size
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})

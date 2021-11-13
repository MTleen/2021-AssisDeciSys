<template>
  <el-date-picker
    clearable
    v-model="sendtimes"
    type="daterange"
    align="right"
    unlink-panels
    range-separator="至"
    start-placeholder="开始日期"
    end-placeholder="结束日期"
    value-format="yyyy-MM-dd"
    :picker-options="pickerOptions"
  @change="handleChange">
  </el-date-picker>
</template>

<script>

export default {
  name: 'CusDatePicker',
  props: {
    sendtimes: {
      type: Array,
      default() {
        return []
      }
    },
    pickerOptions: {
      type: Object,
      default() {
        return {
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
        }
      }
    }
  },
  data(){
    return {
      sendtimes: []
    }
  },
  methods:{
    handleChange(){
      this.$emit('change', this.sendtimes)
    }
  }
}
</script>

<style scoped>
</style>


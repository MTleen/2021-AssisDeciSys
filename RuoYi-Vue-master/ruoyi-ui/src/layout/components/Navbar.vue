<template>
  <div class="navbar">
  <el-row>
    <div class="new-banner">
      <div>
          <img :src="logo" class="logo-style">

      </div>
      <div class="title-container">
        <span class="title-style">宝山消防辅助决策管理系统</span>
        <div class="time-style">
         {{dateFormat(date)}}
        </div>
      </div>

      <div class="weather-container">
        <div class="weather-style">
          <div>
            <span>今 日</span>
          </div>
          <div class="weatherword-style">
            <span>天 气</span>
          </div>
        </div>
        <div class="weatherContent" >
          <div class="watherContent-style">
          <span >天气：{{weatherData.realtime.info}}</span>
          </div>
          <div class="watherContent-style">
          <span >温度：{{weatherData.realtime.temperature}}℃</span>
          </div>
          <div class="watherContent-style">
          <span >湿度：{{weatherData.realtime.humidity}}%</span>
          </div>
        </div>

        <div class="weatherContent">
          <div class="watherContent-style">
          <span >风力：{{weatherData.realtime.power}}</span>
          </div>
          <div class="watherContent-style">
          <span >风向：{{weatherData.realtime.direct}}</span>
          </div>
        </div>

      </div>
    </div>
  </el-row>

    <hamburger id="hamburger-container" :is-active="sidebar.opened" class="hamburger-container" @toggleClick="toggleSideBar" />

    <breadcrumb id="breadcrumb-container" class="breadcrumb-container" v-if="!topNav"/>
    <top-nav id="topmenu-container" class="topmenu-container" v-if="topNav"/>

    <div class="right-menu">
      <!-- <template v-if="device!=='mobile'">
        <search id="header-search" class="right-menu-item" />

        <el-tooltip content="源码地址" effect="dark" placement="bottom">
          <ruo-yi-git id="ruoyi-git" class="right-menu-item hover-effect" />
        </el-tooltip>

        <el-tooltip content="文档地址" effect="dark" placement="bottom">
          <ruo-yi-doc id="ruoyi-doc" class="right-menu-item hover-effect" />
        </el-tooltip>

        <screenfull id="screenfull" class="right-menu-item hover-effect" />

        <el-tooltip content="布局大小" effect="dark" placement="bottom">
          <size-select id="size-select" class="right-menu-item hover-effect" />
        </el-tooltip>

      </template> -->

      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">
        <div class="avatar-wrapper">
          <img :src="avatar" class="user-avatar">
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown">
          <router-link to="/user/profile">
            <el-dropdown-item>个人中心</el-dropdown-item>
          </router-link>
          <el-dropdown-item @click.native="setting = true">
            <span>布局设置</span>
          </el-dropdown-item>
          <el-dropdown-item divided @click.native="logout">
            <span>退出登录</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import TopNav from '@/components/TopNav'
import Hamburger from '@/components/Hamburger'
import Screenfull from '@/components/Screenfull'
import SizeSelect from '@/components/SizeSelect'
import Search from '@/components/HeaderSearch'
import RuoYiGit from '@/components/RuoYi/Git'
import RuoYiDoc from '@/components/RuoYi/Doc'
import logoImg from '@/assets/logo/logo1.png'

export default {
  data () {
    return {
      logo: logoImg,
      date: new Date(),
      weatherData: {},
    }
  },
  components: {
    Breadcrumb,
    TopNav,
    Hamburger,
    Screenfull,
    SizeSelect,
    Search,
    RuoYiGit,
    RuoYiDoc
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'device'
    ]),
    setting: {
      get() {
        return this.$store.state.settings.showSettings
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'showSettings',
          value: val
        })
      }
    },
    topNav: {
      get() {
        return this.$store.state.settings.topNav
      }
    }
  },
  methods: {
    toggleSideBar() {
      this.$store.dispatch('app/toggleSideBar')
    },
    async logout() {
      this.$confirm('确定注销并退出系统吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$store.dispatch('LogOut').then(() => {
          location.href = '/index';
        })
      }).catch(() => {});
    },
    dateFormat(time) {
          var date=new Date(time);
          var year=date.getFullYear();
          /* 在日期格式中，月份是从0开始的，因此要加0
          * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
          * */
          var month= date.getMonth()+1<10 ? "0"+(date.getMonth()+1) : date.getMonth()+1;
          var day=date.getDate()<10 ? "0"+date.getDate() : date.getDate();
          var hours=date.getHours()<10 ? "0"+date.getHours() : date.getHours();
          var minutes=date.getMinutes()<10 ? "0"+date.getMinutes() : date.getMinutes();
          var seconds=date.getSeconds()<10 ? "0"+date.getSeconds() : date.getSeconds();
          // 拼接
          return year+"年"+month+"月"+day+"日 "+hours+":"+minutes+":"+seconds;
    },
 
    getWeather() {
      // let url = this.HOSt + '/simpleWeather/query',
      let that = this
      this.$axios.get('/weather/simpleWeather/query?city=%E4%B8%8A%E6%B5%B7&key=d51f2bacbdb845a045fcefc04f207d86'
      
      ).then(function(reponse){
        that.weatherData=reponse.data.result;
        console.log(that.weatherData);
			}).catch((error) => {
        console.log(Error);
      })
    }
    

  },


  mounted() {
    this.getWeather()
    //显示当前日期时间
    let _this = this// 声明一个变量指向Vue实例this，保证作用域一致
    this.timer = setInterval(() => {
    _this.date = new Date(); // 修改数据date
    }, 1000)

  },
  beforeDestroy() {
        if (this.timer) {
          clearInterval(this.timer); // 在Vue实例销毁前，清除我们的定时器
        }
  },



}

</script>

<style lang="scss" scoped>
.navbar {
  height: 70%;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background .3s;
    -webkit-tap-highlight-color:transparent;

    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .topmenu-container {
    position: absolute;
    left: 50px;
  }

  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .right-menu {
    float: right;
    height: 100%;
    // line-height: 50px;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background .3s;

        &:hover {
          background: rgba(0, 0, 0, .025)
        }
      }
    }

    .avatar-container {
      margin-right: 30px;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
  .logo-style{
    height: 70px;
    width: 70px;
    margin-left: 30px;
    margin-top: 10px;
    vertical-align: middle;
  }
  .title-container{
    display: flex;
    flex-direction: column;
    margin: 20px 10px 20px 20px;

    }
  .title-style{
    color: white;
    font-size: 21px;
    // display: inline-block;

  }
  .time-style{
    color:white;
    margin: 16px 0px 5px;
  }
  .weather-container{
    margin-left: auto;
    margin-right: 50px;
    display: flex;
  }
  .weather-style{
    color:white;
    display: flex;
    flex-direction: column;
    font-size: 20px;
    margin-right:20px;
    margin-top: 5% ;
  }
  .weatherword-style{
  margin-top: 10px;
  margin-bottom: 10px ;
  }
  .weatherContent{
    display: flex;
    flex-direction: column;
    color: white;
    margin-top: 7px;
  }
  .watherContent-style{
    margin-top: 6px;
    margin-right:10px;
    margin-left:5px;
    font-size: 14px;
  }
}
.new-banner{
  height: 65%;
  width: 100%;
  background: rgb(38, 159, 235);
  display: flex;
  justify-content: flex-start;
  flex-direction: row;
}

</style>

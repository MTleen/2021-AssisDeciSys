<template>
  <div class="login">
    <el-col align='center'>
    <div class=" title-logo-container">
      <img :src="logo" class="title-logo">
      <span class="title-style">宝山区消防救援支队</span><br>
      <span class="title-style">消防作战指挥辅助决策管理系统</span>
    </div>



    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">


      <el-form-item prop="username">
        <el-input v-model="loginForm.username" type="text" auto-complete="off" placeholder="账号">
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>

      <el-form-item prop="password">
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>

      <el-form-item v-if="captchaOnOff" prop="code">
        <el-input
          v-model="loginForm.code"
          auto-complete="off"
          placeholder="验证码"
          style="width: 63%"
          @keyup.enter.native="handleLogin"
        >
          <svg-icon slot="prefix" icon-class="validCode" class="el-input__icon input-icon" />
        </el-input>
        <div class="login-code">
          <img :src="codeUrl" class="login-code-img" @click="getCode">
        </div>
      </el-form-item>
      <!-- <el-checkbox v-model="loginForm.rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox> -->

      <el-form-item style="width:100%;">
        <el-button
          :loading="loading"
          size="medium"
          type="primary"
          style="width:50%; height: 50px; margin-top:10%"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading" style="height: 45px">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <div v-if="register" style="float: right;">
          <router-link class="link-type" :to="'/register'">立即注册</router-link>
        </div>
      </el-form-item>
      <div align="center">
        <img :src="Erweima" class="ewm-style">
      </div>
    </el-form>

    <!--  底部  -->
    <div class="el-login-footer">
      <span>消防作战指挥辅助决策管理系统由上海大学提供技术服务支持</span>
    </div>
    </el-col>
  </div>
</template>

<script>
import { getCodeImg } from '@/api/login'
import Cookies from 'js-cookie'
import { encrypt, decrypt } from '@/utils/jsencrypt'
import logoImg from '@/assets/logo/logo1.png'
import ErweimaImg from '@/assets/logo/WexinLogo.png'
export default {
  name: 'Login',
  data() {
    return {
      codeUrl: '',
      logo: logoImg,
      cookiePassword: '',
      Erweima: ErweimaImg,
      loginForm: {
        username: 'admin',
        password: 'admin123',
        rememberMe: false,
        code: '',
        uuid: ''
      },
      loginRules: {
        username: [
          { required: true, trigger: 'blur', message: '请输入您的账号' }
        ],
        password: [
          { required: true, trigger: 'blur', message: '请输入您的密码' }
        ],
        code: [{ required: true, trigger: 'change', message: '请输入验证码' }]
      },
      loading: false,
      // 验证码开关
      captchaOnOff: false,
      // 注册开关
      register: false,
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  created() {
    this.getCode()
    this.getCookie()
  },
  methods: {
    getCode() {
      getCodeImg().then(res => {
        this.captchaOnOff = res.captchaOnOff === undefined ? true : res.captchaOnOff
        if (this.captchaOnOff) {
          this.codeUrl = 'data:image/gif;base64,' + res.img
          this.loginForm.uuid = res.uuid
        }
      })
    },
    getCookie() {
      const username = Cookies.get('username')
      const password = Cookies.get('password')
      const rememberMe = Cookies.get('rememberMe')
      this.loginForm = {
        username: username === undefined ? this.loginForm.username : username,
        password: password === undefined ? this.loginForm.password : decrypt(password),
        rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
      }
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {

          this.loading = true
          if (this.loginForm.rememberMe) {
            Cookies.set('username', this.loginForm.username, { expires: 30 })
            Cookies.set('password', encrypt(this.loginForm.password), { expires: 30 })
            Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 })
            // Cookies.set('username', this.loginForm.username)
            // Cookies.set('password', encrypt(this.loginForm.password))
            // Cookies.set('rememberMe', this.loginForm.rememberMe)
          } else {
            Cookies.remove('username')
            Cookies.remove('password')
            Cookies.remove('rememberMe')
          }
          this.$store.dispatch('Login', this.loginForm).then(() => {
            this.$router.push({ path: this.redirect || '/' }).catch(() => {})
          }).catch(() => {
            this.loading = false
            if (this.captchaOnOff) {
              this.getCode()
            }
          })
        }
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/bg.png");
  background-size: cover;
}
.title {
  margin: 0px auto 30px auto;
  text-align: center;
  color: #707070;
}

.login-form {
  border-radius: 7px;
  width: 450px;

  // padding: 25px 25px 5px 25px;
.el-input {
    height: 50px;
    input {
      height: 45px;
    }
  }

.input-icon {
    height: 39px;
    width: 19px;
    margin-left: 2px;
  }
}
.login-tip {
  font-size: 13px;
  text-align: center;
  color: #bfbfbf;
}
.login-code {
  width: 33%;
  height: 38px;
  float: right;
  img {
    cursor: pointer;
    vertical-align: middle;
  }
}
.el-login-footer {
  height: 40px;
  line-height: 40px;
  position: fixed;
  bottom: 0;
  width: 100%;
  text-align: center;
  color: #fff;
  font-family: Arial;
  font-size: 12px;
  letter-spacing: 1px;
}
.login-code-img {
      width: 38px;
      height: 40px;

}
.title-logo {
  width: 100px;
  height: 100px;
  vertical-align: middle;
  margin-right: 12px;
  margin-bottom: 12px;
}
.title-style {
  color: #fff;
  font-size: 40px;
  text-align: right;
  margin-left: 7px;
  margin: 0;
}

.title-logo-container {
  position: relative;
  width: 100%;
  height: 100px;
  line-height: 50px;
  // overflow: hidden;
  margin-bottom: 10%;
}

.ewm-style{
  margin-top: 10%;
  width: 140px;
  height: 140px;

}
</style>

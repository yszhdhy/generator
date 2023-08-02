<script setup lang="ts">
import { User, Lock, Warning } from '@element-plus/icons-vue'
import { Ref, reactive, ref } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { ElNotification } from 'element-plus'
import { getTime } from '@/utils/time'
import useUserStore from '@/store/modules/user'
import Identify from '@/components/VerifyCode/index.vue'
// VerifyCode import

let $router = useRouter()
let $route = useRoute()
let loading = ref(false)

const identifyCode = ref('1234')
const identifyCodes = ref('1234567890abcdefjhijklinopqrsduvwxyz')

const refreshCode = () => {
  identifyCode.value = ''
  makeCode(identifyCode, 4)
}

const makeCode = (o: Ref<any>, l: number) => {
  for (let i = 0; i < l; i++) {
    identifyCode.value +=
        identifyCodes.value[randomNum(0, identifyCodes.value.length)]
  }
}

const randomNum = (min: number, max: number) => {
  return Math.floor(Math.random() * (max - min) + min)
}

let useStore = useUserStore()
let loginForms = ref()

const loginForm = reactive({
  username: 'admin',
  password: 'atguigu123',
  verifyCode: '1234',
})

const validatorUsername = (rule: any, value: any, callback: any) => {
  if (value.length === 0) {
    callback(new Error('请输入账号'))
  } else {
    callback()
  }
}

const validatorPassword = (rule: any, value: any, callback: any) => {
  if (value.length === 0) {
    callback(new Error('请输入密码'))
  } else if (value.length < 6 || value.length > 16) {
    callback(new Error('密码应为6~16位的任意组合'))
  } else {
    callback()
  }
}

const validatorVerifyCode = (rule: any, value: any, callback: any) => {
  console.log(value, identifyCode.value)

  if (value.length === 0) {
    callback(new Error('请输入验证码'))
  } else if (value.length < 4) {
    callback(new Error('请输入正确的验证码'))
  } else if (identifyCode.value !== value) {
    callback(new Error('请输入正确的验证码'))
  } else if (identifyCode.value === value) {
    callback()
  }
}

const login = async () => {
  await loginForms.value.validate()
  loading.value = true
  try {
    await useStore.userLogin(loginForm)
    let redirect: string = $route.query.redirect as string
    await $router.push({ path: redirect || '/' })
    await $router.push('/')
    ElNotification({
      type: 'success',
      message: '登陆成功',
      title: `Hi,${r"${"}getTime()${r"}"}好`,
    })
    loading.value = false
  } catch (error) {
    loading.value = false
    ElNotification({
      type: 'error',
      message: (error as Error).message,
    })
  }
}

const rules = {
  username: [
    {
      trigger: 'change',
      validator: validatorUsername,
    },
  ],
  password: [
    {
      trigger: 'change',
      validator: validatorPassword,
    },
  ],
  verifyCode: [
    {
      trigger: 'blur',
      validator: validatorVerifyCode,
    },
  ],
}
</script>

<template>
  <div id="userLayout">
    <div class="login_panel">
      <div class="login_panel_form">
        <div class="login_panel_form_title">
          <img
              class="login_panel_form_title_logo"
              src="@/assets/images/login_left.svg"
              alt=""
          >
          <p class="login_panel_form_title_p"   >Universal template</p>
        </div>
        <el-form
            :model="loginForm"
            :rules="rules"
            ref="loginForms"
        >
          <el-form-item prop="username">
            <el-input
                :prefix-icon="User"
                v-model="loginForm.username"
                clearable
                size="large"
                placeholder="请输入用户名"
            />
          </el-form-item>
          <el-form-item prop="password">
            <el-input
                :prefix-icon="Lock"
                show-password
                size="large"
                v-model="loginForm.password"
                type="password"
                placeholder="请输入密码"
                clearable
            />
          </el-form-item>
          <el-form-item prop="verifyCode">
            <el-input
                :prefix-icon="Warning"
                show-password
                v-model="loginForm.verifyCode"
                placeholder="VerifyCode"
                size="large"
                maxlength="4"
            >
              <template #append>
                <Identify :identifyCode="identifyCode" @click="refreshCode" />
              </template>
            </el-input>
          </el-form-item>
          <el-form-item>
            <el-button
                :loading="loading"
                type="primary"
                size="large"
                style="width: 46%; margin-left: 8%"
                @click="login"
            >登 录</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div class="login_panel_right" />
    </div>
  </div>
</template>

<style lang="scss" scoped>
@import "@/styles/newLogin.scss";
</style>

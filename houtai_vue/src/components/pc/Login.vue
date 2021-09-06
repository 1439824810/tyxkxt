<template>
<!-- 登录页 -->
  <div class="login_container">
    <div class="login_box">
      <div class="avatar_box">
        <img src="../../assets/logo.jpg" alt="" />
      </div>
      <el-form
        ref="loginFormRef"
        :model="loginForm"
        :rules="loginFormRules"
        class="loginForm"
      >
        <el-form-item prop="tgh">
          <el-input
            v-model="loginForm.tgh"
            placeholder="请输入账号"
            prefix-icon="el-icon-user"
          ></el-input>
        </el-form-item>
        <el-form-item prop="pwd">
          <el-input
            v-model="loginForm.pwd"
            placeholder="请输入密码"
            type="password"
            prefix-icon="el-icon-goods"
          ></el-input>
        </el-form-item>
        <el-form-item class="btns">
          <el-button size="medium" type="primary" @click="login"
            >登陆</el-button
          >
          <el-button size="medium" type="info" @click="resetLoginForm"
            >重置</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 绑定数据
      loginForm: {
        tgh: "10086",
        pwd: "123456",
      },
      //  表单验证
      loginFormRules: {
        tgh: [
          {
            required: true,
            message: "请输入账号",
            trigger: "blur",
          },
          {
            min: 1,
            max: 15,
            message: "长度在 1 到 10 个字符/工号",
            trigger: "blur",
          },
        ],
        pwd: [
          {
            required: true,
            message: "请输入密码",
            trigger: "blur",
          },
          {
            min: 4,
            max: 15,
            message: "长度在 4 到 15 个字符",
            trigger: "blur",
          },
        ],
      },
    };
  },
  created() {
  },
  methods: {
    //   重置
    resetLoginForm() {
      this.$refs.loginFormRef.resetFields();
    },
    async login() {
      this.$refs.loginFormRef.validate(async (valid) => {
        // 为空就拒绝
        if (!valid) return null;
        // 发送请求，获取信息
        console.log(this.loginForm);
        const { data: res } = await this.$http.post(
          "login?page=1&pageSize=1",
          this.loginForm
        );
        console.log(res.msg);

        if (res.status !== 200) {
          return this.$message.error(res.msg);
        } else if (res.status == 200) {
          sessionStorage.setItem(
            "userInfo",
            JSON.stringify(res.data.usersTyList[0])
          );
          this.$router.push("/phome");
        }
      });
    },
  },
};
</script>

<style>
.el-input {
  width: 100%;
}
.login_container {
  background-color: #2b4b6b;
  height: 100%;
}

.login_box {
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.login_box .avatar_box {
  height: 130px;
  width: 130px;
  border: 1px solid #eee;
  border-radius: 50%;
  padding: 10px;
  box-shadow: 0 0 10px #ddd;
  position: absolute;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #fff;
}

.login_box .avatar_box img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  background-color: #eee;
}

.loginForm {
  position: absolute;
  top: 90px;
  bottom: 0;
  width: 100%;
  padding: 0 20px;
  box-sizing: border-box;
}

.btns {
  display: flex;
  justify-content: flex-end;
}
</style>

<template>
<!-- 主页 -->
  <div>
    <el-card class="card">
      <div class="stuInfo">
        <el-form :model="stuInfo" label-width="100px" ref="form" label-position="left">
          <el-form-item label="学号" prop="sno">
            <el-input v-model="stuInfo.sno" placeholder="学号" disabled></el-input>
          </el-form-item>
          <el-form-item label="姓名" prop="sname">
            <el-input v-model="stuInfo.sname" placeholder="姓名" disabled></el-input>
          </el-form-item>
          <el-form-item label="年级" prop="sqrade">
            <el-input v-model="stuInfo.sqrade" placeholder="年级" disabled></el-input>
          </el-form-item>
          <el-form-item label="班级" prop="sclass">
            <el-input v-model="stuInfo.sclass" placeholder="班级" disabled></el-input>
          </el-form-item>
          <el-form-item label="教学院" prop="sxy">
            <el-input v-model="stuInfo.sxy" placeholder="教学院" disabled></el-input>
          </el-form-item>
        </el-form>
      </div>
      <div class="btns">
        <el-button type="primary" size="small" @click="ToTeacherInfo">教师信息</el-button><br>
        <el-button type="primary" size="small" @click="ToClassinfo">课程信息</el-button><br>
        <el-button type="primary" size="small" @click="ToXk">班课信息</el-button><br>
        <el-button type="primary" size="small" @click="ToXkInfo">选课信息</el-button>
      </div>
    </el-card>
  </div>
</template>
<script>
export default {
  data() {
    return {
      sno: "",
      stuInfo: {},
    };
  },
  created() {
    this.getInfo();
  },
  methods: {
    async getInfo() {
      this.sno = location.href.split("?")[1].split("=")[1].split("#")[0];
      let obj = {
        sname: "",
        sno: this.sno,
        sxy: "",
        sqrade: "",
      };
      const { data: res } = await this.$http.post(
        `stuSelectAll?page=1&pageSize=1`,
        obj
      );
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.stuInfo = res.data.stuTyList[0];
    },
    ToTeacherInfo() {
      this.$router.push("/teacherinfo");
    },
    ToClassinfo() {
      this.$router.push("/classinfo");
    },
    ToXk() {
      this.$router.push("/xk");
    },
    ToXkInfo() {
      this.$router.push("/xkInfo");
    },
  },
};
</script>
<style scoped>
.card {
  position: absolute;
  width: 100%;
  height: 98%;
  overflow: scroll;
}
.stuInfo {
  width: 100%;
  /* height: 30%; */
}
.btns{
  height: 200px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.btns .el-button{
  width: 100%;
}
</style>
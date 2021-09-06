<template>
<!-- 选课页面 -->
  <div class="box">
    <el-card>
      <el-row>
        <el-col :span="9">
          <div class="block">
            <el-cascader
              v-model="TimeData"
              ref="cascader"
              :options="options"
              :props="{ checkStrictly: true }"
              clearable
              placeholder="上课时间"
            ></el-cascader>
          </div>
        </el-col>

        <el-col :span="7">
          <div class="block">
            <el-cascader
              v-model="ZhuanxiangData"
              ref="cascader1"
              :options="optionsClass"
              :props="{ checkStrictly: true }"
              clearable
              placeholder="专项"
            ></el-cascader>
          </div>
        </el-col>
        <el-col :span="8">
          <div class="block">
            <el-cascader
              v-model="searchSqrade"
              ref="cascader2"
              :options="optionsSqrade"
              :props="{ checkStrictly: true }"
              clearable
              placeholder="开班年份"
            ></el-cascader>
          </div>
        </el-col>
      </el-row>
      <el-row class="btns">
        <el-button type="primary" icon="el-icon-search" @click="select"
          >查询</el-button
        >

        <el-button type="success" @click="clearAllSel">清除选项</el-button>
        <el-button @click="ToHome" type="primary" size="small" round
          >返回首页</el-button
        >
      </el-row>
      <div>
        <el-table
          :data="TeacherClassInfoList"
          ref="refTable"
          style="width: 100%"
          height="600px"
        >
          <el-table-column label="课程名" prop="cname"> </el-table-column>
          <el-table-column label="最大选课人数" prop="rsxz"> </el-table-column>
          <el-table-column label="选课人数" prop="xkrs"> </el-table-column>
          <el-table-column label="星期" prop="sksq"> </el-table-column>
          <el-table-column label="时段" prop="sksd"> </el-table-column>
          <el-table-column label="开课年级" prop="sqrade"> </el-table-column>
          <!-- <el-table-column label="是否结课" prop="isend"> </el-table-column> -->
          <el-table-column label="限定性别" prop="ssex"> </el-table-column>
          <el-table-column label="教师名称" prop="tname"> </el-table-column>
          <el-table-column label="校区" prop="xq"> </el-table-column>
          <el-table-column label="操作">
            <template slot-scope="scope">
              <el-button type="danger" size="mini" @click="xk(scope.row)"
                >选课</el-button
              >
            </template>
          </el-table-column>
        </el-table>
        <!-- 分页 -->
        <div class="fenye">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[10, 15, 30]"
            :page-size="page_size"
            layout="prev, pager, next"
            :total="total"
          >
          </el-pagination>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {
        addSqrade: "",
        addTimeData: "",
        addZhuanxiangData: "",
        addTeacher: "",
        addSexData: "",
        addSqData: "",
        num: "",
      },
      total: 20,
      TeacherClassInfoList: [],
      searchSqrade: [],
      addDialogVisible: false,
      TimeData: [],
      ZhuanxiangData: [],
      optionsSqrade: [],
      SexData: [],
      optionsTeacher: [],
      optionsSq: [
        {
          value: "1",
          label: "主校区",
        },
        {
          value: "2",
          label: "双吉校区",
        },
      ],
      optionsClass: [],
      optionsSqradeAddClass: [],
      optionsSqrade: [
        {
          value: "2021",
          label: "2021",
        },
      ],
      options: [
        {
          value: "周一",
          label: "周一",
          children: [
            {
              value: "12",
              label: "一二节",
            },
            {
              value: "34",
              label: "三四节",
            },
            {
              value: "56",
              label: "五六节",
            },
            {
              value: "78",
              label: "七八节",
            },
          ],
        },
        {
          value: "周二",
          label: "周二",
          children: [
            {
              value: "12",
              label: "一二节",
            },
            {
              value: "34",
              label: "三四节",
            },
            {
              value: "56",
              label: "五六节",
            },
            {
              value: "78",
              label: "七八节",
            },
          ],
        },
        {
          value: "周三",
          label: "周三",
          children: [
            {
              value: "12",
              label: "一二节",
            },
            {
              value: "34",
              label: "三四节",
            },
            {
              value: "56",
              label: "五六节",
            },
            {
              value: "78",
              label: "七八节",
            },
          ],
        },
        {
          value: "周四",
          label: "周四",
          children: [
            {
              value: "12",
              label: "一二节",
            },
            {
              value: "34",
              label: "三四节",
            },
            {
              value: "56",
              label: "五六节",
            },
            {
              value: "78",
              label: "七八节",
            },
          ],
        },
        {
          value: "周五",
          label: "周五",
          children: [
            {
              value: "12",
              label: "一二节",
            },
            {
              value: "34",
              label: "三四节",
            },
            {
              value: "56",
              label: "五六节",
            },
            {
              value: "78",
              label: "七八节",
            },
          ],
        },
      ],
      showStuStudentDialogVisible: false,
      showStuGradeDialogVisible: false,
      showStuGradeTable: [],
      row: {},
      currentPage: 1,
      page_size: 10,
      // 当前tcid
      tcid: "",
      delStu: {
        sno: "",
        tcid: "",
      },
      setStuGrade: {
        sno: "",
        tcid: "",
        sname: "",
        sno: "",
        zx1: "",
        zx2: "",
        tjq: "",
        xyp: "",
        pscj: "",
      },
      UpdateStuGrade: {
        sno: "",
        tcid: "",
        sname: "",
        sno: "",
        zx1: "",
        zx2: "",
        tjq: "",
        xyp: "",
        pscj: "",
        resid: "",
      },
    };
  },
  created() {
    this.getMenuList();
    this.getTeacherName();
    this.getSqradeList();
    this.getTeacherClassInfoList();
  },
  methods: {
    ToHome() {
      this.$router.push("/");
    },
    async xk(row) {
      const { data: res } = await this.$http.post("xk", {
        sno: location.href.split("?")[1].split("=")[1].split("#")[0],
        tcid: row.tcid,
      });
      this.$message.success(res.msg)
      this.getMenuList();
    },
    clearAllSel() {
      this.$refs.cascader.$refs.panel.clearCheckedNodes();
      this.$refs.cascader1.$refs.panel.clearCheckedNodes();
      this.$refs.cascader2.$refs.panel.clearCheckedNodes();
    },
    // 获取老师姓名
    async getTeacherName() {
      const { data: res } = await this.$http.post("teacherSelectAll", {
        retired: 0,
      });
      if (res.status !== 200) return this.$message.error(res.meta.msg);
      let arr = [];
      for (var i = 0; i < res.data.teacherTyList.length; i++) {
        let Obj = {
          value: "",
          label: "",
        };
        Obj.value = res.data.teacherTyList[i].tgh;
        Obj.label = res.data.teacherTyList[i].tname;
        arr.push(Obj);
      }
      this.optionsTeacher = arr;
    },
    // 获取课程列表
    async getMenuList() {
      const { data: res } = await this.$http.post("classSelectAll", {});
      if (res.status !== 200) return this.$message.error(res.msg);
      let arr = [];
      for (var i = 0; i < res.data.classTy.length; i++) {
        let Obj = {
          value: "",
          label: "",
        };
        Obj.value = res.data.classTy[i].cname;
        Obj.label = res.data.classTy[i].cname;
        arr.push(Obj);
      }
      this.optionsClass = arr;
    },
    // 获取课程列表
    async getSqradeList() {
      const { data: res } = await this.$http.post("selectAllTeacherClass", {});
      if (res.status !== 200) return this.$message.error(res.msg);
      let arr = [];
      for (var i = 0; i < res.data.teacherClassTyList.length; i++) {
        let Obj = {
          value: "",
          label: "",
        };
        Obj.value = res.data.teacherClassTyList[i].sqrade;
        Obj.label = res.data.teacherClassTyList[i].sqrade;
        arr.push(Obj);
      }
      this.optionsSqrade = arr;
    },
    // 点击修改页面大小
    handleSizeChange(val) {
      this.page_size = val;
      this.getTeacherClassInfoList();
    },
    // 分页改变
    handleCurrentChange(val) {
      this.currentPage = val;
      // this.getListUrl()
      this.getTeacherClassInfoList();
    },
    // 获取老师课程列表
    async getTeacherClassInfoList() {
      const { data: res } = await this.$http.post(
        `selectAllTeacherClassNoIsend?page=${this.currentPage}&pageSize=${this.page_size}`,
        {
          sksq: this.TimeData[0],
          sksd: this.TimeData[1],
          sqrade: this.searchSqrade[0],
          cname: this.ZhuanxiangData[0],
        }
      );
      // alert("getTeacherClassInfoList"+JSON.stringify(res))

      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }

      if (res.status === 200) {
        if (res.data === null || res.data === undefined) {
          this.TeacherClassInfoList = [];
        } else {
          // var week = ["周一", "周二", "周三", "周四", "周五"]
          var classTime = ["一二节", "三四节", "五六节", "七八节"];
          var yesno = ["是", "否"];
          var sex = ["男", "女"];
          var xq = ["主校区", "双吉校区"];
          var resData = res.data.teacherClassTyList;
          for (var i = 0; i < resData.length; i++) {
            if (resData[i].ssex === "0") {
              resData[i].ssex = sex[0];
            } else if (resData[i].ssex === "1") {
              resData[i].ssex = sex[1];
            }
          }
          for (var i = 0; i < resData.length; i++) {
            if (resData[i].isend === "0") {
              resData[i].isend = yesno[0];
            } else if (resData[i].isend === "1") {
              resData[i].isend = yesno[1];
            }
          }
          for (var i = 0; i < resData.length; i++) {
            if (resData[i].xq === "1") {
              resData[i].xq = xq[0];
            } else if (resData[i].xq === "2") {
              resData[i].xq = xq[1];
            }
          }
          for (var i = 0; i < resData.length; i++) {
            if (resData[i].sksd === "12") {
              resData[i].sksd = classTime[0];
            } else if (resData[i].sksd === "34") {
              resData[i].sksd = classTime[1];
            } else if (resData[i].sksd === "56") {
              resData[i].sksd = classTime[2];
            } else if (resData[i].sksd === "78") {
              resData[i].sksd = classTime[3];
            }
          }
          this.TeacherClassInfoList = resData;
        }
      }
      this.total = res.data.total;
    },

    // 查询按钮
    select() {
      console.log({
        c1: this.TimeData,
        c2: this.SexData,
        c3: this.ZhuanxiangData,
      });
      this.getTeacherClassInfoList();
    },
  },
};
</script>
<style scope>
.fenye {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}
.el-pagination {
  width: 400px;
}
.btns {
  margin-top: 5px;
  /* background-color: rgb(232, 243, 240); */
  /* border: 1px solid #EAECF0; */
  border-radius: 5px;
  display: flex;
  justify-content: space-around;
}
.btns .el-button {
  width: 50%;
}
</style>

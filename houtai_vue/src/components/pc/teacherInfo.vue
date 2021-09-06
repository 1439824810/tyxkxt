<template>
<!-- 教师信息 -->
  <div class="Fbox">
    <el-card>
      <div class="search">
        <el-input
          placeholder="请输入内容"
          v-model="input"
          class="input-with-select"
        >
          <el-select
            class="widthSelect"
            v-model="select"
            slot="prepend"
            placeholder="请选择"
          >
            <el-option label="工号" value="tgh"></el-option>
            <el-option label="姓名" value="tname"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search" @click="getTeacherList"
            >查询</el-button
          >
        </el-input>
      </div>
      <div class="search">
        <el-button @click="clearSelInp">清空</el-button>
      </div>
      <div class="rigAdd">
        <el-button type="success" @click="addTeacher">添加</el-button>
      </div>
      <!-- 上边列表 -->
      <el-table
        :data="tableData"
        border
        style="width: 100%"
        :height="he"
        :default-sort="{ prop: 'date', order: 'descending' }"
      >
        <el-table-column prop="tgh" label="工号" sortable> </el-table-column>
        <el-table-column prop="tname" label="姓名"> </el-table-column>
        <el-table-column prop="tsex" label="性别"> </el-table-column>
        <el-table-column prop="tdept" label="院系"> </el-table-column>
        <el-table-column prop="tinfo" label="简介"> </el-table-column>
        <el-table-column prop="retired" label="是否退休"> </el-table-column>
        <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <el-button
              type="primary"
              size="mini"
              @click="changeTeacher(scope.row)"
              >修改</el-button
            >
            <el-button type="danger" size="mini" @click="deleteEnter(scope.row)"
              >退休</el-button
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
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
        >
        </el-pagination>
      </div>
      <!-- 添加老师 -->
      <el-dialog
        :visible.sync="addTeacherForm"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <el-form
            :model="form"
            label-width="60px"
            ref="form"
            :rules="AddTeacherFormRules"
          >
            <el-form-item label="工号" prop="tgh">
              <el-input v-model="form.tgh" placeholder="工号"></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="tname">
              <el-input v-model="form.tname" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="tsex">
              <el-input v-model="form.tsex" placeholder="性别"></el-input>
            </el-form-item>
            <el-form-item label="院系" prop="tdept">
              <el-input v-model="form.tdept" placeholder="院系"></el-input>
            </el-form-item>
            <el-form-item label="简介" prop="tinfo">
              <el-input
                type="textarea"
                v-model="form.tinfo"
                placeholder="简介"
              ></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="resetForm">重置</el-button>
          <el-button type="primary" @click="SuccessDia">确定</el-button>
        </span>
      </el-dialog>
      <!-- 修改老师 -->
      <el-dialog
        :visible.sync="ChangeTeacherFormDia"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <el-form
            :model="ChangeTeacherForm"
            label-width="60px"
            ref="form"
            :rules="AddTeacherFormRules"
          >
            <el-form-item label="工号">
              <el-input
                v-model="ChangeTeacherForm.tgh"
                placeholder="工号"
                :disabled="edit"
              ></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="tname">
              <el-input
                v-model="ChangeTeacherForm.tname"
                placeholder="姓名"
              ></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="tsex">
              <el-input
                v-model="ChangeTeacherForm.tsex"
                placeholder="性别"
              ></el-input>
            </el-form-item>
            <el-form-item label="院系" tdept>
              <el-input
                v-model="ChangeTeacherForm.tdept"
                placeholder="院系"
              ></el-input>
            </el-form-item>
            <el-form-item label="简介" prop="tinfo">
              <el-input
                type="textarea"
                v-model="ChangeTeacherForm.tinfo"
                placeholder="简介"
              ></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="CancleDiaChange">取消</el-button>
          <el-button type="primary" @click="ChangeEnter">确定</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 添加表单验证
      AddTeacherFormRules: {
        tgh: [
          {
            required: true,
            message: "请输入工号",
            trigger: "blur",
          },
        ],
        tname: [
          {
            required: true,
            message: "请输入姓名",
            trigger: "blur",
          },
        ],
        tsex: [
          {
            required: true,
            message: "请输入性别",
            trigger: "blur",
          },
        ],
        tdept: [
          {
            required: true,
            message: "请输入院系",
            trigger: "blur",
          },
        ],
        tinfo: [
          {
            required: true,
            message: "请输入简介",
            trigger: "blur",
          },
        ],
      },
      // 禁用
      edit: true,
      ChangeTeacherFormDia: false,
      ChangeTeacherForm: {
        tgh: "",
        tname: "",
        tsex: "",
        tdept: "",
        tinfo: "",
      },
      // 添加的dialog
      addTeacherForm: false,
      // 添加的表单
      form: {
        tgh: "",
        tname: "",
        tsex: "",
        tdept: "",
        tinfo: "",
      },
      // 搜索左侧input
      input: "",
      // 选中的
      select: "",
      he: "",
      // 当前页
      currentPage: 1,
      // 页面大小
      page_size: 10,
      // 列表总数
      total: 50,
      // 列表数据
      tableData: [],
      // 工号
      tgh: "",
      // 教师姓名
      tname: "",
      // 获取的行信息tgh
      row: "",
    };
  },
  created() {
    this.getTeacherList();
    this.getHeight();
  },
  methods: {
    // 确定修改
    async ChangeEnter() {
      console.log(this.ChangeTeacherForm);
      const { data: res } = await this.$http.post(
        `upadteTeacher`,
        this.ChangeTeacherForm
      );
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.$message.success(res.msg);
      this.getTeacherList();
      this.ChangeTeacherFormDia = false;
    },
    // 修改取消按钮
    CancleDiaChange() {
      this.ChangeTeacherFormDia = false;
      this.getTeacherList();
    },
    // 修改老师
    changeTeacher(row) {
      this.ChangeTeacherFormDia = true;
      this.row = row.tgh;
      let ChangeTeacherFormTemp = {
        tgh: row.tgh,
        tname: row.tname,
        tsex: row.tsex,
        tdept: row.tdept,
        tinfo: row.tinfo,
      };
      this.ChangeTeacherForm = ChangeTeacherFormTemp;
    },
    // 清空
    clearSelInp() {
      (this.select = ""), (this.input = "");
    },
    async SuccessDia() {
      console.log(this.form);
      const { data: res } = await this.$http.post("addTeacher", this.form);
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.$message.success(res.msg);
      this.resetForm();
      this.getTeacherList();
      this.addTeacherForm = false;
    },
    // 重置
    resetForm() {
      this.form = {
        tgh: "",
        tname: "",
        tsex: "",
        tdept: "",
        tinfo: "",
      };
    },
    // 添加按钮打开
    addTeacher() {
      this.addTeacherForm = true;
    },
    // 删除老师
    deleteEnter(row) {
      this.row = row;
      this.$confirm("确认使该老师退休吗, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.retired();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
    },
    async retired() {
      this.row.retired = "0";
      const { data: res } = await this.$http.post(`upadteTeacher`, this.row);
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.$message.success(res.msg);
      this.getTeacherList();
    },
    test(tableData) {
      console.log(tableData);
    },
    // 获取老师列表
    async getTeacherList() {
		// _.debounce(this.test(1),1000)
      if (this.select === "tgh") {
        this.tgh = this.input;
      } else if (this.select === "tname") {
        this.tname = this.input;
      } else {
        this.tgh = "";
        this.tname = "";
      }
      let obj = {
        tgh: this.tgh,
        tname: this.tname,
      };
      const { data: res } = await this.$http.post(
        `teacherSelectAll?page=${this.currentPage}&pageSize=${this.page_size}`,
        obj
      );
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }

      res.data.teacherTyList.forEach((item, index) => {
        if (item.retired == "1") {
          res.data.teacherTyList[index].retired = "否";
        } else if (item.retired == "0") {
          res.data.teacherTyList[index].retired = "是";
        }
      });
      this.tableData = res.data.teacherTyList;
      this.total = res.data.total;
    },
    //动态修改高度
    getHeight() {
      var he = document.querySelector("#app");
      this.he = he.clientHeight - 230;
    },
    // 点击修改页面大小
    handleSizeChange(val) {
      this.page_size = val;
      this.getTeacherList();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getTeacherList();
    },
    // 关闭前
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
          this.resetForm();
        })
        .catch((_) => {});
    },
  },
};
</script>

<style>
.search {
  float: left;
}

.rigAdd {
  float: right;
}
.widthSelect {
  width: 120px;
}
</style>

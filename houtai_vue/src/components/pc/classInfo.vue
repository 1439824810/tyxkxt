<template>
<!-- 班级信息页面 -->
  <div class="kb">
    <el-card>
      <div class="addClass">
        <el-button type="success" @click="addClass">添加</el-button>
      </div>
      <!-- 上边总列表 -->
      <el-table
        :data="tableData"
        border
        style="width: 100%"
        :height="he"
        :default-sort="{ prop: 'date', order: 'descending' }"
      >
        <el-table-column prop="cid" label="课程编号" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="cname" label="课程名" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="cinfo" label="课程简介" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="cscope" label="授课范围" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="islife" label="是否启用" show-overflow-tooltip>
        </el-table-column>
        <el-table-column label="操作" width="160">
          <template slot-scope="scope">
            <el-button
              type="primary"
              size="mini"
              @click="changeClass(scope.row)"
              >修改</el-button
            >
            <el-button type="danger" size="mini" @click="deleteClass(scope.row)"
              >不启用</el-button
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
      <!-- 添加课程 -->
      <el-dialog
        :visible.sync="addClassDia"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <el-form
            :model="AddForm"
            label-width="100px"
            ref="form"
            :rules="AddClassFormRules"
          >
            <el-form-item label="课程名" prop="cname">
              <el-input v-model="AddForm.cname" placeholder="课程名"></el-input>
            </el-form-item>
            <el-form-item label="课程简介" prop="cinfo">
              <el-input
                v-model="AddForm.cinfo"
                placeholder="课程简介"
              ></el-input>
            </el-form-item>
            <el-form-item label="授课范围" prop="cscope">
              <el-input
                v-model="AddForm.cscope"
                placeholder="授课范围"
              ></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="resetForm">重置</el-button>
          <el-button type="primary" @click="EnterClass">确定</el-button>
        </span>
      </el-dialog>
      <!-- 修改课程 -->
      <el-dialog
        :visible.sync="ChangeClassDia"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <el-form
            :model="changeClassForm"
            label-width="100px"
            ref="form"
            :rules="AddClassFormRules"
          >
            <el-form-item label="课程名" prop="cname">
              <el-input
                v-model="changeClassForm.cname"
                placeholder="课程名"
              ></el-input>
            </el-form-item>
            <el-form-item label="课程简介" prop="cinfo">
              <el-input
                v-model="changeClassForm.cinfo"
                placeholder="课程简介"
              ></el-input>
            </el-form-item>
            <el-form-item label="授课范围" prop="cscope">
              <el-input
                v-model="changeClassForm.cscope"
                placeholder="授课范围"
              ></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="CanclechangeClass">取消</el-button>
          <el-button type="primary" @click="EnterchangeClass">确定</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      AddClassFormRules: {
        cname: [
          {
            required: true,
            message: "请输入课程名",
            trigger: "blur",
          },
        ],
        cinfo: [
          {
            required: true,
            message: "请输入课程简介",
            trigger: "blur",
          },
        ],
        cscope: [
          {
            required: true,
            message: "请输入授课范围",
            trigger: "blur",
          },
        ],
      },
      changeClassForm: {
        cname: "",
        cinfo: "",
        cscope: "",
      },
      // 修改课程表单控制
      ChangeClassDia: false,
      // 禁用
      edit: true,
      ChangeAdminForm: {
        username: "",
        uname: "",
        jurisdictions: "",
      },
      // 修改权限页面控制
      ChangeAdminDia: false,
      // 级联规则
      optionsAdmin: [],
      AddForm: {
        cname: "",
        cinfo: "",
        cscope: "",
      },
      // 当前页
      currentPage: 1,
      // 页面大小
      page_size: 10,
      // 列表总数
      total: 50,
      // 添加表单打开控制
      addClassDia: false,
      he: "",
      tableData: [],
      quanxian: "",
      deleteCid: "",
      // 修改的cid
      cid: "",
    };
  },
  created() {
    this.getListClass();
    this.getHeight();
  },
  methods: {
    // 清空修改密码表单
    changeClass() {
      this.changeClassForm = {
        cname: "",
        cinfo: "",
        cscope: "",
      };
    },
    // 确定修改
    async EnterchangeClass() {
      let obj = {
        cid: this.cid,
        cname: this.changeClassForm.cname,
        cscope: this.changeClassForm.cscope,
        cinfo: this.changeClassForm.cinfo,
      };
      const { data: res } = await this.$http.post("upadteClass", obj);
      if (res.status !== 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      this.ChangeClassDia = false;
      this.clearClassChange();
      this.getListClass();
    },
    // 取消修改
    CanclechangeClass() {
      this.ChangeClassDia = false;
      this.clearClassChange();
    },
    // 打开修改密码表单
    changeClass(row) {
      this.ChangeClassDia = true;
      this.cid = row.cid;
      this.changeClassForm.cname = row.cname;
      this.changeClassForm.cinfo = row.cinfo;
      this.changeClassForm.cscope = row.cscope;
    },
    // 清空表单
    clearClassChange() {
      this.ChangeClassForm = {
        username: "",
        uname: "",
        jurisdictions: "",
      };
    },

    // 删除操作
    async deleteClassSucc() {
      let obj = {
        cid: this.deleteCid,
        cname: this.changeClassForm.cname,
        cscope: this.changeClassForm.cscope,
        cinfo: this.changeClassForm.cinfo,
        islife: "0",
      };
      const { data: res } = await this.$http.post("upadteClass", obj);
      if (res.status !== 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      this.getListClass();
    },
    // 删除按钮
    deleteClass(row) {
      this.deleteCid = row.cid;
      this.changeClassForm.cname =row.cname
      this.changeClassForm.cinfo =row.cinfo
      this.changeClassForm.cscope =row.cscope
      // changeClassForm: {
      //   cname: "",
      //   cinfo: "",
      //   cscope: "",
      // },
      console.log(this.deleteCid);
      this.$confirm("此操作将永久不启用此课程, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteClassSucc();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    resetForm() {
      this.AddForm = {
        cname: "",
        cinfo: "",
        cscope: "",
      };
    },
    // 确定添加
    async EnterClass() {
      let obj = {
        cname: this.AddForm.cname,
        cinfo: this.AddForm.cinfo,
        cscope: this.AddForm.cscope,
      };
      const { data: res } = await this.$http.post("addClass", obj);
      if (res.status !== 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      this.addClassDia = false;
      this.getListClass();
      this.resetForm();
    },
    // 点击打开添加页面
    addClass() {
      this.addClassDia = true;
    },
    async getListClass() {
      const { data: res } = await this.$http.post(
        `classSelectAll?page=${this.currentPage}&pageSize=${this.page_size}`,
        {}
      );
      if (res.status != 200) return this.$message.error(res.msg);
      res.data.classTy.forEach((item, index) => {
        if (item.islife == "0") {
          res.data.classTy[index].islife = "否";
        } else if (item.islife == "1") {
          res.data.classTy[index].islife = "是";
        }
      });
      this.tableData = res.data.classTy;
      this.total = res.data.total;
      //   console.log(res);
    },
    //动态修改高度
    getHeight() {
      var he = document.querySelector("#app");
      this.he = he.clientHeight - 300;
    },
    // 点击修改页面大小
    handleSizeChange(val) {
      this.page_size = val;
      this.getListClass();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getListClass();
    },
    // 关闭前
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
          this.resetForm();
          this.clearClassChange();
        })
        .catch((_) => {});
    },
  },
};
</script>

<style>
.addClass {
  float: right;
  margin-bottom: 10px;
}
</style>

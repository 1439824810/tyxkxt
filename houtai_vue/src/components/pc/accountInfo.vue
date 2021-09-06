<template>
<!-- 此页面为账户管理页面 -->
  <div class="kb">
    <el-card>
      <div class="addAdmin">
        <el-button type="success" @click="addAdmin">添加</el-button>
      </div>
      <!-- 上边列表 -->
      <el-table
        :data="tableData"
        border
        style="width: 100%"
        :height="he"
        :default-sort="{ prop: 'date', order: 'descending' }"
      >
        <el-table-column prop="tgh" label="用户名"> </el-table-column>
        <el-table-column prop="tname" label="姓名"> </el-table-column>
        <el-table-column prop="jurisdiction" label="权限" width="100">
          <template slot-scope="scope">
            <el-tag
              :type="
                scope.row.jurisdiction === 100
                  ? 'danger'
                  : scope.row.jurisdiction === 1
                  ? 'success'
                  : scope.row.jurisdiction === 2
                  ? 'primary'
                  : 'warning'
              "
              disable-transitions
              >{{
                scope.row.jurisdiction === 100
                  ? "超级管理员"
                  : scope.row.jurisdiction === 1
                  ? "管理员"
                  : scope.row.jurisdiction === 2
                  ? "中级管理员"
                  : "高级管理员"
              }}</el-tag
            >
          </template>
        </el-table-column>
        <el-table-column label="操作" width="270">
          <template slot-scope="scope">
            <el-button
              type="primary"
              size="mini"
              @click="changePassword(scope.row)"
              >修改密码</el-button
            >
            <el-button
              type="warning"
              size="mini"
              @click="changeAdmin(scope.row)"
              >修改权限</el-button
            >
            <el-button type="danger" size="mini" @click="deleteAdmin(scope.row)"
              >删除</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
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
      <!-- 添加管理员 -->
      <el-dialog
        :visible.sync="addAdminDia"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <el-form
            :model="AddForm"
            label-width="100px"
            ref="form"
            :rules="AdminFormRules"
          >
            <el-form-item label="用户名" prop="tgh">
              <el-input
                v-model="AddForm.tgh"
                placeholder="用户名"
              ></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pwd">
              <el-input
                v-model="AddForm.pwd"
                placeholder="密码"
              ></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="tname">
              <el-input v-model="AddForm.tname" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="权限">
              <el-cascader
                v-model="AddForm.jurisdictions"
                ref="cascader"
                :options="optionsAdmin"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="请选择权限"
              ></el-cascader>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="resetForm">重置</el-button>
          <el-button type="primary" @click="EnterAdmin">确定</el-button>
        </span>
      </el-dialog>
      <!-- 修改权限 -->
      <el-dialog
        :visible.sync="ChangeAdminDia"
        width="30%"
        :before-close="handleClose"
        :rules="AdminFormRules"
      >
        <div>
          <el-form :model="ChangeAdminForm" label-width="100px" ref="form">
            <el-form-item label="用户名" prop="tgh">
              <el-input
                v-model="ChangeAdminForm.tgh"
                placeholder="用户名"
                :disabled="edit"
              ></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="tname">
              <el-input
                v-model="ChangeAdminForm.tname"
                placeholder="姓名"
                :disabled="edit"
              ></el-input>
            </el-form-item>
            <el-form-item label="权限">
              <el-cascader
                v-model="ChangeAdminForm.jurisdictions"
                ref="cascader"
                :options="optionsAdmin"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="请选择权限"
              ></el-cascader>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="CancleChangeAdmin">取消</el-button>
          <el-button type="primary" @click="EnterChangeAdmin">确定</el-button>
        </span>
      </el-dialog>
      <!-- 修改密码 -->
      <el-dialog
        :visible.sync="ChangePasswordDia"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <el-form
            :model="ChangePasswordForm"
            label-width="100px"
            ref="form"
            :rules="AdminFormRules"
          >
            <el-form-item label="用户名" prop="username">
              <el-input
                v-model="ChangePasswordForm.tgh"
                placeholder="用户名"
                :disabled="edit"
              ></el-input>
            </el-form-item>
            <el-form-item label="姓名" prop="uname">
              <el-input
                v-model="ChangePasswordForm.tname"
                placeholder="姓名"
                :disabled="edit"
              ></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="password">
              <el-input
                v-model="ChangePasswordForm.pwd"
                placeholder="密码"
              ></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="CancleChangePassword">取消</el-button>
          <el-button type="primary" @click="EnterChangePassword"
            >确定</el-button
          >
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // 当前页
      currentPage: 1,
      // 页面大小
      page_size: 10,
	  total:10,
      AdminFormRules: {
        tgh: [
          {
            required: true,
            message: "请输入用户名",
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
        tname: [
          {
            required: true,
            message: "请输入姓名",
            trigger: "blur",
          },
        ],
      },
      ChangePasswordForm: {
        tgh: "",
        tname: "",
        pwd: "",
        jurisdiction:""
      },
      // 修改密码表单控制
      ChangePasswordDia: false,
      // 禁用
      edit: true,
      ChangeAdminForm: {
        tgh: "",
        tname: "",
        pwd: "",
        jurisdictions:""
      },
      // 修改权限页面控制
      ChangeAdminDia: false,
      // 级联规则
      optionsAdmin: [],
      AddForm: {
        tgh: "",
        pwd: "",
        jurisdictions: "",
        tname: "",
      },
      // 添加表单打开控制
      addAdminDia: false,
      he: "",
      tableData: [],
      quanxian: "",
      usernameDeleteAdmin: "",
    };
    
  },
  created() {
    this.getListAdmin();
    this.getAdmin()
    this.getHeight();
    
  },
  methods: {
    // 清空修改密码表单
    clearPasswordChange() {
      this.ChangePasswordForm = {
        tgh: "",
        tname: "",
        pwd: "",
      };
    },
    // 确定修改
    async EnterChangePassword() {
      let obj = {
        currentTgh:JSON.parse(window.sessionStorage.getItem("userInfo")).tgh,
        tgh: this.ChangePasswordForm.tgh,
        tname: this.ChangePasswordForm.tname,
        pwd: this.ChangePasswordForm.pwd,
        jurisdiction:this.ChangePasswordForm.jurisdiction
      };
      const { data: res } = await this.$http.post("upadtUsers", obj);
      if (res.status !== 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      this.ChangePasswordDia = false;
      this.clearPasswordChange();
      this.getListAdmin();
    },
    // 取消修改
    CancleChangePassword() {
      this.ChangePasswordDia = false;
      this.clearPasswordChange();
    },
    // 打开修改密码表单
    changePassword(row) {
      this.ChangePasswordDia = true;
      this.ChangePasswordForm.tgh = row.tgh;
      this.ChangePasswordForm.tname = row.tname;
      this.ChangePasswordForm.jurisdiction = row.jurisdiction
    },
    // 清空表单
    clearAdminChange() {
      this.ChangeAdminForm = {
        tgh: "",
        tname: "",
        pwd: "",
        jurisdiction:""
      };
    },
    // 确定修改权限
    async EnterChangeAdmin() {
      this.ChangeAdminDia = false;
      let obj = {
        currentTgh:JSON.parse(window.sessionStorage.getItem("userInfo")).tgh,
        tgh: this.ChangeAdminForm.tgh,
        tname:this.ChangeAdminForm.tname,
        pwd:this.ChangeAdminForm.pwd,
        jurisdiction: this.ChangeAdminForm.jurisdictions[0],
      };
      if(obj.jurisdiction!=100&&JSON.parse(window.sessionStorage.getItem("userInfo")).jurisdiction==100&&JSON.parse(window.sessionStorage.getItem("userInfo")).tgh==obj.tgh){
        this.$message.warning("您是最高权限");
      }else{
        const { data: res } = await this.$http.post(
        "upadtUsers",
        obj
      );
      if (res.status !== 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      }
      
      this.clearAdminChange();
      this.getListAdmin();
    },
    // 取消修改权限
    CancleChangeAdmin() {
      this.ChangeAdminDia = false;
      this.clearAdminChange();
    },
    changeAdmin(row) {
      console.log(row);
      this.ChangeAdminDia = true;
      this.ChangeAdminForm.tgh = row.tgh;
      this.ChangeAdminForm.tname = row.tname;
      this.ChangeAdminForm.jurisdiction =row.jurisdiction;
      this.ChangeAdminForm.pwd =row.pwd;
    },
    // 删除操作
    async deleteAdminSucc() {
      const { data: res } = await this.$http.post(
        "usersDeleteByTgh",{tgh:this.usernameDeleteAdmin}
      );
      if (res.status !== 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      this.getListAdmin();
    },
    // 删除按钮
    deleteAdmin(row) {
      this.usernameDeleteAdmin = row.tgh;
      this.$confirm("此操作将永久删除此人, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteAdminSucc();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    // 判断权限，选择级联
    setAdminCascader() {
		// 1管理员2中级3高级100超级
      if (this.quanxian === 100) {
        this.optionsAdmin = [
          {
            value: "1",
            label: "管理员",
          },
          {
            value: "2",
            label: "中级管理员",
          },
          {
            value: "3",
            label: "高级管理员",
          },
        ];
      } else if (this.quanxian === 3) {
        this.optionsAdmin = [
          {
            value: "1",
            label: "管理员",
          },
          {
            value: "2",
            label: "中级管理员",
          },
        ];
      } else if (this.quanxian === 2) {
        this.optionsAdmin = [
          {
            value: "1",
            label: "管理员",
          },
        ];
      }
    },
    resetForm() {
      this.AddForm = {
        tgh: "",
        pwd: "",
        jurisdictions: "",
        uname: "",
      };
    },
    // 确定添加权限
    async EnterAdmin() {
      let obj = {
        tgh: this.AddForm.tgh,
        pwd: this.AddForm.pwd,
        jurisdiction: this.AddForm.jurisdictions[0],
        tname: this.AddForm.tname,
      };
      const { data: res } = await this.$http.post("addUsers", obj);
      if (res.status !== 200) return this.$message.error(res.msg);

      this.$message.success(res.msg);
      this.addAdminDia = false;
      this.getListAdmin();
      this.resetForm();
    },
    // 点击打开添加页面
    addAdmin() {
      console.log("this.optionsAdmin"+JSON.stringify(this.optionsAdmin));
      this.addAdminDia = true;
    },
    async getListAdmin() {
      const tgh=JSON.parse(window.sessionStorage.getItem("userInfo")).tgh
      const { data: res } = await this.$http.post(`usersSelectAll?page=${this.currentPage}&pageSize=${this.page_size}`,{"tgh":tgh});
      console.log(res);
      if (res.status === 800) return this.$message.error(res.msg);
      this.tableData = res.data.usersTyList;
	    this.total =res.data.total

	//   this.quanxian = 
    },
    //动态修改高度
    getHeight() {
      var he = document.querySelector("#app");
      this.he = he.clientHeight - 250;
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
          this.clearAdminChange();
        })
        .catch((_) => {});
    },
    getAdmin() {
      this.quanxian = JSON.parse(window.sessionStorage.getItem("userInfo")).jurisdiction
      this.setAdminCascader();
	  
    },
  },
};
</script>

<style>
.addAdmin {
  float: right;
  margin-bottom: 10px;
}
</style>

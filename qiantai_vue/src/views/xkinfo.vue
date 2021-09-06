<template>
<!-- 获取选课信息 -->
  <div class="kb">
    <el-card>
        <div class="fenye">
        <el-button @click="ToHome" type="primary" size="small" round
          >返回首页</el-button
        >
      </div>
      <!-- 上边总列表 -->
      <el-table
        :data="tableData"
        border
        style="width: 100%"
        height="600px"
        :default-sort="{ prop: 'date', order: 'descending' }"
      >
        <el-table-column prop="tname" label="教师姓名" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="cname" label="课程名" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="sksq" label="星期" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="sksd" label="时段" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="sqrade" label="开课年级" show-overflow-tooltip>
        </el-table-column>
        <el-table-column label="操作" width="160">
          <template slot-scope="scope">
            <el-button
              type="primary"
              size="mini"
              @click="NoXk(scope.row)"
              v-if="scope.row.isend==1"
              >取消选课</el-button
            >
            <el-button
              type="danger"
              size="mini"
              v-if="scope.row.isend==0"
              >已结课</el-button
            >
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
      
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
      // 列表总数
      total: 50,
      // 添加表单打开控制
      addClassDia: false,
      he: "",
      tableData: [],
    };
  },
  created() {
    this.getListClass();
  },
  methods: {
    async NoXk(row){
      
      var obj = {
          tcid:row.tcid,
          sno:location.href.split("?")[1].split("=")[1].split("#")[0]
      }
       const { data: res } = await this.$http.post(
        `deleteXk`,
        obj
      );
      this.$message.success(res.msg)
      this.getListClass()
    },
    ToHome() {
      this.$router.push("/");
    },
    async getListClass() {
      const { data: res } = await this.$http.post(
        `getXkInfo`,
        {sno:location.href.split("?")[1].split("=")[1].split("#")[0]}
      );
      if (res.status != 200) return this.$message.error(res.msg);
      this.tableData = res.data;
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
  },
};
</script>

<style scoped>
.fenye {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}
.fenye .el-button{
    width: 100%;
}

</style>
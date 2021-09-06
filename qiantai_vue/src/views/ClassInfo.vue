<template>
<!-- 课程信息页面 -->
  <div class="kb">
    <el-card>
      <!-- 上边总列表 -->
      <el-table
        :data="tableData"
        border
        style="width: 100%"
        height="600px"
        :default-sort="{ prop: 'date', order: 'descending' }"
      >
        <el-table-column prop="cid" label="课程编号" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="cname" label="课程名" show-overflow-tooltip>
        </el-table-column>
        <el-table-column prop="cinfo" label="课程简介" show-overflow-tooltip>
        </el-table-column>
        <!-- <el-table-column prop="cscope" label="授课范围" show-overflow-tooltip>
        </el-table-column> -->
        <el-table-column prop="islife" label="是否启用" show-overflow-tooltip>
        </el-table-column>
        <el-table-column label="操作" width="160">
          <template slot-scope="scope">
            <el-button
              type="primary"
              size="mini"
              @click="ToXk(scope.row)"
              >去选课</el-button
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
          layout=" prev, pager, next"
          :total="total"
        >
        </el-pagination>
        <el-button @click="ToHome" type="primary" size="small" round
          >返回首页</el-button
        >
      </div>
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
    ToXk(){
      this.$router.push("/xk");
    },
    ToHome() {
      this.$router.push("/");
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
  margin-top: 10px;
}

</style>
<template>
<!-- 教师信息 -->
  <div class="Fbox">
    <el-card>
      <!-- 上边列表 -->
      <el-table
        :data="tableData"
        border
        style="width: 100%"
        height="600px"
        :default-sort="{ prop: 'date', order: 'descending' }"
      >
        <el-table-column prop="tgh" label="工号" sortable> </el-table-column>
        <el-table-column prop="tname" label="姓名"> </el-table-column>
        <el-table-column prop="tsex" label="性别"> </el-table-column>
        <el-table-column prop="tdept" label="院系"> </el-table-column>
        <el-table-column prop="tinfo" label="简介" show-overflow-tooltip> </el-table-column>
        <el-table-column prop="retired" label="是否退休"> </el-table-column>
        <!-- <el-table-column label="操作" width="150">
          <template slot-scope="scope">
            <el-button type="primary" size="mini" @click="showAllMsg(scope.row)"
              >详细信息</el-button
            >
          </template>
        </el-table-column> -->
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
      // 列表数据
      tableData: [],
    };
  },
  created() {
    this.getTeacherList();
  },
  methods: {
    ToHome() {
        this.$router.push("/");
    },
    // 获取老师列表
    async getTeacherList() {
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
    handleSizeChange(val) {
      this.page_size = val;
      this.getTeacherList();
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getTeacherList();
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

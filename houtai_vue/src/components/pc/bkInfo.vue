<template>
<!-- 班课信息页面  能看班课，能选课，能添加学生，能上成绩 -->
  <div class="box">
    <el-card>
      <el-row>
        <el-col :span="5">
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

        <el-col :span="5">
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
        <el-col :span="5">
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
        <el-col :span="3">
          <el-button type="primary" icon="el-icon-search" @click="select"
            >查询</el-button
          >
        </el-col>
        <el-col :span="3">
          <el-button type="info" @click="clearAllSel">清除选项</el-button>
        </el-col>
        <el-col :span="3">
          <el-button type="success" @click="addClass">添加</el-button>
        </el-col>
      </el-row>
      <div>
        <el-table
          :data="TeacherClassInfoList"
          ref="refTable"
          style="width: 100%"
          :height="he"
        >
          <el-table-column label="课程名" prop="cname"> </el-table-column>
          <el-table-column label="最大选课人数" prop="rsxz"> </el-table-column>
          <el-table-column label="星期" prop="sksq"> </el-table-column>
          <el-table-column label="时段" prop="sksd"> </el-table-column>
          <el-table-column label="开课年级" prop="sqrade"> </el-table-column>
          <el-table-column label="是否结课" prop="isend"> </el-table-column>
          <el-table-column label="限定性别" prop="ssex"> </el-table-column>
          <el-table-column label="教师名称" prop="tname"> </el-table-column>
          <el-table-column label="校区" prop="xq"> </el-table-column>
          <el-table-column label="选课人数" prop="xkrs"> </el-table-column>
          <el-table-column label="操作" width="450">
            <template slot-scope="scope">
              <el-button type="primary" size="mini" @click="showStu(scope.row)"
                >显示学生</el-button
              >
              <el-button type="primary" size="mini" @click="showStuGrade(scope.row)"
                >学生成绩</el-button
              >
              <el-button
                type="primary"
                size="mini"
                @click="addStudent(scope.row)"
                >添加学生</el-button
              >
              <el-button type="warning" size="mini" @click="jieKe(scope.row)"
                >结课</el-button
              >
              <el-button
                type="danger"
                size="mini"
                @click="deleteClass(scope.row)"
                >删除课程</el-button
              >
            </template>
          </el-table-column>
        </el-table>
        <!-- 显示学生 -->

        <el-dialog
          :visible.sync="showStuStudentDialogVisible"
          width="70%"
          :before-close="handleClose"
        >
          <el-table
            :data="insideTableData"
            border
            style="width: 100%"
            height="400px"
            :default-sort="{ prop: 'date', order: 'descending' }"
          >
            <el-table-column prop="sno" label="学号"> </el-table-column>
            <el-table-column prop="sname" label="姓名"> </el-table-column>
            <el-table-column prop="ssex" label="性别"> </el-table-column>
            <el-table-column prop="sxy" label="教学院"> </el-table-column>
            <el-table-column prop="sclass" label="班级"> </el-table-column>
            <el-table-column prop="sqrade" label="年级"> </el-table-column>
            <el-table-column label="操作" width="220">
              <template slot-scope="scope">
                <el-button
                  type="danger"
                  size="mini"
                  @click="deleteStudent(scope.row)"
                  >删除学生</el-button
                >
                <el-button
                  type="primary"
                  size="mini"
                  @click="SetStuGrade(scope.row)"
                  >填写成绩</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </el-dialog>
        <!-- 显示学生 -->
        <!-- 显示学生成绩 -->
        <el-dialog
          :visible.sync="showStuGradeDialogVisible"
          width="70%"
          :before-close="handleClose"
        >
          <el-table
            :data="showStuGradeTable"
            border
            style="width: 100%"
            height="400px"
            :default-sort="{ prop: 'date', order: 'descending' }"
          >
            <el-table-column prop="sno" label="学号"> </el-table-column>
            <el-table-column prop="sname" label="姓名"> </el-table-column>
            <el-table-column prop="ssex" label="性别"> </el-table-column>
            <el-table-column prop="zx1" label="专项1"> </el-table-column>
            <el-table-column prop="zx2" label="专项2"> </el-table-column>
            <el-table-column prop="tjq" label="太极拳"> </el-table-column>
            <el-table-column prop="xyp" label="校园跑"> </el-table-column>
            <el-table-column prop="pscj" label="平时成绩"> </el-table-column>
            <el-table-column prop="zcj" label="总成绩"> </el-table-column>
            <el-table-column label="操作" width="130">
              <template slot-scope="scope">
                <el-button
                  type="danger"
                  size="mini"
                  @click="updateStudentGrade(scope.row)"
                  >修改成绩</el-button
                >
              </template>
            </el-table-column>
          </el-table>
        </el-dialog>
        <!-- 显示学生成绩 -->
        <!-- 添加学生成绩 -->
        <el-dialog
          title="成绩"
          :visible.sync="setStudialogVisible"
          width="40%"
          :before-close="handleClose"
        >
          <span>
            <el-form
              label-position="right"
              label-width="80px"
              :model="setStuGrade"
              :rules="setStuGraderules"
            >
              <el-form-item label="姓名">
                <el-input
                  v-model="setStuGrade.sname"
                  :disabled="edit"
                ></el-input>
              </el-form-item>
              <el-form-item label="学号">
                <el-input v-model="setStuGrade.sno" :disabled="edit"></el-input>
              </el-form-item>
              <el-form-item label="专项1" prop="zx1">
                <el-input v-model.number="setStuGrade.zx1"></el-input>
              </el-form-item>
              <el-form-item label="专项2" prop="zx2">
                <el-input v-model.number="setStuGrade.zx2"></el-input>
              </el-form-item>
              <el-form-item label="太极拳" prop="tjq">
                <el-input v-model.number="setStuGrade.tjq"></el-input>
              </el-form-item>
              <el-form-item label="校园跑" prop="xyp">
                <el-input v-model.number="setStuGrade.xyp"></el-input>
              </el-form-item>
              <el-form-item label="平时成绩" prop="pscj">
                <el-input v-model.number="setStuGrade.pscj"></el-input>
              </el-form-item>
            </el-form>
          </span>
          <span slot="footer" class="dialog-footer">
            <el-button @click="setStudialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="enterUpload">确 定</el-button>
          </span>
        </el-dialog>
        <!-- 添加学生成绩 -->

        <!-- 修改学生成绩 -->
        <el-dialog
          title="成绩"
          :visible.sync="updateStudentGradeDialogVisible"
          width="40%"
          :before-close="handleClose"
        >
          <span>
            <el-form
              label-position="right"
              label-width="80px"
              :model="UpdateStuGrade"
              :rules="updateStuGraderules"
            >
              <el-form-item label="姓名">
                <el-input
                  v-model="UpdateStuGrade.sname"
                  :disabled="edit"
                ></el-input>
              </el-form-item>
              <el-form-item label="学号">
                <el-input v-model="UpdateStuGrade.sno" :disabled="edit"></el-input>
              </el-form-item>
              <el-form-item label="专项1" prop="zx1">
                <el-input v-model.number="UpdateStuGrade.zx1"></el-input>
              </el-form-item>
              <el-form-item label="专项2" prop="zx2">
                <el-input v-model.number="UpdateStuGrade.zx2"></el-input>
              </el-form-item>
              <el-form-item label="太极拳" prop="tjq">
                <el-input v-model.number="UpdateStuGrade.tjq"></el-input>
              </el-form-item>
              <el-form-item label="校园跑" prop="xyp">
                <el-input v-model.number="UpdateStuGrade.xyp"></el-input>
              </el-form-item>
              <el-form-item label="平时成绩" prop="pscj">
                <el-input v-model.number="UpdateStuGrade.pscj"></el-input>
              </el-form-item>
            </el-form>
          </span>
          <span slot="footer" class="dialog-footer">
            <el-button @click="updateStudentGradeDialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="enterUpdate">确 定</el-button>
          </span>
        </el-dialog>
        <!-- 修改学生成绩 -->
        <!-- 添加学生的dialog -->
        <el-dialog
          title="提示"
          :visible.sync="addStudentDialogVisible"
          width="50%"
          :before-close="handleClose"
        >
          <!-- 穿梭框搜索 -->

          <span class="searchBox">
            <div class="search">
              <el-input
                placeholder="请输入内容"
                v-model="input"
                class="input-with-select"
              >
                <el-select
                class="widthSelect"
                  v-model="selectStu"
                  slot="prepend"
                  placeholder="请选择"
                >
                  <el-option label="学号" value="sno"></el-option>
                  <el-option label="姓名" value="sname"></el-option>
                  <el-option label="教学院" value="sxy"></el-option>
                  <el-option label="年级" value="sqrade"></el-option>
                </el-select>
                <el-button
                  slot="append"
                  icon="el-icon-search"
                  @click="transferSelStu"
                  >查询</el-button
                >
              </el-input>
              <el-button @click="clearSelInp">清空</el-button>
            </div>
            <!-- 穿梭框 -->
            <el-transfer v-model="value" :data="transLeftData"> </el-transfer>
          </span>
          <!-- 分页 -->
          <div class="fenye">
            <el-pagination
              @size-change="handleSizeChangeTRANSFER"
              @current-change="handleCurrentChangeTRANSFER"
              :current-page="currentPageTRANSFER"
              :page-sizes="[10, 15, 30]"
              :page-size="page_sizeTRANSFER"
              layout="total, sizes, prev, pager, next, jumper"
              :total="totalTRANSFER"
            >
            </el-pagination>
          </div>
          <span slot="footer" class="dialog-footer">
            <el-button @click="addStuCancle">取 消</el-button>
            <el-button type="primary" @click="addStuEnter">确 定</el-button>
          </span>
        </el-dialog>
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
      </div>
      <el-dialog
        :visible.sync="addDialogVisible"
        width="30%"
        :before-close="handleClose"
      >
        <div>
          <!-- 添加的下拉框 -->
          <el-form
            :model="form"
            label-width="120px"
            ref="form"
            :rules="NumRules"
          >
            <el-form-item label="上课时间">
              <el-cascader
                v-model="form.addTimeData"
                :options="options"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="上课时间"
              ></el-cascader>
            </el-form-item>
            <el-form-item label="开课年级">
              <el-cascader
                v-model="form.addSqrade"
                :options="optionsSqradeAddClass"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="开课年级"
              ></el-cascader>
            </el-form-item>
            <el-form-item label="课程专项">
              <el-cascader
                v-model="form.addZhuanxiangData"
                :options="optionsClass"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="专项"
              ></el-cascader>
            </el-form-item>
            <el-form-item label="授课教师">
              <el-cascader
                v-model="form.addTeacher"
                :options="optionsTeacher"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="教师"
              ></el-cascader>
            </el-form-item>
            <el-form-item label="性别要求">
              <el-cascader
                v-model="form.addSexData"
                :options="optionsSex"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="性别要求"
              ></el-cascader>
            </el-form-item>
            <el-form-item label="校区选择">
              <el-cascader
                v-model="form.addSqData"
                :options="optionsSq"
                :props="{ checkStrictly: true }"
                clearable
                placeholder="校区选择"
              ></el-cascader>
            </el-form-item>
            <el-form-item label="限制人数" prop="num">
              <el-input v-model.number="form.num" placeholder="限制人数"></el-input>
            </el-form-item>
          </el-form>
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button @click="resetForm">重置</el-button>
          <el-button type="primary" @click="SuccessDia">保存</el-button>
        </span>
      </el-dialog>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    var checkNum = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value < 0) {
              callback(new Error('请输入正数'));
            } else if(value>100){
              callback(new Error('请输入小于100的正数'));
            }
          }
        }, 10);
      };
    return {
      updateStuGraderules:{
        zx1: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        zx2: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        tjq: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        xyp: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        pscj: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
      },
      setStuGraderules: {
        zx1: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        zx2: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        tjq: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        xyp: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
        pscj: [
          { required: true, message: "不能为空" },
          { type: "number", message: "必须为数字值" },
           { validator: checkNum, trigger: 'blur' }
        ],
      },
      clickCount: false,
      NumRules: {
        num: [
          {
            required: true,
            message: "人数不能为空",
            trigger: "blur",
          },
          {
            type: "number",
            message: "人数必须为数字值",
          },
        ],
      },
      edit: true,
      // 穿梭框左边的值
      transLeftData: [],
      // 穿梭框右边的值
      value: [],
      addStudentDialogVisible: false,
      form: {
        addSqrade:"",
        addTimeData: "",
        addZhuanxiangData: "",
        addTeacher: "",
        addSexData: "",
        addSqData: "",
        num: "",
      },
      total: 20,
      he: "",
      setStudialogVisible: false,
      TeacherClassInfoList: [],
      searchSqrade: [],
      insideTableData: [],
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
      optionsSex: [
        {
          value: 0,
          label: "无",
        },
        {
          value: 1,
          label: "女",
        },
        {
          value: 2,
          label: "男",
        },
      ],
      optionsClass: [],
      optionsSqradeAddClass:[],
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
      showStuGradeDialogVisible:false,
      showStuGradeTable:[],
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
        resid:''
      },
      updateStudentGradeDialogVisible:false,
      rowDelete: "",
      currentPageTRANSFER: 1,
      page_sizeTRANSFER: 10,
      totalTRANSFER: 10,
      // 搜索左侧input
      input: "",
      sname: "",
      sno: "",
      sxy: "",
      sqrade: "",
      // 选中的
      selectStu: "",
      rowTy: "",
    };
  },
  created() {
    this.getHeight();
    this.getMenuList();
    this.getTeacherName();
    this.getSqradeList();
    this.getTeacherClassInfoList();
  },
  methods: {
    async enterUpload(){
        if(this.setStuGrade.tjq<6){
            this.setStuGrade.zcj=59
        }else if(this.setStuGrade.tjq>=6){
            this.setStuGrade.zcj = this.setStuGrade.zx1+this.setStuGrade.zx2+this.setStuGrade.tjq+this.setStuGrade.xyp+this.setStuGrade.pscj
        }
        // console.log(this.stuGrade);
        const { data: res } = await this.$http.post("addResults", this.setStuGrade);
        if(res.status = 200){
            this.$message.success(res.msg)
        }else{
            this.$message.error(res.msg)
        }
        this.setStuGrade= {
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
        this.setStudialogVisible = false
    },
    async enterUpdate(){
      
        if(this.UpdateStuGrade.tjq<6){
            this.UpdateStuGrade.zcj=59
        }else if(this.UpdateStuGrade.tjq>=6){
            this.UpdateStuGrade.zcj = this.UpdateStuGrade.zx1+this.UpdateStuGrade.zx2+this.UpdateStuGrade.tjq+this.UpdateStuGrade.xyp+this.UpdateStuGrade.pscj
        }
        // alert(JSON.stringify(this.UpdateStuGrade))
        const { data: res } = await this.$http.post("updateResults", this.UpdateStuGrade);
        if(res.status = 200){
            this.$message.success(res.msg)
        }else{
            this.$message.error(res.msg)
        }
        this.showStuGradeAjax()
        this.updateStudentGradeDialogVisible = false
    },
    // 结课点击确定后
    async JieKeEnter(row) {
      console.log("row" + JSON.stringify(row));
      const { data: res } = await this.$http.post("updateTeacherClass", {
        tcid: row.tcid,
        isend: 0,
      });
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.$message.success(res.msg);
      console.log(res);
      this.getTeacherClassInfoList();
    },
    // 打开结课
    openJieKe(row) {
      this.$confirm("确定要结课吗", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true,
      })
        .then(() => {
          this.JieKeEnter(row);
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
    },
    // 结课的
    jieKe(row) {
      this.rowDelete = row.tcid;
      console.log(row.isend);
      if (row.isend == "是") {
        this.$message.warning("已经结课，请勿点击");
        return;
      } else {
        this.openJieKe(row);
      }
    },
    openDelete() {
      this.$confirm("确定要删除吗", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true,
      })
        .then(() => {
          this.DeleteEnter();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消",
          });
        });
    },
    // 删除点击确定后
    async DeleteEnter() {
      const { data: res } = await this.$http.post("deleteTeacherClass", {
        tcid: this.rowDelete,
      });
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.$message.success(res.msg);
      this.getTeacherClassInfoList();
    },
    // 删除课程
    deleteClass(row) {
      this.rowDelete = row.tcid;
      this.openDelete();
    },
    // 关闭前dialog 添加学生
    handleClearDialogAddStudent() {
      this.transLeftData = [];
      this.value = [];
    },
    // 打开删除提示
    open() {
      this.$confirm("此操作将永久删除此学生, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
        center: true,
      })
        .then(() => {
          this.delStuEnter();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
    // 按删除传参确定
    deleteStudent(row) {
      this.delStu.sno = row.sno;
      this.delStu.tcid = this.tcid;
      this.open();
    },
    // 设置学生成绩SetStuGrade
    SetStuGrade(row) {
      
      this.setStuGrade.sno = row.sno;
      this.setStuGrade.sname =row.sname;
      this.setStuGrade.tcid = this.tcid;
      this.setStudialogVisible = true;
    },
    updateStudentGrade(row) {
      
      this.UpdateStuGrade.sno = row.sno;
      this.UpdateStuGrade.sname =row.sname;
      this.UpdateStuGrade.tcid = row.tcid;
      this.UpdateStuGrade.resid  =row.resid
      this.UpdateStuGrade.zx1  =row.zx1
      this.UpdateStuGrade.zx2  =row.zx2
      this.UpdateStuGrade.tjq  =row.tjq
      this.UpdateStuGrade.xyp  =row.xyp
      this.UpdateStuGrade.pscj  =row.pscj
      this.UpdateStuGrade.zcj  =row.zcj
      this.updateStudentGradeDialogVisible = true;
    },
    // 删除学生函数enter
    async delStuEnter() {
      const { data: res } = await this.$http.post("deleteXk", this.delStu);
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.selectXKSTU();
      this.$message.success(res.msg);
    },
    // 确定添加学生
    async addStuEnter() {
      this.addStudentDialogVisible = false;
      const arrAddStu = [];
      for (var i = 0; i < this.value.length; i++) {
        arrAddStu[i] = {
          tcid: this.tcid,
          sno: this.value[i],
        };
      }
      const {
        data: res,
        // 添加学生请求
      } = await this.$http.post("addXk", arrAddStu);
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.$message.success(res.msg);
      this.selectXKSTU();
    },
    // 取消添加学生
    addStuCancle() {
      this.addStudentDialogVisible = false;
    },
    // 点击添加学生按钮
    async addStudent(row) {
      this.tcid = row.tcid;
      this.handleClearDialogAddStudent();
      this.addStudentDialogVisible = true;
      this.transferSelStu();
    },
    async transferSelStu() {
      this.transLeftData = [];
      if (this.selectStu === "sname") {
        this.sname = this.input;
      } else if (this.selectStu === "sno") {
        this.sno = this.input;
      } else if (this.selectStu === "sqrade") {
        this.sqrade = this.input;
      } else if (this.selectStu === "sxy") {
        this.sxy = this.input;
      } else {
        this.sname = "";
        this.sno = "";
        this.sxy = "";
        this.sqrade = "";
      }
      let obj = {
        sname: this.sname,
        sno: this.sno,
        sxy: this.sxy,
        sqrade: this.sqrade,
      };
      const { data: res } = await this.$http.post(
        `stuSelectAll?page=${this.currentPageTRANSFER}&pageSize=${this.page_sizeTRANSFER}`,
        obj
      );
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }

      const arr = [];
      res.data.stuTyList.forEach((item, index) => {
        res.data.stuTyList[index] = {
          label: item.sno + " " + item.ssex + " " + item.sname,
          key: item.sno,
          pinyin: item.sno,
        };
      });
      this.transLeftData = res.data.stuTyList;
      console.log(
        "res.data.stuTyList" +
          JSON.stringify(res.data.stuTyList) +
          "" +
          this.value
      );
      this.totalTRANSFER = res.data.total;
    },
    // 清空
    clearSelInp() {
      (this.selectStu = ""), (this.input = "");
    },
    // 获取老师姓名
    async getTeacherName() {
      const { data: res } = await this.$http.post("teacherSelectAll", {"retired":0});
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
    // 点击修改页面大小handleSizeChangeTRANSFER
    handleSizeChangeTRANSFER(val) {
      this.page_sizeTRANSFER = val;
      this.transferSelStu();
    },
    // 分页改变
    handleCurrentChangeTRANSFER(val) {
      this.currentPageTRANSFER = val;
      this.transferSelStu();
    },
    // 高度
    getHeight() {
      var he = document.querySelector("#app");
      this.he = he.clientHeight - 230;
    },
    // 获取老师课程列表
    async getTeacherClassInfoList() {
      const { data: res } = await this.$http.post(
        `selectAllTeacherClass?page=${this.currentPage}&pageSize=${this.page_size}`,
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
    // 取消dialog
    CancleDia() {
      this.addDialogVisible = false;
    },
    // 确定dialog
    async SuccessDia() {
      let obj = {
        sqrade:this.form.addSqrade[0],
        cname: this.form.addZhuanxiangData[0],
        tgh: this.form.addTeacher[0],
        sksq: this.form.addTimeData[0],
        sksd: this.form.addTimeData[1],
        xq: this.form.addSqData[0],
        rsxz: this.form.num,
        ssex: this.form.addSexData[0],
        isend:1,
        xkrs:0
      };
      const { data: res } = await this.$http.post("addTeacherClass", obj);
      console.log(res);
      if (res.status != 200) return this.$message.error(res.msg);
      this.$message.success(res.msg);
      this.addDialogVisible = false;
      this.getTeacherClassInfoList();
      this.getSqradeList()
      this.resetForm();
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
    // 清空
    clearAllSel() {
      this.$refs.cascader.$refs.panel.clearCheckedNodes();
      this.$refs.cascader1.$refs.panel.clearCheckedNodes();
      this.$refs.cascader2.$refs.panel.clearCheckedNodes();
    },
    addClass() {
      const date =new Date().getFullYear()
      this.optionsSqradeAddClass= [
        {
          value: date+"-1",
          label: date+"-1",
        },{
          value: date+"-2",
          label: date+"-2",
        },
        {
          value: date-1+"-1",
          label: date-1+"-1",
        },
        {
          value: date-1+"-2",
          label: date-1+"-2",
        },,
        {
          value: date-2+"-1",
          label: date-2+"-1",
        },
        {
          value: date-2+"-2",
          label: date-2+"-2",
        },
      
      ],
      this.getSqradeList()
      this.addDialogVisible = true;
    },
    // 关闭前
    handleClose(done) {
      this.$confirm("确认关闭？")
        .then((_) => {
          done();
          this.resetForm();
          this.clearSelInp();
        })
        .catch((_) => {});
    },
    resetForm() {
      this.form = {
        cname: '',
        tgh: '',
        sksq: '',
        sksd: '',
        xq: '',
        rsxz: '',
        ssex: '',
      };
    },
    showStu(row) {
      this.showStuStudentDialogVisible = true;
      this.tcid = row.tcid;
      this.selectXKSTU();
    },
    showStuGrade(row) {
      this.showStuGradeDialogVisible = true;
      this.tcid = row.tcid;
      this.showStuGradeAjax();
    },
    async selectXKSTU() {
      const { data: res } = await this.$http.post("stuSelectByTcid", {
        tcid: this.tcid,
      });
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.insideTableData = res.data.stuTyList;
    },
    async showStuGradeAjax() {
      const { data: res } = await this.$http.post("selectAllResults", {
        tcid: this.tcid,
      });
      if (res.status !== 200) {
        return this.$message.error(res.msg);
      }
      this.showStuGradeTable = res.data.resultsTyLj;
      // console.log("this.showStuGradeTable"+JSON.stringify(this.showStuGradeTable));
    },
  },
};
</script>
<style scope>
.el-transfer-panel__header
  > .el-checkbox
  > .el-checkbox__input
  > .el-checkbox__inner {
  display: none !important;
}

.box {
  width: 100%;
  height: 100%;
}

.el-card {
  width: 100%;
}

.el-table__expand-icon {
  display: none !important;
}

.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
.el-transfer-panel {
  width: 250px !important;
}
.el-transfer-panel__item .el-checkbox__input {
  left: 22px !important;
}
.el-transfer-panel__item.el-checkbox .el-checkbox__label {
  text-align: left;
}
.searchBox > .search {
  width: 100%;
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
  padding: 10px;
}
.widthSelect{width: 120px;}
</style>

<template>
<!-- 学生信息 -->
	<div class="Fbox">
		<el-card>
			<div class="search">

				<el-input placeholder="请输入内容" v-model="input" class="input-with-select">
					<el-select class="widthSelect" v-model="select" slot="prepend" placeholder="请选择">
						<el-option label="学号" value="sno"></el-option>
						<el-option label="姓名" value="sname"></el-option>
						<el-option label="教学院" value="sxy"></el-option>
						<el-option label="年级" value="sqrade"></el-option>
					</el-select>
					<el-button slot="append" icon="el-icon-search" @click="getStuList">查询</el-button>

				</el-input>
			</div>
			<div class="search">
				<el-button @click="clearSelInp">清空</el-button>
			</div>
			<div class="rigAdd">
				<el-button type="success" @click="addTeacher">添加</el-button>
			</div>
			<!-- 上边列表 -->
			<el-table :data="tableData" border style="width: 100%" :height="he" :default-sort="{prop: 'date', order: 'descending'}">
				<el-table-column prop="sno" label="学号" sortable>
				</el-table-column>
				<el-table-column prop="sname" label="姓名">
				</el-table-column>
				<el-table-column prop="ssex" label="性别">
				</el-table-column>
				<el-table-column prop="sxy" label="院系">
				</el-table-column>
				<el-table-column prop="sqrade" label="年级">
				</el-table-column>
				<el-table-column prop="sclass" label="班级">
				</el-table-column>
				<el-table-column label="操作" width="150">
					<template slot-scope="scope">
						<el-button type="primary" size="mini" @click="changeTeacher(scope.row)">修改</el-button>
						<el-button type="danger" size="mini" @click="deleteEnter(scope.row)">删除</el-button>
					</template>
				</el-table-column>
			</el-table>
			<!-- 分页 -->
			<div class="fenye">
				<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
				 :page-sizes="[10, 15, 30]" :page-size=page_size layout="total, sizes, prev, pager, next, jumper" :total=total>
				</el-pagination>
			</div>
			<!-- 添加老师 -->
			<el-dialog :visible.sync="addTeacherForm" width="30%" :before-close="handleClose"  >
				<div>
					<el-form :model="form" label-width="60px" ref="form" :rules='AddTeacherFormRules'>
						<el-form-item label="学号" prop="sno">
							<el-input v-model="form.sno" placeholder="学号" ></el-input>
						</el-form-item>
						<el-form-item label="姓名" prop="sname">
							<el-input v-model="form.sname" placeholder="姓名"></el-input>
						</el-form-item>
						<el-form-item label="性别"  prop="ssex">
							<el-input v-model="form.ssex" placeholder="性别"></el-input>
						</el-form-item>
						<el-form-item label="院系" sxy>
							<el-input v-model="form.sxy" placeholder="院系"></el-input>
						</el-form-item>
						<el-form-item label="年级" prop="sqrade">
							<el-input v-model="form.sqrade" placeholder="年级"></el-input>
						</el-form-item>
						<el-form-item label="班级" prop="sclass">
							<el-input v-model="form.sclass" placeholder="班级"></el-input>
						</el-form-item>
					</el-form>
				</div>
				<span slot="footer" class="dialog-footer">
					<el-button @click="resetForm">重置</el-button>
					<el-button type="primary" @click="SuccessDia">确定</el-button>
				</span>
			</el-dialog>
			<!-- 修改老师 -->
			<el-dialog :visible.sync="ChangeTeacherFormDia" width="30%" :before-close="handleClose" >
				<div>
					<el-form :model="ChangeTeacherForm" label-width="60px" ref="form" :rules='AddTeacherFormRules' >
						<el-form-item label="学号">
							<el-input v-model="ChangeTeacherForm.sno" placeholder="学号" :disabled="edit"></el-input>
						</el-form-item>
						<el-form-item label="姓名" prop="sname">
							<el-input v-model="ChangeTeacherForm.sname" placeholder="姓名"></el-input>
						</el-form-item>
						<el-form-item label="性别"  prop="ssex">
							<el-input v-model="ChangeTeacherForm.ssex" placeholder="性别"></el-input>
						</el-form-item>
						<el-form-item label="院系" sxy>
							<el-input v-model="ChangeTeacherForm.sxy" placeholder="院系"></el-input>
						</el-form-item>
						<el-form-item label="年级" prop="sqrade">
							<el-input v-model="ChangeTeacherForm.sqrade" placeholder="年级"></el-input>
						</el-form-item>
						<el-form-item label="班级" prop="sclass">
							<el-input v-model="ChangeTeacherForm.sclass" placeholder="班级"></el-input>
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
				AddTeacherFormRules:{
					sno: [{
							required: true,
							message: '请输入学号',
							trigger: 'blur'
						}
					],
					sname: [{
							required: true,
							message: '请输入姓名',
							trigger: 'blur'
						}
					],
					ssex: [{
							required: true,
							message: '请输入性别',
							trigger: 'blur'
						}
					],
					sxy: [{
							required: true,
							message: '请输入院系',
							trigger: 'blur'
						}
					],
					sqrade: [{
							required: true,
							message: '请输入年级',
							trigger: 'blur'
						}
					],
					sclass: [{
							required: true,
							message: '请输入班级',
							trigger: 'blur'
						}
					]
				},
				// 禁用
				edit: true,
				ChangeTeacherFormDia: false,
				ChangeTeacherForm: {
					sno: "",
					sname: "",
					ssex: "",
					sxy:"",
					sqrade: "",
					sclass: ""
				},
				// 添加的dialog
				addTeacherForm: false,
				// 添加的表单
				form: {
					sno: "",
					sname: "",
					ssex: "",
					sxy:"",
					sqrade: "",
					sclass: ""
				},
				// 搜索左侧input
				input: '',
				// 选中的
				select: '',
				he: '',
				// 当前页
				currentPage: 1,
				// 页面大小
				page_size: 10,
				// 列表总数
				total: 50,
				// 列表数据
				tableData: [],
				sno: '',
				sname: '',
				sxy:'',
				sqrade:'',
				// 获取的行信息tgh
				row: ''
			}
		},
		created() {
			this.getStuList()
			this.getHeight()
		},
		methods: {
			// 确定修改
			async ChangeEnter() {
				console.log(this.ChangeTeacherForm);
				const {
					data: res
				} = await this.$http.post(`upadtStu`, this.ChangeTeacherForm)
				if (res.status !== 200) {
					return this.$message.error(res.msg)
				}
				this.$message.success(res.msg)
				this.getStuList()
				this.ChangeTeacherFormDia = false
			},
			// 修改取消按钮
			CancleDiaChange() {
				this.ChangeTeacherFormDia = false
				this.getStuList()
			},
			// 修改老师
			changeTeacher(row) {
				this.ChangeTeacherFormDia = true
				this.row = row
				let ChangeTeacherFormTemp = {
					sno: row.sno,
					sname: row.sname,
					ssex: row.ssex,
					sxy: row.sxy,
					sqrade: row.sqrade,
					sclass: row.sclass
				}
				this.ChangeTeacherForm = ChangeTeacherFormTemp
			},
			// 清空
			clearSelInp() {
				this.select = "",
					this.input = ""
			},
			async SuccessDia() {
				console.log(this.form);
				const {
					data: res
				} = await this.$http.post('addStu', this.form)
				if (res.status !== 200) {
					return this.$message.error(res.msg)
				}
				console.log("res"+res);
				this.$message.success(res.msg)
				this.resetForm()
				this.getStuList()
				this.addTeacherForm = false
			},
			// 重置
			resetForm() {
				this.form ={
					sno: "",
					sname: "",
					ssex: "",
					sxy:"",
					sqrade: "",
					sclass: ""
				}
			},
			// 添加按钮打开
			addTeacher() {
				this.addTeacherForm = true
			},
			// 删除老师
			deleteEnter(row) {
				this.row = row
				this.$confirm('确认删除该学生吗, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.retired()
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消'
					});
				});
			},
			async retired() {
				const {
					data: res
				} = await this.$http.post(`stuDeleteBySno`, this.row)
				if (res.status !== 200) {
					return this.$message.error(res.msg)
				}
				this.$message.success(res.msg)
				this.getStuList()

			},
			// 获取老师列表
			async getStuList() {
				if (this.select === "sname") {
					this.sname = this.input
				} else if (this.select === "sno") {
					this.sno = this.input
				} else if (this.select === "sqrade") {
					this.sqrade = this.input
				} else if (this.select === "sxy") {
					this.sxy = this.input
				} else{
					this.sname = ''
					this.sno = ''
					this.sxy = ''
					this.sqrade = ''
				}
				let obj = {
					"sname": this.sname,
					"sno": this.sno,
					"sxy": this.sxy,
					"sqrade": this.sqrade,
				}
				const {
					data: res
				} = await this.$http.post(`stuSelectAll?page=${this.currentPage}&pageSize=${this.page_size}`, obj)
				if (res.status !== 200) {
					return this.$message.error(res.msg)
				}
				console.log(res);
				// res.data.teacherTyList.forEach((item,index) => {
				// 	if(item.retired=="1"){
				// 		res.data.teacherTyList[index].retired="否"
				// 	}else if(item.retired=="0"){
				// 		res.data.teacherTyList[index].retired="是"
				// 	}
				// });
				this.tableData = res.data.stuTyList
				this.total = res.data.total
			},
			//动态修改高度
			getHeight() {
				var he = document.querySelector('#app')
				this.he = he.clientHeight - 230

			},
			// 点击修改页面大小
			handleSizeChange(val) {
				this.page_size = val
				this.getStuList()
			},
			handleCurrentChange(val) {
				this.currentPage = val
				this.getStuList()
			},
			// 关闭前
			handleClose(done) {
				this.$confirm('确认关闭？')
					.then(_ => {
						done();
						this.resetForm()
					})
					.catch(_ => {});
			},
		}
	}
</script>

<style>
	.search {
		float: left;
	}

	.rigAdd {
		float: right;
	}
	.widthSelect{width: 120px;}
</style>

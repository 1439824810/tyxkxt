<template>
<!-- 电脑端主页  控制着左侧的菜单 -->
	<el-container class="home-container">
		<!-- 头部 -->
		<el-header>体育选课后台管理
			<span>{{tname}}</span>
			<div>
				<el-button type="info" @click="logout">退出</el-button>
			</div>
		</el-header>
		<!-- 页面主体 -->
		<el-container>
			<!-- 侧边栏 -->
			<el-aside :width="isCollapse ? '64px' : '200px'">
				<div class="toggle-button" @click="toggleCollapse">|||</div>
				<!-- 侧边栏菜单 -->
				<el-menu background-color="#313643" text-color="#fff" active-text-color="#409eff" :collapse="isCollapse"
				 :collapse-transition="false" :router="true">
					<!-- 一级菜单 -->
					<el-submenu :index="item.id + ''" v-for="item in menulist" :key="item.id" class="yiji">
						<!-- 一级菜单模板区 -->
						<template slot="title">
							<!-- 图标 -->
							<i :class="iconsObj[item.id]"></i>
							<!-- 文本 -->
							<span>{{ item.authName }}</span>
						</template>
						<!-- 二级菜单 -->
						<el-menu-item :index="subItem.path" v-for="subItem in item.children" :key="subItem.id">
							<template slot="title">
								<!-- 图标 -->
								<i class="el-icon-menu"></i>
								<!-- 文本 -->
								<span>{{ subItem.authName }}</span>
							</template>
						</el-menu-item>
					</el-submenu>
				</el-menu>
			</el-aside>
			<!-- 右侧主体 -->
			<el-main>
				<router-view></router-view>
			</el-main>
		</el-container>
	</el-container>
</template>

<script>
	export default {
		data() {
			return {
				tname: "",
				classList: [],
				menulist: [{
					"id": 101,
					"authName": "教师管理",
					"path": null,
					"children": [{
						"id": 104,
						"authName": "教师信息",
						"path": 'teacherInfo',
						"children": []
					}]
				}, {
					"id": 145,
					"authName": "课程管理",
					"path": null,
					"children": [{
						"id": 104,
						"authName": "班课信息",
						"path": 'bkInfo',
						"children": []
					},{
						"id": 105,
						"authName": "科目信息",
						"path": 'classInfo',
						"children": []
					}]
				}, {
					"id": 125,
					"authName": "学生管理",
					"path": null,
					"children": [{
						"id": 104,
						"authName": "学生信息",
						"path": 'stuInfo',
						"children": []
					},{
						"id": 107,
						"authName": "信息上传",
						"path": 'upload',
						"children": []
					}]
				},{
					"id": 103,
					"authName": "账户管理",
					"path": null,
					"children": [{
						"id": 104,
						"authName": "账户信息",
						"path": 'accountInfo',
						"children": []
					}]
				},],
				iconsObj: {
					125: 'el-icon-user',
					103: 'el-icon-s-grid',
					101: 'el-icon-user-solid',
					102: 'el-icon-tickets',
					145: 'el-icon-c-scale-to-original'
				},
				// 不折叠
				isCollapse: false,
			}
		},
		created() {
            this.getTeacherName()
       
		},
		methods: {
			async logout() {
				window.sessionStorage.clear()
				this.$router.push('/login')
			},
			getTeacherName() {
				var tname = JSON.parse(window.sessionStorage.getItem("userInfo")).tname
				this.tname = tname
			},
			// 点击收缩
			toggleCollapse() {
				this.isCollapse = !this.isCollapse
			},
		}
	}
</script>

<style scoped>
	.home-container {
		height: 100%;
	}

	.el-header {
		background-color: #333A3D;
		display: flex;
		justify-content: space-between;
		padding-left: 10px;
		align-items: center;
		color: #73c4c8;
		font-size: 20px;
	}

	.el-header>div {
		display: flex;
		align-items: center;
	}

	.el-header>div span {
		margin-left: 15px;
	}

	.el-aside {
		background-color: #313643;
	}

	.el-aside .el-menu {
		border-right: none;
	}

	.el-main {
		background-color: #E5E9ED;
	}

	.iconfont {
		margin-right: 10px;
	}

	.toggle-button {
		background-color: #4a5064;
		font-size: 10px;
		line-height: 24px;
		color: #fff;
		text-align: center;
		letter-spacing: 0.2em;
		cursor: pointer;
	}

	.yiji {
		width: 100%;
		text-align: left;
	}
</style>

(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-13b53d96"],{2790:function(t,e,s){},bb51:function(t,e,s){"use strict";s.r(e);var n=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",[s("el-card",{staticClass:"card"},[s("div",{staticClass:"stuInfo"},[s("el-form",{ref:"form",attrs:{model:t.stuInfo,"label-width":"100px","label-position":"left"}},[s("el-form-item",{attrs:{label:"学号",prop:"sno"}},[s("el-input",{attrs:{placeholder:"学号",disabled:""},model:{value:t.stuInfo.sno,callback:function(e){t.$set(t.stuInfo,"sno",e)},expression:"stuInfo.sno"}})],1),s("el-form-item",{attrs:{label:"姓名",prop:"sname"}},[s("el-input",{attrs:{placeholder:"姓名",disabled:""},model:{value:t.stuInfo.sname,callback:function(e){t.$set(t.stuInfo,"sname",e)},expression:"stuInfo.sname"}})],1),s("el-form-item",{attrs:{label:"年级",prop:"sqrade"}},[s("el-input",{attrs:{placeholder:"年级",disabled:""},model:{value:t.stuInfo.sqrade,callback:function(e){t.$set(t.stuInfo,"sqrade",e)},expression:"stuInfo.sqrade"}})],1),s("el-form-item",{attrs:{label:"班级",prop:"sclass"}},[s("el-input",{attrs:{placeholder:"班级",disabled:""},model:{value:t.stuInfo.sclass,callback:function(e){t.$set(t.stuInfo,"sclass",e)},expression:"stuInfo.sclass"}})],1),s("el-form-item",{attrs:{label:"教学院",prop:"sxy"}},[s("el-input",{attrs:{placeholder:"教学院",disabled:""},model:{value:t.stuInfo.sxy,callback:function(e){t.$set(t.stuInfo,"sxy",e)},expression:"stuInfo.sxy"}})],1)],1)],1),s("div",{staticClass:"btns"},[s("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.ToTeacherInfo}},[t._v("教师信息")]),s("br"),s("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.ToClassinfo}},[t._v("课程信息")]),s("br"),s("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.ToXk}},[t._v("班课信息")]),s("br"),s("el-button",{attrs:{type:"primary",size:"small"},on:{click:t.ToXkInfo}},[t._v("选课信息")])],1)])],1)},a=[],o=s("1da1"),r=(s("96cf"),s("ac1f"),s("1276"),{data:function(){return{sno:"",stuInfo:{}}},created:function(){this.getInfo()},methods:{getInfo:function(){var t=this;return Object(o["a"])(regeneratorRuntime.mark((function e(){var s,n,a;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return t.sno=location.href.split("?")[1].split("=")[1].split("#")[0],s={sname:"",sno:t.sno,sxy:"",sqrade:""},e.next=4,t.$http.post("stuSelectAll?page=1&pageSize=1",s);case 4:if(n=e.sent,a=n.data,200===a.status){e.next=8;break}return e.abrupt("return",t.$message.error(a.msg));case 8:t.stuInfo=a.data.stuTyList[0];case 9:case"end":return e.stop()}}),e)})))()},ToTeacherInfo:function(){this.$router.push("/teacherinfo")},ToClassinfo:function(){this.$router.push("/classinfo")},ToXk:function(){this.$router.push("/xk")},ToXkInfo:function(){this.$router.push("/xkInfo")}}}),l=r,i=(s("c678"),s("2877")),u=Object(i["a"])(l,n,a,!1,null,"5ba48d9e",null);e["default"]=u.exports},c678:function(t,e,s){"use strict";s("2790")}}]);
//# sourceMappingURL=chunk-13b53d96.8c7f7fd1.js.map
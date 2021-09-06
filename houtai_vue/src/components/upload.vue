<template>
  <div class="Fbox">
<!-- 这是上传文件（学生信息），然后后台添加 -->
    <el-upload
      ref="upload"
      class="upload-demo"
      drag
      action="https://yu423.mynatapp.cc/tyxkxt/upload"
      :auto-upload="true"
      name="file"
      :on-success="handleAlbumSuccess"
      :before-upload="beforeUpload"
      multiple
    >
      <i class="el-icon-upload"></i>
      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
      <div class="el-upload__tip" slot="tip">
        只能上传不超过1M的文件
      </div>
    </el-upload>
  <!-- 这只是单纯的下载一下学生信息excel -->
    <!-- <a href="https://yu423.mynatapp.cc/tyxkxt/downLoadStuInfo"><el-button slot="trigger" size="small" type="primary" >下载文件</el-button></a> -->
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  created() {},
  methods: {
    submitUpload() {
      this.$refs.upload.submit();
    },
    handleAlbumSuccess(res) {
      if (res.status == 200) {
        this.$message.success(res.msg);
        console.log(res.data);
      } else {
        this.$message.error(res.msg);
      }
    },
    beforeUpload(file) {
     var testmsg=file.name.substring(file.name.lastIndexOf('.')+1)
     const extension = testmsg === 'xls'
     const extension2 = testmsg === 'xlsx'
     const isLt2M = file.size / 1024 / 1024 < 1
     if(!extension && !extension2) {
         this.$message({
             message: '上传文件只能是 xls、xlsx格式!',
             type: 'warning'
         });
     }
     // 也可以在这里增加文件大小限制
     if(!isLt2M) {
         this.$message({
             message: '上传文件大小不能超过 1MB!',
             type: 'warning'
         });
     }
     return (extension || extension2) && isLt2M
 },

  },
};
</script>

<style>
</style>

package com.example.spbmvc.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.pojo.StuTy;
import com.example.spbmvc.service.StuTyService;
import com.example.spbmvc.service.UpLoadFileService;
import com.example.spbmvc.vo.StuTyVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class UpLoadFileController {
    @Autowired
    private StuTyService stuTyService;
    @Autowired
    private UpLoadFileService upLoadFileService;
//easypoiexcel导出
    @GetMapping("/downLoadStuInfo")
    public void downLoadStuInfo(HttpServletResponse response){
        StuTyVo stuTyVo = stuTyService.stuSelectAll(null, null, null, null, null, null);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("学生信息","学生"),
                StuTy.class, stuTyVo.getStuTyList());
        if (workbook != null){
            downLoadExcel("学生信息.xlsx", response, workbook);
        }
    }
    //    下载有问题，这里返回Excel的不知道怎么写，但通过链接能访问下载
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-Type", "application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            //throw new NormalException(e.getMessage());
        }finally {
            if (workbook!=null){
                try{
                    workbook.close();
                }catch (Exception e){

                }
            }
        }
    }
//    easyexcel的导入
    @PostMapping("/upload")
    public FormatterResponse SingleFileUpLoad(@RequestParam("file") MultipartFile file) {
        //创建输入输出流
        InputStream inputStream = null;
        //获取文件的输入流
        try{
            inputStream = file.getInputStream();
        }catch (IOException e){
            return FormatterResponse.error("读写异常");
        }
        List<Object> readList =null;
        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, StuTy.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            readList = EasyExcelFactory.read(inputStream, sheet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            upLoadFileService.setStuInfo(readList);
        } catch (Exception e) {
            return FormatterResponse.error("上传异常");
        }
        return FormatterResponse.ok(readList,"ok");
    }
}

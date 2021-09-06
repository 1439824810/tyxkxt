package com.example.spbmvc;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.example.spbmvc.pojo.StuTy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class testUpload {


    @Test
    public void testUpload() {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        params.setSheetNum(1);
        List<StuTy> stuTyList =  ExcelImportUtil.importExcel(new File("c:/upload/1.xlsx"), StuTy.class, params);
        for (StuTy stuTy : stuTyList) {
            System.out.println(stuTy.toString());
        }
    }

    @Test
    public void testUploadEasyExcel() {
// 读取 excel 表格的路径
        String readPath = "c:/upload/stu.xlsx";

        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, StuTy.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            List<Object> readList = EasyExcelFactory.read(new FileInputStream(readPath), sheet);
            // 存 ExcelMode 实体的 集合
            List<StuTy> list = new ArrayList<StuTy>();
            for (Object obj : readList) {
                list.add((StuTy) obj);
            }

            // 取出数据
            StringBuilder str = new StringBuilder();
            str.append("{");
            String link = "";
            for (StuTy mode : list) {
                str.append(link).append("\""+mode.getSno()+"\":").append("\""+mode.getSname()+"\"").append("\""+mode.getSqrade()+"\"").append("\""+mode.getSsex()+"\"").append("\""+mode.getSclass()+"\"").append("\""+mode.getSxy()+"\"");
                link= ",";
            }
            str.append("};");
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }






}

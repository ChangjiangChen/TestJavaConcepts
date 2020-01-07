package com.algorithm.learn.test.unit1.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Chen Changjiang
 * @date : 2020/01/04
 * @description : 如果需要将excel中的内容批量写入数据库，用MultipleDataSourceTest工程处理
 */
public class TestExcelReadOrWrite {


    /**
     * 读取 excel 表格的路径
     */
    private static final String FILE_NAME = "E:\\DeskDirFiles\\卷孚科技\\充电桩\\银行主数据\\TLT-支持银行代码列表.xlsx";

    // 简单读取 (同步读取)
    private static void simpleRead() {
        try {
            // sheetNo --> 读取哪一个 表单
            // headLineMun --> 从哪一行开始读取( 不包括定义的这一行，比如 headLineMun为2 ，那么取出来的数据是从 第三行的数据开始读取 )
            // clazz --> 将读取的数据，转化成对应的实体，需要 extends BaseRowModel
            Sheet sheet = new Sheet(1, 1, ExcelDto.class);

            // 这里 取出来的是 ExcelModel实体 的集合
            List<Object> readList = EasyExcelFactory.read(new FileInputStream(FILE_NAME), sheet);
            // 存 ExcelMode 实体的 集合
            List<ExcelDto> list = new ArrayList<ExcelDto>();
            for (Object obj : readList) {
                list.add((ExcelDto) obj);
            }

            // 取出数据
            StringBuilder str = new StringBuilder();
            str.append("{");
            String link = "";
            for (ExcelDto mode : list) {
                str.append(link).append("\"" + mode.getCode() + "\":").append("\"" + mode.getName() + "\"");
                link = ",";
            }
            str.append("};");
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    // 异步读取
    private static void simpleAsyncRead() {
        try {
            Sheet sheet = new Sheet(1, 1, ExcelDto.class);
            EasyExcelFactory.readBySax(new FileInputStream(FILE_NAME), sheet, new ExcelModelListener());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

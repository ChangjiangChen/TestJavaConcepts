package com.algorithm.learn.test.unit1.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author : Chen Changjiang
 * @date : 2020/01/04
 * @description :
 */
public class ExcelDto extends BaseRowModel {

    @ExcelProperty(index = 1, value = "银行代码")
    private String code;

    @ExcelProperty(index = 2, value = "银行名称")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExcelDto{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

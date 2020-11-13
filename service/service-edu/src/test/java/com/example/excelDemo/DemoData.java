package com.example.excelDemo;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.ArrayList;
import java.util.List;

//设置表头和添加数据字段
public class DemoData {
    //设置表头名
    @ExcelProperty("学生编号")
    private int sno;

    //设置表头名称
    @ExcelProperty("学生姓名")
    private String sName;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "DemoData{" +
                "sno=" + sno +
                ", sName='" + sName + '\'' +
                '}';
    }
}

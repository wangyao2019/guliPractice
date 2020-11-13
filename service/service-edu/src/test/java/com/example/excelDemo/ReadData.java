package com.example.excelDemo;

import com.alibaba.excel.annotation.ExcelProperty;

public class ReadData {
    //设置列对应的属性
    @ExcelProperty(index = 0)
    private int sid;

    @ExcelProperty(index = 1)
    private String sName;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "ReadData{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                '}';
    }
}

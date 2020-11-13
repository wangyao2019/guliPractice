package com.example.excelDemo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestEasyExcel {
    public static void main(String[] args) {
        writeA();
//        writeB();
//        readA();
//        readB();

    }

    private static void writeA() {
        //写法一
        String fileName = "F:\\TestProject\\easyExcel01.xlsx";
        // 这里需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("写入方法一").doWrite(data());
    }

    private static void writeB() {
        //写法二,手动关闭流
        String fileName = "F:\\TestProject\\easyExcel01.xlsx";
        //这里需要指定用哪个class写
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("写入方法二").build();
        excelWriter.write(data(), writeSheet);
        //关闭文件流
        excelWriter.finish();
    }

    //实现写操作
    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setsName("A" + i);
            list.add(data);
        }
        return list;
    }

    private static void readA() {
        //写法一
        String fileName = "F:\\TestProject\\easyExcel01.xlsx";
        EasyExcel.read(fileName, ReadData.class, new ExcelListener()).sheet().doRead();
    }

    private static void readB() throws FileNotFoundException {
        // 写法2： 9
        InputStream in = new BufferedInputStream(new FileInputStream("F:\\TestProject\\easyExcel01.xlsx"));
        ExcelReader excelReader = EasyExcel.read(in, ReadData.class, new
                ExcelListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}

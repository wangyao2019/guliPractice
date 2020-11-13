package com.example.excelDemo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//读取Excel监听器
public class ExcelListener extends AnalysisEventListener<ReadData> {
    //创建list集合封装最终数据
    List<ReadData> list = new ArrayList<ReadData>();

    //一行一行读取Excel内容
    @Override
    public void invoke(ReadData readData, AnalysisContext analysisContext) {
        System.out.println("****" + readData);
        list.add(readData);
    }

    //读取Excel表头信息
    @Override
    public void invokeHead(Map<Integer, CellData> headMap, AnalysisContext context) {
        System.out.println("表头信息:" + headMap);
    }

    //读取完后执行
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}

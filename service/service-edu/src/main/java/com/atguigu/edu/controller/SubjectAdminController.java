package com.atguigu.edu.controller;

import com.atguigu.commonutils.R;
import com.atguigu.edu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class SubjectAdminController {

    private SubjectService subjectService;

    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //添加课程分类
    public R addSubject(MultipartFile file) {
        //获取上传的excel文件 MultipartFile
        //返回错误信息提示
//        subjectService.importSubjectData(file, subjectService);
        //判断返回集合是否为空
        return R.success();
    }
}

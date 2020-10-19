package com.atguigu.edu.controller;


import com.atguigu.edu.entity.Teacher;
import com.atguigu.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Levi
 * @since 2020-10-14
 */
@RestController
@RequestMapping("/edu/teacher")
@CrossOrigin //跨域
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //1.查询所有讲师数据 http://localhost:8001/edu/teacher/findAll
    @GetMapping("findAll")
    public List<Teacher> teacherList() {
        return teacherService.list(null);
    }

    //讲师逻辑删除功能
    @DeleteMapping("{id}")
    public boolean removeById(@PathVariable String id) {
        return teacherService.removeById(id);
    }
}


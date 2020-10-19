package com.atguigu.edu.controller;


import com.atguigu.edu.entity.Teacher;
import com.atguigu.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(consumes = "讲师管理")
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
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public List<Teacher> teacherList() {
        return teacherService.list(null);
    }

    //讲师逻辑删除功能
    @ApiOperation(value = "根据ID逻辑删除讲师")
    @DeleteMapping("{id}")
    public boolean removeById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        return teacherService.removeById(id);
    }
}


package com.atguigu.edu.controller;


import com.atguigu.commonutils.R;
import com.atguigu.edu.entity.Teacher;
import com.atguigu.edu.query.TeacherQuery;
import com.atguigu.edu.service.TeacherService;
import com.atguigu.servicebase.handler.GuliExceptionHandler;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public R teacherList() {
        List<Teacher> list = teacherService.list(null);
        return R.success().data("items", list);
    }

    //讲师逻辑删除功能
    @ApiOperation(value = "根据ID逻辑删除讲师")
    @DeleteMapping("delete/{id}")
    public R removeById(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        boolean flag = teacherService.removeById(id);
        if (flag) {
            return R.success();
        } else {
            return R.error();
        }
    }

    //分页讲师列表
    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageTeacher/{page}/{limit}")
    public R pageList(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable Long page, @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable Long limit) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.page(pageParam, null);
//        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", pageParam.getRecords());
//        return R.success().data("total", total).data("rows", records);
        return R.success().data(map);
    }

    @ApiOperation(value = "分页讲师列表")
//    @GetMapping("pageTeacherCondition/{page}/{limit}")
    @PostMapping("pageTeacherCondition/{page}/{limit}") //使用json传递数据，把json对象封装到对应对象里面
    public R pageTeacherCondition(@PathVariable Long page, @PathVariable Long limit, @RequestBody(required = false) TeacherQuery teacherQuery) { //RequestBody 返回json数据
//    public R pageTeacherCondition(@PathVariable Long page, @PathVariable Long limit, TeacherQuery teacherQuery) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return R.success().data("total", total).data("rows", records);
    }

    //增加
    @ApiOperation(value = "新增讲师")
    @PostMapping("addNewTeacher")
    public R addNewTeacher(@ApiParam(name = "teacher", value = "讲师对象", required = true) @RequestBody Teacher teacher) {
        //异常模拟
//        try {
//            int a = 10 / 0;
//        } catch (Exception e) {
//            System.out.println("异常捕获");
//            throw new GuliExceptionHandler(20001, "GuliExceptionHandler自定义异常");
//        }
        if (teacher.getName() != null && teacher.getCareer() != null && teacher.getIntro() != null && teacher.getLevel() != null && teacher.getSort() != null)
        {
            teacherService.save(teacher);
            return R.success();
        }
        else {
            return R.error().data("message","请补充完整数据");
        }
    }

    //根据ID查询
    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("getTeacherByID/{id}")
    public R getTeacherByID(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        Teacher teacher = teacherService.getById(id);
        return R.success().data("teacher", teacher);
    }

    //根据ID修改
    @ApiOperation(value = "根据ID修改讲师")
    @PutMapping("updateByID/{id}")
    public R updateByID(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id,
                        @ApiParam(name = "teacher", value = "讲师对象", required = true) @RequestBody Teacher teacher) {
        teacher.setId(id);
        teacherService.updateById(teacher);
        return R.success();
    }

}


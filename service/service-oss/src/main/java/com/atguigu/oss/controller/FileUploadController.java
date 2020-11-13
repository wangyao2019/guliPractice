package com.atguigu.oss.controller;


import com.atguigu.commonutils.R;
import com.atguigu.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(consumes = "oss云文件管理")
@CrossOrigin
@RestController
@RequestMapping("eduOss/user/upPhoto")
public class FileUploadController {
    private FileService fileService;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @ApiOperation(value = "头像上传")
    @PostMapping("upload")
    public R upLoad(@ApiParam(name = "file", value = "文件", required = true)
                    @RequestParam("file") MultipartFile file) {
        String uploadUrl = fileService.upLoad(file);
        //返回r对象
        return R.success().message("文件上传成功").data("url", uploadUrl);
    }

}

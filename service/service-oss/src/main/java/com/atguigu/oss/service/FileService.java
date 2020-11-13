package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    //上传文件
    String upLoad(MultipartFile file);
}

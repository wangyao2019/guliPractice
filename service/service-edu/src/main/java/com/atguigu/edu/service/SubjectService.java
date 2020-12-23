package com.atguigu.edu.service;

import org.springframework.web.multipart.MultipartFile;

public interface SubjectService {
    void batchImport(MultipartFile file);
}

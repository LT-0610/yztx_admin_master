package com.ruoyi.web.controller.common;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@RestController
public class ResourcesController {

    /**
     * 获取药品信息的语音文件
     * @return
     * @throws IOException
     */
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadFile() throws IOException {
        // 构造文件路径
        String fullPath = "ruoyi-admin/src/main/resources/test.mp3";
        // 创建文件对象
        File file = new File(fullPath);
        // 创建文件输入流
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        // 返回响应实体
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .body(resource);
    }
}

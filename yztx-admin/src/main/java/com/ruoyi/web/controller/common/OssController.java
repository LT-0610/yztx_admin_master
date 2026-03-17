package com.ruoyi.web.controller.common;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.AliOssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping
@Api(tags = "通用接口")
@Slf4j
public class OssController {

    @Autowired
    private AliOssUtil aliOssUtil;

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/uploadOss")
    @ApiOperation("文件上传")
    public AjaxResult upload(MultipartFile file){
        log.info("文件上传：{}",file);

        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名的后缀   dfdfdf.png
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称
            String objectName = UUID.randomUUID().toString() + extension;

            //文件的请求路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);


            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", filePath);
            ajax.put("newFileName", objectName);
            ajax.put("originalFilename", originalFilename);
            return ajax;
        } catch (IOException e) {
            log.error("文件上传失败：{}", e);
            return AjaxResult.error(e.getMessage());
        }

    }
}

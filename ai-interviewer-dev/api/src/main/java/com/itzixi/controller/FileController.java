package com.itzixi.controller;

import com.itzixi.base.MinIOConfig;
import com.itzixi.base.MinIOUtils;
import com.itzixi.grace.result.GraceJSONResult;
import com.itzixi.grace.result.ResponseStatusEnum;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @ClassName FileController
 * @Author 公众号【风间影月】
 * @Version 1.0
 * @Description FileController
 **/
@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private MinIOConfig minIOConfig;

    @PostMapping("uploadInterviewerImage")
    public GraceJSONResult uploadInterviewerImage(@RequestParam("file") MultipartFile file) throws Exception {

        // 获得文件原始名称
        String filename = file.getOriginalFilename();
        if (StringUtils.isBlank(filename)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
        }

        filename = "interviewer/" + dealWithoutFilename(filename);
        String imageUrl = MinIOUtils.uploadFile(minIOConfig.getBucketName(),
                                                filename,
                                                file.getInputStream(),
                                                true);

        return GraceJSONResult.ok(imageUrl);
    }

    @PostMapping("uploadInterviewVideo")
    public GraceJSONResult uploadInterviewVideo(@RequestParam("file") MultipartFile file) throws Exception {

        // 获得文件原始名称
        String filename = file.getOriginalFilename();
        if (StringUtils.isBlank(filename)) {
            return GraceJSONResult.errorCustom(ResponseStatusEnum.FILE_UPLOAD_NULL_ERROR);
        }

        filename = "interviewVideo/" + dealWithoutFilename(filename);
        String videoUrl = MinIOUtils.uploadFile(minIOConfig.getBucketName(),
                filename,
                file.getInputStream(),
                true);

        return GraceJSONResult.ok(videoUrl);
    }

    private String dealWithFilename(String filename) {
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String fName = filename.substring(0, filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        return fName + "-" + uuid + suffixName;
    }

    private String dealWithoutFilename(String filename) {
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        return uuid + suffixName;
    }

}

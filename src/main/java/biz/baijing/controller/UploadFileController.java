package biz.baijing.controller;

import biz.baijing.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadFileController {

    @PostMapping("/upload")
    public Result upload(String username,Integer age,MultipartFile image) throws Exception {
        log.info("上传文件 {},{},{}", username, age, image);

        // 获取文件名
        String ofn = image.getOriginalFilename();
        // 存储文件到本地
        image.transferTo(new File("/Users/ann/JavaDev/uploadfile/university/" + ofn));

        return Result.success();
    }
}

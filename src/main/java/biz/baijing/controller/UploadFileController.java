package biz.baijing.controller;

import biz.baijing.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@RestController
public class UploadFileController {

    @PostMapping("/upload")
    public Result upload(String username,Integer age,MultipartFile image) throws Exception {
        log.info("上传文件 {},{},{}", username, age, image);

        // 获取文件名
        String ofn = image.getOriginalFilename();
        // 构建唯一文件名 (这部分能通过通用方法解决)

        String ext = ofn.substring(ofn.lastIndexOf("."));
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dtnow = dateFormat.format(LocalDateTime.now());
        // 文件名为 UUID + 当前时间戳 ，分割符为 - ，扩展名为原文件扩展名
        String newofn = UUID.randomUUID().toString().replace("-","") + '-' + dtnow + ext;

        log.info("新的文件名：{}", newofn);
        // 存储文件到本地
        image.transferTo(new File("/Users/ann/JavaDev/uploadfile/university/" + newofn));

        return Result.success();
    }
}

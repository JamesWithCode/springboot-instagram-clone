package com.jamesdev.springbootinstagramclone.controller;

import com.jamesdev.springbootinstagramclone.service.AmazonS3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class S3TestController {

      private final AmazonS3Uploader s3Uploader;

      @PostMapping("/images")
      public String upload(@RequestParam("images")MultipartFile multipartFile)throws IOException {
            return s3Uploader.uploadImage(multipartFile);

      }

}

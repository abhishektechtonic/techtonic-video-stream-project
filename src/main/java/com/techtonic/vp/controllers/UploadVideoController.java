package com.techtonic.vp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techtonic.vp.payloads.VideoDto;
import com.techtonic.vp.responses.ApiResponse;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/")
@ApiOperation(value = "This is used for uploading the video file")
@Slf4j
public class UploadVideoController {

    @PostMapping("video")
    public ResponseEntity<?> uploadVideo(@ModelAttribute("videoDto") VideoDto videoDto) {
        log.info("This method is ready to being called.. with file name"
                + videoDto.getMultipartFile().getOriginalFilename());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Video response ", true, null));
    }
}

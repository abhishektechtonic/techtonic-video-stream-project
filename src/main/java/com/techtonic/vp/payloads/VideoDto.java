package com.techtonic.vp.payloads;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiModel;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("This dto will accept the upload video related parameter")
public class VideoDto {
    
    @NotNull(message = "Video can't be null. you must upload at least one video")
    private MultipartFile multipartFile;
}

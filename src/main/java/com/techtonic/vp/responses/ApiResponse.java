package com.techtonic.vp.responses;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "This model is used for reponses for every api")
public class ApiResponse {

    private String msg;
    private boolean status;
    private Object data;
}

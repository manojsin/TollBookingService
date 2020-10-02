package com.hopscotch.tollticketingservice.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ResponseUtil {

    public BaseResponse populateBasicResponse(BasicResponseStatus basicResponseStatus, List<String> devMessage) {

        BaseResponse responseStatusBO = new BaseResponse();
        responseStatusBO.setHttpCode(basicResponseStatus.getHttpCode());
        responseStatusBO.setStatus(basicResponseStatus.isStatus());
        responseStatusBO.setMessage(basicResponseStatus.getMessage());
        responseStatusBO.setDeveloperMessages(devMessage);
        return responseStatusBO;
    }

    public BaseResponse populateBasicResponse(BasicResponseStatus basicResponseStatus) {
        BaseResponse responseStatusBO = new BaseResponse();
        responseStatusBO.setHttpCode(basicResponseStatus.getHttpCode());
        responseStatusBO.setStatus(basicResponseStatus.isStatus());
        responseStatusBO.setMessage(basicResponseStatus.getMessage());
        return responseStatusBO;
    }
}

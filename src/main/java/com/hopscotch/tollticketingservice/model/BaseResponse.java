package com.hopscotch.tollticketingservice.model;
import lombok.Data;
import java.util.List;
@Data
public class BaseResponse {
    private boolean status;
    private String code;
    private String httpCode;
    private String message;
    private List<String> developerMessages;
}

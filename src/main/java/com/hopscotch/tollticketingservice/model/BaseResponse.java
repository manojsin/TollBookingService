package com.hopscotch.tollticketingservice.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {
    private boolean status;
    private String code;
    private String httpCode;
    private String message;
    private List<String> developerMessages;
}

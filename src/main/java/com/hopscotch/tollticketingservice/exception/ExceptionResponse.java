package com.hopscotch.tollticketingservice.exception;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Map;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    private String status;
    private String errorMessage;
    private Map<String,String> errorMap;
    private int errorCode;

    public ExceptionResponse(String errorMessage , int erroCode){
        this.status = "Failure";
        this.errorMessage = errorMessage;
        this.errorCode = erroCode;
    }
    public ExceptionResponse(String invalidRequestValue, int invalidRequestCode, Map<String, String> errorMap) {
        this(invalidRequestValue,invalidRequestCode);
        this.errorMap = errorMap;
    }
}

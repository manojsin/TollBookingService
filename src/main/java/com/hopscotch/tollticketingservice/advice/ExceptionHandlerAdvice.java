package com.hopscotch.tollticketingservice.advice;
import com.hopscotch.tollticketingservice.exception.ExceptionResponse;
import com.hopscotch.tollticketingservice.exception.RequestInvalidException;
import com.hopscotch.tollticketingservice.utils.CommonConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleException(Exception e){
        ExceptionResponse response = new ExceptionResponse(CommonConstant.INTERNAL_SERVER_ERROR_MSG, CommonConstant.INTERNAL_SERVER_ERROR_CODE);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RequestInvalidException.class)
    public final ResponseEntity<?> handleRequestInvalidException(RequestInvalidException e){
        ExceptionResponse exception = new ExceptionResponse(CommonConstant.INVALID_REQUEST_ERROR_MSG, CommonConstant.INVALID_REQUEST_ERROR_CODE, e.getErrorMap());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}

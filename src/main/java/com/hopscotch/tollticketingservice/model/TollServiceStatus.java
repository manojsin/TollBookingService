package com.hopscotch.tollticketingservice.model;

public enum TollServiceStatus implements BasicResponseStatus{

    USER_INVALID_PASS("200","Success","does't have valid pass",false),
    USER_VALID_PASS("200","Success","valid pass",true),
    PASS_NOT_AVAILABLE_FOR_TWO_WHEELER("200","Success","Currently pass  are not available for two wheeler",false),
    PASS_AVAILABLE("200","Success","Successfully pass details are fetched",true),
    PASS_BOOKING_FAILED("500","Failure","Internal Server Error",false),
    PASS_BOOKING_SUCCESS("200","Success","Pass Successfully booked",false);

    private boolean status;
    private String message;
    private String httpCode;
    private String developerMessage;

     TollServiceStatus(String httpCode, String message, String developerMessage, boolean status){
        this.status = status;
        this.message = message;
        this.httpCode= httpCode;
        this.developerMessage= developerMessage;
    }

    public boolean isStatus() {
        return status;
    }
    public String getMessage() {
        return message;
    }
    public String getHttpCode() {
        return httpCode;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
}


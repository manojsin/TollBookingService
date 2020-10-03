package com.hopscotch.tollticketingservice.model;

public enum TollServiceStatus implements BasicResponseStatus{

    USER_INVALID_PASS("200","does't have valid pass",null,false),
    USER_VALID_PASS("200","valid pass",null,true),
    PASS_NOT_AVAILABLE_FOR_TWO_WHEELER("200","Currently pass  are not available for two wheeler",null,false),
    PASS_NOT_AVAILABLE_FOR_FOUR_WHEELER("200","Currently pass  are not available for for wheeler",null,false),
    PASS_AVAILABLE("200","Successfully fetched pass details",null,true),
    PASS_BOOKING_FAILED("500","Internal Server Error",null,false),
    PASS_BOOKING_SUCCESS("200","Pass Successfully booked","",true),
    TOTAL_COLLECTION_DATA_NOT_AVAILABLE("200","Sorry Data is not available for this Query",null,false),
    TOTAL_COLLECTION_SUCCESS("200","Successfully total amount and vehicle data fetched",null,true);

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


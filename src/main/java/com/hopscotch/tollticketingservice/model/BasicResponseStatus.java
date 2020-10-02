package com.hopscotch.tollticketingservice.model;

public interface BasicResponseStatus {
    boolean isStatus();
    String getMessage();
    String getHttpCode();
    String getDeveloperMessage();
}

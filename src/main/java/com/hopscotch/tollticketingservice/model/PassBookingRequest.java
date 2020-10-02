package com.hopscotch.tollticketingservice.model;
import lombok.Data;
@Data
public class PassBookingRequest {
    private String vehicleRegNum;
    private String vehicleType;
    private Long tollId;
    private String tollName;
    private Long boothId;
    private String passType;
    private Double passPrice;
}

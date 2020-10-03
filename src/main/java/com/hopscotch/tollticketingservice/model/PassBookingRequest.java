package com.hopscotch.tollticketingservice.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassBookingRequest {
    private String vehicleRegNum;
    private String vehicleType;
    private Long tollId;
    private String tollName;
    private Long boothId;
    private String passType;
    private Double passPrice;
}

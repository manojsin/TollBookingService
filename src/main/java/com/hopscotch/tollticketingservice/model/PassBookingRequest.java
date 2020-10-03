package com.hopscotch.tollticketingservice.model;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class PassBookingRequest {
    @Positive(message = "Invalid TollId ")
    private Long tollId;
    @Positive(message = "Invalid BoothId ")
    private Long boothId;
    @Positive(message = "passPrice should be positive value")
    @Digits(integer = 10, fraction = 2,message = "passPrice is invalid")
    private Double passPrice;
    @NotNull(message = "VehicleRegNum can't be null")
    @NotEmpty(message = "VehicleRegNum can't be empty")
    @NotBlank(message = "VehicleRegNum can't be Blank")
    private String vehicleRegNum;
    @NotNull(message = "VehicleType can't be null")
    @NotEmpty(message = "VehicleType can't be empty")
    @NotBlank(message = "VehicleType can't be Blank")
    private String vehicleType;
    @NotNull(message = "PassType can't be null")
    @NotEmpty(message = "PassType can't be empty")
    @NotBlank(message = "PassType can't be Blank")
    private String passType;
    @NotNull(message = "TollName can't be null")
    @NotEmpty(message = "TollName can't be empty")
    @NotBlank(message = "TollName can't be Blank")
    private String tollName;
}

package com.hopscotch.tollticketingservice.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassBookingRequest {
    private Long tollId;
    private Long boothId;
    private Double passPrice;
    @NotNull(message = "VehicleRegNum can't be null")
    @NotEmpty(message = "VehicleRegNum can't be empty")
    private String vehicleRegNum;
    @NotNull(message = "VehicleType can't be null")
    @NotEmpty(message = "VehicleType can't be empty")
    private String vehicleType;
    @NotNull(message = "PassType can't be null")
    @NotEmpty(message = "PassType can't be empty")
    private String passType;
    @NotNull(message = "TollName can't be null")
    @NotEmpty(message = "TollName can't be empty")
    private String tollName;
}

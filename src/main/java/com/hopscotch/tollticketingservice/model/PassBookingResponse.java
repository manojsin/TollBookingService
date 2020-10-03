package com.hopscotch.tollticketingservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassBookingResponse extends AbstractResponse {
    private String bookingRefNum;
    private Date bookingDateTime;
    private Double passPrice;
}

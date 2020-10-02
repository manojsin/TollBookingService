package com.hopscotch.tollticketingservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PassBookingResponse extends AbstractResponse {
    private String bookingRefNum;
    private Date bookingDateTime;
    private Double passPrice;
}

package com.hopscotch.tollticketingservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TotalCollectionResponse extends AbstractResponse {
    private Integer crossedVehicle;
    private Double totalCollection;
    private Long tollId;
    private Long boothId;
}

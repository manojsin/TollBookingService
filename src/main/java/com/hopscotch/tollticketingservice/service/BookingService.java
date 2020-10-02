package com.hopscotch.tollticketingservice.service;
import com.hopscotch.tollticketingservice.model.CheckValidityResponse;
import com.hopscotch.tollticketingservice.model.PassBookingRequest;
import com.hopscotch.tollticketingservice.model.PassBookingResponse;
import com.hopscotch.tollticketingservice.model.PassDetailResponse;

public interface BookingService {
    CheckValidityResponse checkValidity(String registrationNumber);
    PassDetailResponse getAllPassDetails(String vehicleType,Long tollId);
    PassBookingResponse issuePass(PassBookingRequest passBookingRequest);
}

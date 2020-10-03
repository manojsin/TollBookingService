package com.hopscotch.tollticketingservice.service;
import com.hopscotch.tollticketingservice.model.*;

public interface BookingService {
    CheckValidityResponse checkValidity(String registrationNumber);
    PassDetailResponse getAllPassDetails(String vehicleType,Long tollId);
    PassBookingResponse issuePass(PassBookingRequest passBookingRequest);
}

package com.hopscotch.tollticketingservice.service;
import com.hopscotch.tollticketingservice.model.CheckValidityResponse;
import com.hopscotch.tollticketingservice.model.PassBookingRequest;
import com.hopscotch.tollticketingservice.model.PassBookingResponse;
import com.hopscotch.tollticketingservice.model.PassDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TollPassBookingService {

    private BookingFactory factory;
    private BookingService bookingService;

    @Autowired
    public TollPassBookingService(BookingFactory factory) {
        this.factory=factory;
    }

   public CheckValidityResponse checkValidity(String registrationNumber, String vehicleType){
        bookingService=factory.getBookingService(vehicleType);
        return bookingService.checkValidity(registrationNumber);
    }

    public PassDetailResponse getAllPassDetails(String vehicleType,Long tollId){
        bookingService=factory.getBookingService(vehicleType);
       return bookingService.getAllPassDetails(vehicleType,tollId);
    }
   public PassBookingResponse issuePass(PassBookingRequest passBookingRequest){
        bookingService=factory.getBookingService(passBookingRequest.getVehicleType());
        return bookingService.issuePass(passBookingRequest);
    }

}

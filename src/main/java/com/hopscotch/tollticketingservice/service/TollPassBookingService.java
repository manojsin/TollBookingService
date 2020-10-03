package com.hopscotch.tollticketingservice.service;
import com.hopscotch.tollticketingservice.entity.BookingDetail;
import com.hopscotch.tollticketingservice.model.*;
import com.hopscotch.tollticketingservice.repository.BookingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TollPassBookingService  implements CommonService{

    private BookingFactory factory;
    private BookingService bookingService;
    private BookingDetailRepository bookingDetailRepository;
    private  ResponseUtil responseUtil;


    @Autowired
    public TollPassBookingService(BookingFactory factory,BookingDetailRepository bookingDetailRepository,ResponseUtil responseUtil) {
        this.factory=factory;
        this.bookingDetailRepository=bookingDetailRepository;
        this.responseUtil=responseUtil;
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

    @Override
    public TotalCollectionResponse getTotalCollection(Long bootId, Long tollId) {
        TotalCollectionResponse response=new TotalCollectionResponse();
        List<BookingDetail> bookingData= bookingDetailRepository.findByTollNumAndBoothNum(tollId,bootId);
        if(bookingData.isEmpty() || null==bookingData ) {
            response.setStatus(responseUtil.populateBasicResponse(TollServiceStatus.TOTAL_COLLECTION_DATA_NOT_AVAILABLE));
            return response;
        }
        Double totalCollection= bookingData.stream().collect(Collectors.summingDouble(BookingDetail::getPassPrice));
        int totalCrossVehicle= bookingData.stream().collect(Collectors.summingInt(BookingDetail::getUsedNum));
        response.setTollId(tollId);
        response.setBoothId(bootId);
        response.setCrossedVehicle(totalCrossVehicle);
        response.setTotalCollection(totalCollection);
        response.setStatus(responseUtil.populateBasicResponse(TollServiceStatus.TOTAL_COLLECTION_SUCCESS));
        return response;
    }
}

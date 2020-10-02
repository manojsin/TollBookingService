package com.hopscotch.tollticketingservice.service;
import com.hopscotch.tollticketingservice.entity.BookingDetail;
import com.hopscotch.tollticketingservice.entity.PassDetail;
import com.hopscotch.tollticketingservice.entity.TollDetail;
import com.hopscotch.tollticketingservice.model.*;
import com.hopscotch.tollticketingservice.repository.BookingDetailRepository;
import com.hopscotch.tollticketingservice.repository.PassDetailRepository;
import com.hopscotch.tollticketingservice.repository.TollDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class TwoWheelerBookingServiceImpl implements BookingService {

    private BookingDetailRepository bookingDetailRepository;
    private TollDetailRepository tollDetailRepository;
    private PassDetailRepository passDetailRepository;
    private ResponseUtil responseUtil;

    @Autowired
    public TwoWheelerBookingServiceImpl(BookingDetailRepository bookingDetailRepository,
                                        TollDetailRepository tollDetailRepository,
                                        PassDetailRepository passDetailRepository,
                                        ResponseUtil responseUtil) {
        this.bookingDetailRepository=bookingDetailRepository;
        this.tollDetailRepository=tollDetailRepository;
        this.passDetailRepository=passDetailRepository;
        this.responseUtil=responseUtil;
    }

    @Override
    public CheckValidityResponse checkValidity(String registrationNumber) {
        CheckValidityResponse response=new CheckValidityResponse();
        Optional<List<BookingDetail>>bookingDetails= bookingDetailRepository.checkValidPassByRegistrationNum(registrationNumber);
        if(!bookingDetails.isPresent()) {
            response.setBaseResponse(responseUtil.populateBasicResponse(TollServiceStatus.USER_INVALID_PASS));
            return response;
        }
        response.setBaseResponse(responseUtil.populateBasicResponse(TollServiceStatus.USER_VALID_PASS));
        return response ;
    }
    @Override
    public PassDetailResponse getAllPassDetails(String vehicleType,Long tollId) {
        PassDetailResponse response=new PassDetailResponse();
        Optional<TollDetail> tollDetail=tollDetailRepository.findByTollNum(tollId);
        Set<PassDetail> passDetails;
        String tollName;
        if(!tollDetail.isPresent()) {
            response.setBaseResponse(responseUtil.populateBasicResponse(TollServiceStatus.PASS_NOT_AVAILABLE_FOR_TWO_WHEELER));
            return response;
        }
        tollName=tollDetail.get().getTollName();
        passDetails =tollDetail.get().getPassDetails().stream().filter(pass -> pass.getApplyOn().equalsIgnoreCase(vehicleType)).collect(Collectors.toSet());
        PassDetailResponse success= new PassDetailResponse(tollName,passDetails,tollId,tollDetail.get().getTollBoothDetails());
        success.setBaseResponse(responseUtil.populateBasicResponse(TollServiceStatus.PASS_AVAILABLE));
        return success;
    }
    @Override
    public PassBookingResponse issuePass(PassBookingRequest passBookingRequest) {
        PassBookingResponse response=new PassBookingResponse();
        String bookingRefNumber= UUID.randomUUID().toString();
        BookingDetail bookingDetail= new BookingDetail(passBookingRequest,bookingRefNumber);
        Optional<BookingDetail> bookingDetail1=Optional.ofNullable(bookingDetailRepository.save(bookingDetail));
        if(!bookingDetail1.isPresent()) {
            response.setBaseResponse(responseUtil.populateBasicResponse(TollServiceStatus.PASS_BOOKING_FAILED));
            return response;
        }
        response.setBookingRefNum(bookingRefNumber);
        response.setPassPrice(bookingDetail.getPassPrice());
        response.setBookingDateTime(new Date());
        response.setBaseResponse(responseUtil.populateBasicResponse(TollServiceStatus.PASS_BOOKING_SUCCESS));
        return response;
    }
}

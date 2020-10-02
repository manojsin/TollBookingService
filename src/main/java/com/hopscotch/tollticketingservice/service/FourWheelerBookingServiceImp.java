package com.hopscotch.tollticketingservice.service;

import com.hopscotch.tollticketingservice.entity.BookingDetail;
import com.hopscotch.tollticketingservice.entity.PassDetail;
import com.hopscotch.tollticketingservice.entity.TollDetail;
import com.hopscotch.tollticketingservice.model.CheckValidityResponse;
import com.hopscotch.tollticketingservice.model.PassBookingRequest;
import com.hopscotch.tollticketingservice.model.PassBookingResponse;
import com.hopscotch.tollticketingservice.model.PassDetailResponse;
import com.hopscotch.tollticketingservice.repository.BookingDetailRepository;
import com.hopscotch.tollticketingservice.repository.TollDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FourWheelerBookingServiceImp implements BookingService {


    private BookingDetailRepository bookingDetailRepository;
    private TollDetailRepository tollDetailRepository;
    @Autowired
    public FourWheelerBookingServiceImp(BookingDetailRepository bookingDetailRepository,TollDetailRepository tollDetailRepository) {
        this.bookingDetailRepository=bookingDetailRepository;
        this.tollDetailRepository=tollDetailRepository;
    }

    @Override
    public CheckValidityResponse checkValidity(String registrationNumber) {
        Optional<List<BookingDetail>> bookingDetails= bookingDetailRepository.checkValidPassByRegistrationNum(registrationNumber);
        if(bookingDetails.isPresent()) {
            return new CheckValidityResponse();
        }
        return new CheckValidityResponse();
    }
    @Override
    public PassDetailResponse getAllPassDetails(String vehicleType,Long tollId) {
        Optional<TollDetail> tollDetail=tollDetailRepository.findByTollNum(tollId);
        Set<PassDetail> passDetails=null;
        String tollName=null;
        if(tollDetail.isPresent()) {
            tollName=tollDetail.get().getTollName();
            passDetails =tollDetail.get().getPassDetails().stream().filter(pass -> pass.getApplyOn().equalsIgnoreCase(vehicleType)).collect(Collectors.toSet());
        }
        return new PassDetailResponse(tollName,passDetails,tollId,tollDetail.get().getTollBoothDetails());
    }

    @Override
    public PassBookingResponse issuePass(PassBookingRequest passBookingRequest) {
        return null;
    }
}

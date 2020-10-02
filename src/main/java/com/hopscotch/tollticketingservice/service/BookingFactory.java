package com.hopscotch.tollticketingservice.service;
import com.hopscotch.tollticketingservice.utils.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookingFactory {

    private TwoWheelerBookingServiceImpl twoWheelerBooking;
    private FourWheelerBookingServiceImp fourWheelerBooking;

    @Autowired
    public BookingFactory(TwoWheelerBookingServiceImpl twoWheelerBookingService,FourWheelerBookingServiceImp fourWheelerBookingServiceImp)
    {
        this.fourWheelerBooking=fourWheelerBookingServiceImp;
        this.twoWheelerBooking=twoWheelerBookingService;

    }
    public BookingService getBookingService(String vehicleType) {
        switch (vehicleType.toUpperCase()) {
            case CommonConstant.TWO_WHEELER:
                return twoWheelerBooking;
            case CommonConstant.FOUR_WHEELER:
                return fourWheelerBooking;
            default:
                return null;
        }
    }
}

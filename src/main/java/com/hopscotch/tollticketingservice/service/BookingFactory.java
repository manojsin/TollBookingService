package com.hopscotch.tollticketingservice.service;
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
        switch (vehicleType) {
            case "TWOWHEELER":
                return twoWheelerBooking;
            case "FOURWHEELER":
                return fourWheelerBooking;
            default:
                return null;
        }
    }
}

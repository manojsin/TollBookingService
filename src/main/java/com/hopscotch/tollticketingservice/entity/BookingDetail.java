package com.hopscotch.tollticketingservice.entity;
import com.hopscotch.tollticketingservice.model.PassBookingRequest;
import com.hopscotch.tollticketingservice.utils.CommonUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@Entity
@Table(name = "pass_booking_details")
public class BookingDetail implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "vehicle_reg_num")
    private String vehicleRegNum;
    @Column(name = "vehicle_type")
    private String vehicleType;
    @Column(name = "toll_num")
    private Long tollNum;
    @Column(name = "booth_num")
    private Long boothNum;
    @Column(name = "booking_ref_num")
    private String bookingRefNum;
    @Column(name = "valid_till")
    private Date validTill;
    @Column(name = "valid_from")
    private Date validFrom;
    @Column(name = "pass_type")
    private String passType;
    @Column(name = "pass_price")
    private Double passPrice;
    @Column(name = "pass_issue_date")
    private Date passIssueDate;
    @Column(name = "max_limit")
    private int maxLimit;
    @Column(name = "used_num")
    private int usedNum;

    public BookingDetail (PassBookingRequest passBookingRequest,String bookingRef)
    {
     this.vehicleRegNum=passBookingRequest.getVehicleRegNum();
     this.vehicleType=passBookingRequest.getVehicleType();
     this.tollNum=passBookingRequest.getTollId();
     this.boothNum=passBookingRequest.getBoothId();
     this.bookingRefNum=bookingRef;
     this.validTill= CommonUtil.calculatePassExpiryDate(passBookingRequest.getPassType());
     this.validFrom=new Date();
     this.passType=passBookingRequest.getPassType();
     this.passPrice=passBookingRequest.getPassPrice();
     this.passIssueDate=new Date();
     this.maxLimit=CommonUtil.calculateMaxLimit(passBookingRequest.getPassType());
     this.usedNum=1;
    }
}

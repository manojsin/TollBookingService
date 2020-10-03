package com.hopscotch.tollticketingservice.controller;
import com.hopscotch.tollticketingservice.model.*;
import com.hopscotch.tollticketingservice.service.TollPassBookingService;
import com.hopscotch.tollticketingservice.utils.CommonUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class BookingController {

    private TollPassBookingService passBookingService;

    @Autowired
    public BookingController(TollPassBookingService passBookingService) {
      this.passBookingService=passBookingService;
    }

    @RequestMapping(value = "check/validity",method = RequestMethod.GET)
    @ApiOperation(value = "Check Pass valid Or Not For Registration Number", response = CheckValidityResponse.class)
    public ResponseEntity<?> checkValidity(@RequestParam("vehicleRegNum") String vehicleRegNum,@RequestParam("vehicleType") String vehicleType)
    {
        CheckValidityResponse response=passBookingService.checkValidity(vehicleRegNum,vehicleType);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "get/pass/detail",method = RequestMethod.GET)
    @ApiOperation(value = "Get All Available Pass Details", response = PassDetailResponse.class)
    public ResponseEntity<?> getAllPassDetail(@RequestParam("vehicleType") String vehicleType,@RequestParam("tollId") Long tollId)
    {
        PassDetailResponse response=passBookingService.getAllPassDetails(vehicleType,tollId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "book/toll/pass",method = RequestMethod.POST)
    @ApiOperation(value = "Book Toll Pass", response = PassBookingResponse.class)
    public ResponseEntity<?> bookTollPass(@Valid @RequestBody PassBookingRequest passBookingRequest, BindingResult error)
    {
        CommonUtil.validateRequest(error);
        PassBookingResponse response=passBookingService.issuePass(passBookingRequest);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "get/total/collection",method = RequestMethod.POST)
    @ApiOperation(value = "Get Collection by both Number and Tool Num", response = TotalCollectionResponse.class)
    public ResponseEntity<?> getTotalCollection(@RequestParam("bootId") Long bootId,@RequestParam("tollId") Long tollId)
    {
        TotalCollectionResponse response=passBookingService.getTotalCollection(bootId,tollId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}

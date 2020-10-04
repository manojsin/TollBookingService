package com.hopscotch.tollticketingservice.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hopscotch.tollticketingservice.model.*;
import com.hopscotch.tollticketingservice.service.TollPassBookingService;
import com.hopscotch.tollticketingservice.utils.CommonUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    public BookingController(TollPassBookingService passBookingService) {
      this.passBookingService=passBookingService;
    }

    @RequestMapping(value = "check/validity",method = RequestMethod.GET)
    @ApiOperation(value = "Check Pass valid Or Not For Registration Number", response = CheckValidityResponse.class)
    public ResponseEntity<?> checkValidity(@RequestParam("vehicleRegNum") String vehicleRegNum,@RequestParam("vehicleType") String vehicleType)
    {
        logger.info("Calling checkValidity api where vehicleRegNum : {} and  vehicleType : {}",vehicleRegNum,vehicleType);
        CheckValidityResponse response=passBookingService.checkValidity(vehicleRegNum,vehicleType);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "get/pass/detail",method = RequestMethod.GET)
    @ApiOperation(value = "Get All Available Pass Details", response = PassDetailResponse.class)
    public ResponseEntity<?> getAllPassDetail(@RequestParam("vehicleType") String vehicleType,@RequestParam("tollId") Long tollId) {
        logger.info("Calling getAllPassDetail api where tollId : {} and  vehicleType : {}",tollId,vehicleType);
        PassDetailResponse response=passBookingService.getAllPassDetails(vehicleType,tollId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "book/toll/pass",method = RequestMethod.POST)
    @ApiOperation(value = "Book Toll Pass", response = PassBookingResponse.class)
    public ResponseEntity<?> bookTollPass(@Valid @RequestBody PassBookingRequest passBookingRequest, BindingResult error)  {
        try {
            logger.info("Calling bookTollPass api where passBookingRequest : {} ",new ObjectMapper().writeValueAsString(passBookingRequest));
        } catch (JsonProcessingException e) {
            logger.error("error while parsing");
        }
        CommonUtil.validateRequest(error);
        PassBookingResponse response=passBookingService.issuePass(passBookingRequest);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "get/total/collection",method = RequestMethod.POST)
    @ApiOperation(value = "Get Collection by both Number and Tool Num", response = TotalCollectionResponse.class)
    public ResponseEntity<?> getTotalCollection(@RequestParam("bootId") Long bootId,@RequestParam("tollId") Long tollId) {
        logger.info("Calling getTotalCollection api where tollId : {} and  bootId : {}",tollId,bootId);
        TotalCollectionResponse response=passBookingService.getTotalCollection(bootId,tollId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }
}

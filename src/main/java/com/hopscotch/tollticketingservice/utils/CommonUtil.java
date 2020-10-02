package com.hopscotch.tollticketingservice.utils;

import com.hopscotch.tollticketingservice.exception.RequestInvalidException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.*;

public class CommonUtil {

    //Validate Request
    public static void validateRequest(BindingResult errors){
        // Check validation errors
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            Map<String,String> errorMap = new TreeMap<>();
            for (int i=0 ; i<errorList.size() ; i++) {
                errorMap.put("Parameter:"+i,errorList.get(i).getDefaultMessage());
            }

            throw new RequestInvalidException(errorMap);
        }
    }
    public static Date calculatePassExpiryDate(String passType)
    {
        int day=0;
        if(passType.equalsIgnoreCase("OneWay")||passType.equalsIgnoreCase("TwoWay") ) {
            day=1;
        }
        if(passType.equalsIgnoreCase("Weekly")) {
            day=7;
        }
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, day);
        return c.getTime();
    }
    public static int calculateMaxLimit(String passType)
    {
        int maxCount=0;
        if(passType.equalsIgnoreCase("OneWay") ) {
            maxCount=1;
        }
        if(passType.equalsIgnoreCase("TwoWay")) {
            maxCount=2;
        }
        if(passType.equalsIgnoreCase("Weekly")) {
            maxCount=14;
        }
        return  maxCount;
    }
}

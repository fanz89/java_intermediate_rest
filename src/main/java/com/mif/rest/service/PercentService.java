package com.mif.rest.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class PercentService {

    public String convertPercent(double discount){
        DecimalFormat decimalFormat = new DecimalFormat("##,##%");
        return decimalFormat.format(discount);
    }

}

package com.mif.rest.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class CurrencyService {

    public String currencyUS(double money) {

        DecimalFormat decimalFormat = new DecimalFormat("$#.00");
        return decimalFormat.format(money);
    }

}

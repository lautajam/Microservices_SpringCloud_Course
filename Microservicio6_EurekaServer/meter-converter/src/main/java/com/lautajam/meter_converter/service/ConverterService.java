
package com.lautajam.meter_converter.service;

import org.springframework.stereotype.Service;

@Service
public class ConverterService implements IConvertService{

    @Override
    public Double convertCentimeters(Double meters) {
        return meters*100;
    }
 
}

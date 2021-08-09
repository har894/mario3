package com.example.mario3.service.impl;

import com.example.mario3.entity.Point;
import com.example.mario3.service.ProcessingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProcessingServiceImpl implements ProcessingService {

    @Override
    public Point getPointByDetectedParams(Double angle, Double distance) {

        double angleByRadians = Math.toRadians(angle);

        BigDecimal xPoint = new BigDecimal(distance * Math.cos(angleByRadians)); //TODO implement math part
        BigDecimal yPoint = new BigDecimal(distance * Math.sin(angleByRadians));

        return Point.builder()
                .x(xPoint)
                .y(yPoint)
                .build();
    }

}

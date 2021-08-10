package com.example.mario3.service.impl;

import com.example.mario3.entity.Point;
import com.example.mario3.service.DataStorageServiceUtil;
import com.example.mario3.service.ProcessingService;
import org.springframework.stereotype.Service;


@Service
public class ProcessingServiceImpl implements ProcessingService {

    final DataStorageServiceUtil dataStorageServiceUtil = new DataStorageServiceUtil();
    final Point sensorPoint1 = new Point(6.1, 8.6);
    final Point sensorPoint2 = new Point(2.5, 1.6);

    @Override
    public Point getPointByDetectedParams(Double angle, Double distance, boolean detectorID) {

        double angleByRadians = Math.toRadians(angle);
        Double xPoint;
        Double yPoint;

        Point currentSensor = sensorPoint2;

        if(detectorID) {
            currentSensor=sensorPoint1;
        }

        xPoint = currentSensor.getX() + distance * Math.cos(angleByRadians);
        yPoint = currentSensor.getY() + distance * Math.sin(angleByRadians);

        Point point = Point.builder()
                .x(xPoint)
                .y(yPoint)
                .build();

        DataStorageServiceUtil.storeData(point);

        return point;
    }

}

package com.example.mario3.service;

import com.example.mario3.entity.Point;

public interface ProcessingService {
    Point getPointByDetectedParams(Double angle, Double distance, boolean detectorID);
}

package com.example.mario3.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TargetData {
    private boolean detectorID;
    private Double angle;
    private Double distance;
}

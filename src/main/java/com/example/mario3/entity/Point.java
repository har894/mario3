package com.example.mario3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Point {
    BigDecimal x;
    BigDecimal y;
}

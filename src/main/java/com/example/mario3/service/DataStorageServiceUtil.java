package com.example.mario3.service;

import com.example.mario3.entity.Point;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataStorageServiceUtil {
    private static final List<Point> pointsList = new LinkedList<>();

    public static void storeData(Point pnt) {
        pointsList.add(pnt);
        System.out.println(pointsList);
    }

    private static Double resultDispersion(List<Double> lst) {
        Double averageNumOne = (double) 0;
        Double averageNumTwo = (double) 0;
        for (Double xPoint : lst) {
            averageNumOne += (xPoint * xPoint);
            averageNumTwo += xPoint;
        }
        averageNumOne /= lst.size();
        averageNumTwo = (averageNumTwo / lst.size()) * (averageNumTwo / lst.size());
        return averageNumOne - averageNumTwo;
    }

    public static Point getPointByDispersion() {
        List<Double> x = new ArrayList<>();
        List<Double> y = new ArrayList<>();

        for (Point point : pointsList) {
            x.add(point.getX());
            y.add(point.getY());
        }
        return Point.builder().x(resultDispersion(x)).y(resultDispersion(y)).build();
    }
}

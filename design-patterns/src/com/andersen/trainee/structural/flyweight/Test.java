package com.andersen.trainee.structural.flyweight;

import com.andersen.trainee.structural.decorator.Dev;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        DevFactory devFactory = new DevFactory();

        List<Developer> developers = new ArrayList<>();

        developers.add(devFactory.getDevBySpec("java"));
        developers.add(devFactory.getDevBySpec("javascript"));
        developers.add(devFactory.getDevBySpec("java"));

        developers.stream().forEach(Developer::writeCode);

    }
}

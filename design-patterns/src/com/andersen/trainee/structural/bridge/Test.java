package com.andersen.trainee.structural.bridge;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Creator [] creators = {
                new BankSystem(new JavaDev()),
                new SaleSystem(new JavaScriptDev())
        };

        Arrays.stream(creators)
                .forEach(Creator::create);
    }
}

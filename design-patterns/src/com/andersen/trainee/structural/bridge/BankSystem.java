package com.andersen.trainee.structural.bridge;

public class BankSystem extends Creator{

    protected BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    void create() {
        System.out.println("creating banking system");
        developer.writeCode();
    }
}

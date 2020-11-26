package com.andersen.trainee.structural.bridge;

public class SaleSystem extends Creator{

    protected SaleSystem(Developer developer) {
        super(developer);
    }

    @Override
    void create() {
        System.out.println("creating sales system");
        developer.writeCode();
    }
}

package com.andersen.trainee.structural.decorator;

public class DecoratorDev implements Dev {
    private Dev dev;

    public DecoratorDev(Dev dev) {
        this.dev = dev;
    }

    @Override
    public String doJob() {
        return dev.doJob();
    }
}

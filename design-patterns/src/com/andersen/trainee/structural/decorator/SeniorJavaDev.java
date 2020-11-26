package com.andersen.trainee.structural.decorator;

public class SeniorJavaDev extends DecoratorDev {

    public SeniorJavaDev(Dev dev) {
        super(dev);
    }

    public String betterCode(){
        return "write better code";
    }

    @Override
    public String doJob() {
        return super.doJob() + "\n" + betterCode();
    }
}

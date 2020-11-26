package com.andersen.trainee.structural.decorator;

public class TeamLeadDev extends DecoratorDev {

    public TeamLeadDev(Dev dev) {
        super(dev);
    }

    public String bestCode(){
        return "write the best code";
    }

    @Override
    public String doJob() {
        return super.doJob() + "\n" + bestCode();
    }
}

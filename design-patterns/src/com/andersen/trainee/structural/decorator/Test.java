package com.andersen.trainee.structural.decorator;

public class Test {
    public static void main(String[] args) {
        Dev dev = new TeamLeadDev(new SeniorJavaDev(new JavaDev()));
        System.out.println(dev.doJob());
    }
}

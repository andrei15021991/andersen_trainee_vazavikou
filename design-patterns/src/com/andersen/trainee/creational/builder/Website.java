package com.andersen.trainee.creational.builder;

public class Website {

    private String name;
    private Cms sms;
    private int price;

    public void setName(String name) {
        this.name = name;
    }

    public void setSms(Cms sms) {
        this.sms = sms;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", sms=" + sms +
                ", price=" + price +
                '}';
    }
}

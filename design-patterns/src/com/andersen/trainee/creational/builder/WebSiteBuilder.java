package com.andersen.trainee.creational.builder;

public abstract class WebSiteBuilder {
    private Website website;

    public void createWebsite(){
        website = new Website();
    }

    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();

    public Website getWebsite(){
        return website;
    }
}

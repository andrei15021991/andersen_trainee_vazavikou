package com.andersen.trainee.creational.builder;

public class VisitCardWebsiteBuilder extends WebSiteBuilder {

    @Override
    void buildName() {
        getWebsite().setName("Visit Card");
    }

    @Override
    void buildCms() {
        getWebsite().setSms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        getWebsite().setPrice(500);
    }
}

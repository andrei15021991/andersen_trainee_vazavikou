package com.andersen.trainee.creational.builder;

public class EnterpriseWebsiteBuilder extends  WebSiteBuilder {

    @Override
    void buildName() {
        getWebsite().setName("Enterprise");
    }

    @Override
    void buildCms() {
        getWebsite().setSms(Cms.ALIFRESCO);
    }

    @Override
    void buildPrice() {
        getWebsite().setPrice(10000);
    }
}

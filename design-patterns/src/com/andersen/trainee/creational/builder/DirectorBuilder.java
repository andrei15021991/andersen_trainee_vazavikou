package com.andersen.trainee.creational.builder;

public class DirectorBuilder {
    private WebSiteBuilder webSiteBuilder;

    public Website create(WebSiteBuilder builder){
        builder.createWebsite();

        builder.buildName();
        builder.buildCms();
        builder.buildPrice();

        return builder.getWebsite();
    }
}

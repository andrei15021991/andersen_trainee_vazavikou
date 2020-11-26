package com.andersen.trainee.creational.builder;

public class View {
    public static void main(String[] args) {
        DirectorBuilder builder = new DirectorBuilder();

        Website websiteWordPress = builder.create(new VisitCardWebsiteBuilder());
        Website websiteEnterprise = builder.create(new EnterpriseWebsiteBuilder());

        System.out.println(websiteWordPress.toString());
        System.out.println(websiteEnterprise.toString());
    }
}

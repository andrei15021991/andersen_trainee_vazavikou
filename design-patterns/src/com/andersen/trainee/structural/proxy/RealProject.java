package com.andersen.trainee.structural.proxy;

public class RealProject implements Project {
    private String url;

    public RealProject(String url) {
        this.url = url;

        load();
    }

    @Override
    public void run() {
        System.out.println("running project " + url + " ....");
    }

    private void load() {
        System.out.println("loading project " + url + " ....");
    }
}

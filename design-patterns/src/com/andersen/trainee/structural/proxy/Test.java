package com.andersen.trainee.structural.proxy;

public class Test {
    public static void main(String[] args) {
        Project project = new ProxyProject("http.git.1234455");

        project.run();
    }
}

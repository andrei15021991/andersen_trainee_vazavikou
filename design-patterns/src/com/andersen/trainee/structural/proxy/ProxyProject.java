package com.andersen.trainee.structural.proxy;

public class ProxyProject implements Project {
    private String url;
    private Project project;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (project == null) {
            project = new RealProject(url);
        }

        project.run();
    }
}

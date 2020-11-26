package com.andersen.trainee.creational.prototype;

public class ProjectFactory {
    private Project project;

    public ProjectFactory(Project project) {
        this.project = project;
    }

    public Project createClone(){
        return project;
    }
}

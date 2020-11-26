package com.andersen.trainee.creational.prototype;

public class View {
    public static void main(String[] args) {
        Project project = new Project(1, "first", "source code");
        ProjectFactory projectFactory = new ProjectFactory(project);
        Project clone = projectFactory.createClone();

        System.out.println(project.toString());
        System.out.println(clone.toString());

    }
}

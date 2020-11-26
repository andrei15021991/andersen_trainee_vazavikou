package com.andersen.trainee.behavioral.iterator;

public class TestIterator {
    public static void main(String[] args) {
        String[] skills = {"Java Core,", "Java EE,", "Spring,", "Maven,", "Hibernate,", "MySQL..."};

        JavaDev dev = new JavaDev("Best Programmer", skills);

        DevIterator devIterator = dev.getDevIterator();

        System.out.println("Name is : " + dev.getName());
        System.out.print("Skills are : ");

        while (devIterator.hasNext()){
            System.out.print(devIterator.next().toString() + " ");
        }
    }
}

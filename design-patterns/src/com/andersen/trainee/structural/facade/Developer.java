package com.andersen.trainee.structural.facade;

public class Developer {

    public void writeCode(BugTracker bugTracker){
        if(bugTracker.isStatus()){
            System.out.println("began coding");
        }else{
            System.out.println("checking tasks");
        }
    }
}

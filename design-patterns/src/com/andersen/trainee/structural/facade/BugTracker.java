package com.andersen.trainee.structural.facade;

public class BugTracker {
    private boolean status;

    public void startSprint(){
        System.out.println("sprint started");
        status = true;
    }

    public void finishSprint(){
        System.out.println("sprint finished");
        status = false;
    }

    public boolean isStatus() {
        return status;
    }
}

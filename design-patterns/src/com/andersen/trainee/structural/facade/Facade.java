package com.andersen.trainee.structural.facade;

public class Facade {

    private Job job = new Job();
    private BugTracker bugTracker = new BugTracker();
    private Developer developer = new Developer();

    public void proceed(){
        job.doJob();
        bugTracker.startSprint();
        developer.writeCode(bugTracker);
        bugTracker.finishSprint();
        developer.writeCode(bugTracker);
    }
}

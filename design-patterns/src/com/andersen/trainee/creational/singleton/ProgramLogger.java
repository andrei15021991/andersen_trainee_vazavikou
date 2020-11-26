package com.andersen.trainee.creational.singleton;

public class ProgramLogger {

    private static final ProgramLogger instance = new ProgramLogger();
    private String logList = "";

    private ProgramLogger(){

    }

    public static ProgramLogger getProgramLogger(){
        return instance;
    }

    public void addLog(String newLog){
        logList += newLog + "\n";
    }

    public void showLogList(){
        System.out.println(logList);
    }
}

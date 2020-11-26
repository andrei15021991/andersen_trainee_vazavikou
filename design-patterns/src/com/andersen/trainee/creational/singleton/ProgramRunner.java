package com.andersen.trainee.creational.singleton;

public class ProgramRunner {
    public static void main(String[] args) {
        ProgramLogger.getProgramLogger().addLog("how are you");
        ProgramLogger.getProgramLogger().addLog("i'm fine");

        ProgramLogger.getProgramLogger().showLogList();
    }
}

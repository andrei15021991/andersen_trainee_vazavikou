package com.andersen.trainee.behavioral.command;

public class ReadCommand implements Command {
    private DataBase dataBase;

    public ReadCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.read();
    }
}

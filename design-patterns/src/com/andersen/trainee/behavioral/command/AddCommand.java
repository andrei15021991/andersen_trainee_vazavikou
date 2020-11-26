package com.andersen.trainee.behavioral.command;

public class AddCommand implements Command {
    private DataBase dataBase;

    public AddCommand(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void execute() {
        dataBase.add();
    }
}

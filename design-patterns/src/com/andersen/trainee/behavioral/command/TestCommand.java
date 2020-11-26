package com.andersen.trainee.behavioral.command;

public class TestCommand {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();

        Developer developer = new Developer(new AddCommand(dataBase),
                new DeleteCommand(dataBase),
                new UpdateCommand(dataBase),
                new ReadCommand(dataBase));

        developer.addRecord();
        developer.updateRecord();
        developer.readRecord();
        developer.deleteRecord();
    }
}

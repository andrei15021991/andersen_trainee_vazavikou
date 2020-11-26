package com.andersen.trainee.behavioral.command;

public class Developer {
    private Command add;
    private Command delete;
    private Command update;
    private Command read;

    public Developer(Command add, Command delete, Command update, Command read) {
        this.add = add;
        this.delete = delete;
        this.update = update;
        this.read = read;
    }

    public void addRecord() {
        add.execute();
    }

    public void deleteRecord() {
        delete.execute();
    }

    public void updateRecord() {
        update.execute();
    }

    public void readRecord() {
        read.execute();
    }
}

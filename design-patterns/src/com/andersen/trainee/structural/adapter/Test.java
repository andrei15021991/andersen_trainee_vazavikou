package com.andersen.trainee.structural.adapter;

public class Test {
    public static void main(String[] args) {
        DB db = new JavaDBRunnerAdapter();

        db.select();
        db.delete();
        db.insert();
        db.update();
    }
}

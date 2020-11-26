package com.andersen.trainee.structural.adapter;

public class JavaDBRunnerAdapter extends JavaDBRunner implements DB {
    @Override
    public void select() {
        get();
    }

    @Override
    public void delete() {
        remove();
    }

    @Override
    public void update() {
        change();
    }

    @Override
    public void insert() {
        add();
    }
}

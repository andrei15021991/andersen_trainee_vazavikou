package com.andersen.trainee.structural.bridge;

public abstract class Creator {
    protected Developer developer;

    protected Creator(Developer developer){
        this.developer = developer;
    }

    abstract void create();
}

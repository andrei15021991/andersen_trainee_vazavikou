package com.andersen.trainee.creational.factory.impl;

import com.andersen.trainee.creational.factory.Developer;

public class JavaScriptDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("writing javascript code");
    }
}

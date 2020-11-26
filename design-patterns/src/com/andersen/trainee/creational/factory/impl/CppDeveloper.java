package com.andersen.trainee.creational.factory.impl;

import com.andersen.trainee.creational.factory.Developer;

public class CppDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("writing C++ code");
    }
}

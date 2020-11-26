package com.andersen.trainee.creational.absract_factory.banking;

import com.andersen.trainee.creational.absract_factory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("developer is writing java code");
    }
}

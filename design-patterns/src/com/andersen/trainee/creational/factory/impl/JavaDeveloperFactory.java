package com.andersen.trainee.creational.factory.impl;

import com.andersen.trainee.creational.factory.Developer;
import com.andersen.trainee.creational.factory.DeveloperFactory;

public class JavaDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaDeveloper();
    }
}

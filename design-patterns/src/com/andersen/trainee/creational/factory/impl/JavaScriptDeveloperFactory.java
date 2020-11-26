package com.andersen.trainee.creational.factory.impl;

import com.andersen.trainee.creational.factory.Developer;
import com.andersen.trainee.creational.factory.DeveloperFactory;

public class JavaScriptDeveloperFactory implements DeveloperFactory {
    @Override
    public Developer createDeveloper() {
        return new JavaScriptDeveloper();
    }
}

package com.andersen.trainee.creational.absract_factory.banking;

import com.andersen.trainee.creational.absract_factory.ProjectManager;

public class PM implements ProjectManager {
    @Override
    public void manage() {
        System.out.println("PM is managing the project");
    }
}

package com.andersen.trainee.creational.absract_factory.banking;

import com.andersen.trainee.creational.absract_factory.CreateTeamFactory;
import com.andersen.trainee.creational.absract_factory.Developer;
import com.andersen.trainee.creational.absract_factory.ProjectManager;
import com.andersen.trainee.creational.absract_factory.Tester;

public class BankingTeam implements CreateTeamFactory {
    @Override
    public Developer getDev() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getPM() {
        return new PM();
    }
}

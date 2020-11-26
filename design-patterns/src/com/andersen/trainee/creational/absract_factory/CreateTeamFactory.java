package com.andersen.trainee.creational.absract_factory;

public interface CreateTeamFactory {
    Developer getDev();
    Tester getTester();
    ProjectManager getPM();
}

package com.andersen.trainee.creational.absract_factory;

import com.andersen.trainee.creational.absract_factory.banking.BankingTeam;

public class View {
    public static void main(String[] args) {
        CreateTeamFactory createTeamFactory = new BankingTeam();

        Developer developer = createTeamFactory.getDev();
        Tester tester = createTeamFactory.getTester();
        ProjectManager projectManager = createTeamFactory.getPM();

        developer.writeCode();
        tester.test();
        projectManager.manage();
    }
}

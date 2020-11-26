package com.andersen.trainee.structural.composite;

public class Test {
    public static void main(String[] args) {
        Team team = new Team();

        Developer javaDeveloper = new JavaDev();
        Developer javascriptDeveloper = new JavaScriptDev();

        team.addDev(javaDeveloper);
        team.addDev(javascriptDeveloper);

        team.createTeam();
    }
}

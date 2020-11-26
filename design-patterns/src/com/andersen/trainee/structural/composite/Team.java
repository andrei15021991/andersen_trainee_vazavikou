package com.andersen.trainee.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Developer> developers;

    public Team(){
        developers = new ArrayList<>();
    }

    public void addDev(Developer developer){
        developers.add(developer);
    }

    public void removeDev(Developer developer){
        developers.remove(developer);
    }

    public void createTeam(){
        developers.stream()
                .forEach(Developer::writeCode);
    }
}

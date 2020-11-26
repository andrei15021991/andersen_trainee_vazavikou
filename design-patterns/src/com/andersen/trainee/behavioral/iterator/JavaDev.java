package com.andersen.trainee.behavioral.iterator;

import java.util.Objects;

public class JavaDev implements ItCollection {
    private String name;
    private String[] skills;

    public JavaDev(String name, String[] skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    @Override
    public DevIterator getDevIterator() {
        return new skillIterator();
    }

    private class skillIterator implements DevIterator {
        int x;

        @Override
        public boolean hasNext() {
            if (x < skills.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return skills[x++];
        }
    }
}

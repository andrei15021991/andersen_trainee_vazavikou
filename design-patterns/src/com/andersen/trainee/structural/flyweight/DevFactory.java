package com.andersen.trainee.structural.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DevFactory {
    private static final Map<String, Developer> DEVELOPERS = new HashMap<>();

    public Developer getDevBySpec(String spec) {
        Developer dev = DEVELOPERS.get(spec);

        if (Objects.isNull(dev)) {
            switch (spec) {
                case "java":
                    System.out.println("java dev");
                    dev = new JavaDev();
                    break;
                case "javascript":
                    System.out.println("javascript dev");
                    dev = new JavaScriptDev();
                    break;
            }
            DEVELOPERS.put(spec, dev);
        }
        return dev;
    }
}

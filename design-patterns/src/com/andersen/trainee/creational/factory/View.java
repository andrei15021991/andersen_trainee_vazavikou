package com.andersen.trainee.creational.factory;

import com.andersen.trainee.creational.factory.impl.CppDeveloperFactory;
import com.andersen.trainee.creational.factory.impl.JavaDeveloperFactory;
import com.andersen.trainee.creational.factory.impl.JavaScriptDeveloperFactory;

public class View {
    public static void main(String[] args) {
        DeveloperFactory developerFactory = createDevBySpec("javascript");
        Developer developer = developerFactory.createDeveloper();
        developer.writeCode();

    }

    private static DeveloperFactory createDevBySpec(String name){

        if(name.equalsIgnoreCase("java")){
            return new JavaDeveloperFactory();
        }else if(name.equalsIgnoreCase("c++")){
            return new CppDeveloperFactory();
        }else if(name.equalsIgnoreCase("javascript")){
            return new JavaScriptDeveloperFactory();
        }else{
            throw new RuntimeException("unknown developer");
        }
    }
}

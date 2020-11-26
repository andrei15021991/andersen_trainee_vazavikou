package com.andersen.trainee.behavioral.interpreter;

public class Test {
    public static void main(String[] args) {
        Expression isJavaDev = javaDev();
        Expression isJavaEEDev = javaEEDev();

        System.out.println(isJavaDev.interpret("Java"));
        System.out.println(isJavaEEDev.interpret("Java Spring"));

    }

    public static Expression javaDev() {
        Expression java = new TerminalExpression("Java");
        Expression javaCore = new TerminalExpression("Java Core");

        return new ANDExpression(java, javaCore);
    }

    public static Expression javaEEDev(){
        Expression java = new TerminalExpression("Java Core");
        Expression spring = new TerminalExpression("Java Spring");

        return new ORExpression(java, spring);
    }
}

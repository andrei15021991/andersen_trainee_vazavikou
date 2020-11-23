package com.andersen_trainee.some_logic;

public class MathOp {
    private SomeService service;

    public MathOp(SomeService service) {
        this.service = service;
    }

    public int add(int a, int b) {
        return service.perform(a, b);
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int dev(int a, int b) {
        return a / b;
    }

    public int mult(int a, int b) {
        return a * b;
    }
}

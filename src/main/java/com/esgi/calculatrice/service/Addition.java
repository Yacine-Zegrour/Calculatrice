package com.esgi.calculatrice.service;

public class Addition implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }

    @Override
    public String getName() {
        return "addition";
    }
}

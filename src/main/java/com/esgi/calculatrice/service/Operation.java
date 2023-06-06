package com.esgi.calculatrice.service;

public interface Operation {
    double execute(double a, double b);
    String getName();
}

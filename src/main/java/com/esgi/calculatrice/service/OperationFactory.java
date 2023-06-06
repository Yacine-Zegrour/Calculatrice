package com.esgi.calculatrice.service;

public class OperationFactory {
    public static Operation getOperation(String opSymbol) {
        switch (opSymbol) {
            case "+":
                return new Addition();
            // case "-": return new Subtraction();
            // case "*": return new Multiplication();
            default:
                return null;
        }
    }
}

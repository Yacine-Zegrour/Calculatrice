package com.esgi.calculatrice.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Calculator {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("Usage: java Calculator <filename> <+|-|*> [-log]");
            System.exit(1);
        }

        String filename = args[0];
        String opSymbol = args[1];
        boolean logging = args.length > 2 && args[2].equalsIgnoreCase("-log");

        Logger logger = new Logger(logging);
        java.io.FileReader fileReader = new FileReader();
        List<Double> numbers = fileReader.readFile(filename);

        Operation operation = OperationFactory.getOperation(opSymbol);
        if (operation == null) {
            System.err.println("Invalid operation: " + opSymbol);
            System.exit(1);
        }

        double result = numbers.get(0);
        logger.log("started");
        logger.log("applying operation " + operation.getName());
        for (int i = 1; i < numbers.size(); i++) {
            logger.log("parsed value = " + numbers.get(i));
            result = operation.execute(result, numbers.get(i));
            System.out.println((opSymbol.equals("+") ? "" : opSymbol) + numbers.get(i) + " = " + result);
            logger.log("accumulation : " + result + " on line " + (i + 1));
        }
        System.out.println("-------");
        System.out.println("Total = " + result);
        logger.log("end of program");
    }

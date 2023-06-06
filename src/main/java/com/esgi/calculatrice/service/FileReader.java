package com.esgi.calculatrice.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    List<Double> readFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        List<Double> numbers = new ArrayList<>();
        for (String line : lines) {
            numbers.add(Double.parseDouble(line));
        }
        return numbers;
    }
}
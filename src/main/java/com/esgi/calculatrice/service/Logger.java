package com.esgi.calculatrice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private boolean logging;
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HHmmss:SSSSSS");

    Logger(boolean logging) {
        this.logging = logging;
    }

    void log(String message) {
        if (logging) {
            String timestamp = LocalDateTime.now().format(dateTimeFormatter);
            System.out.println("[" + timestamp + "][log] " + message);
        }
    }
}
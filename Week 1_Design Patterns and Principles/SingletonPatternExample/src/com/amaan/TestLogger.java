package com.amaan;

public class TestLogger {

    public static void test() {

        Logger instance1 = Logger.getInstance();
        Logger instance2 = Logger.getInstance();
        if (instance1 == instance2) {
            System.out.println("Both loggers are the same instance which follows a Singleton pattern");
        } else {
            System.out.println("Singleton pattern is failed");
        }
        instance1.logMessage("This is a log message");
    }
}

package com.amaan;


public class Logger {

    //Singleton Pattern with lazy initialization
    //private static instance
    private static Logger instance;

    //private constructor
    private Logger() {
    }

    //public static method to create instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    //method to print some log message
    public void logMessage(String message) {
        System.out.println("Message: " + message);
    }
}

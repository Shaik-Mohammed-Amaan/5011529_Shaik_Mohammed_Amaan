package com.amaan;

public class EmailNotifier implements Notifier {

    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

package com.amaan;

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }
    public void send(String message){
        super.send(message);
        System.out.println("Sending slack notification: "+message);
    }
}

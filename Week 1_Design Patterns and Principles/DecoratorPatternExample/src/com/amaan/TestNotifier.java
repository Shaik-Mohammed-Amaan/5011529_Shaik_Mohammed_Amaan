package com.amaan;

public class TestNotifier {
    public static void test() {

        Notifier notifier = new SMSNotifierDecorator(new SlackNotifierDecorator(new EmailNotifier()));
        notifier.send("Your order has been dispatched");

    }
}

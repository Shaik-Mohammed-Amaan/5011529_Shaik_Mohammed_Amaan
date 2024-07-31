package com.amaan;

public class TestCommand {
    public static void test(){

        RemoteControl rc = new RemoteControl();
        rc.setRemoteControl(new LightOnCommand(new Light("Living Room")));
        rc.executeCommand();
        rc.setRemoteControl(new LightOffCommand(new Light("Living Room")));
        rc.executeCommand();
        rc.setRemoteControl(new LightOnCommand(new Light("Kitchen")));
        rc.executeCommand();
        rc.setRemoteControl(new LightOffCommand(new Light("Kitchen")));
        rc.executeCommand();
    }
}

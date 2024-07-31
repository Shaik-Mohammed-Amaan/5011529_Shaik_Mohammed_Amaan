package com.amaan;

public class RemoteControl {
    private Command command;
    public void setRemoteControl(Command command){
        this.command = command;
    }
    public void executeCommand(){
        command.execute();
    }
}

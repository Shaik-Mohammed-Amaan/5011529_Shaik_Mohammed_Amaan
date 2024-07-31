package com.amaan;

public class Light {
    private String room;
    public Light(String room){
        this.room = room;
    }
    public void turnOnLight(){
        System.out.println(room+" light is turned on.");
    }
    public void turnOffLight(){
        System.out.println(room+" light is turned off.");
    }
}

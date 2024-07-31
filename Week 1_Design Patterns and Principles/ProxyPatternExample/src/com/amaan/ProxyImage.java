package com.amaan;

public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void loadFromRemoteServer() {
        System.out.println("Loading image from remote server...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(this.fileName);
            loadFromRemoteServer();
        }
        else{
            System.out.println("Image retrieved from Cache without reloading");
        }
        realImage.display();
    }
}

package com.amaan;

public class Computer {

    //Required attributes
    private String cpu;
    private String ram;
    private String storage;

    //Optional attributes
    private String graphicsCard;
    private boolean isWifiAvailable;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.isWifiAvailable = builder.isWifiAvailable;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public boolean isWifiAvailable() {
        return isWifiAvailable;
    }

    //Builder Class
    public static class ComputerBuilder {
        //Required attributes
        private String cpu;
        private String ram;
        private String storage;

        //Optional attributes
        private String graphicsCard;
        private boolean isWifiAvailable;

        //Constructor to set required attributes
        public ComputerBuilder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        //setter methods to set optional attributes
        public ComputerBuilder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public ComputerBuilder setisWifiAvailable(boolean iswifiAvailable) {
            this.isWifiAvailable = iswifiAvailable;
            return this;
        }

        //Build method
        public Computer build() {
            return new Computer(this);
        }

    }
}

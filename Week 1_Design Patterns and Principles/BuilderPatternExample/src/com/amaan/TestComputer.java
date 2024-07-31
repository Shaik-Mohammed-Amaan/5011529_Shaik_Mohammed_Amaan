package com.amaan;

public class TestComputer {
    public static void test() {
        Computer com1 = new Computer.ComputerBuilder("Intel i5", "8 GB", "512 GB SSD").
                setGraphicsCard("RTX 3060").setisWifiAvailable(true).build();
        Computer com2 = new Computer.ComputerBuilder("Intel i3", "4 GB", "1 TB HDD").build();
        System.out.println("First computer specifications:");
        System.out.println("CPU: " + com1.getCpu());
        System.out.println("Ram: " + com1.getRam());
        System.out.println("Storage: " + com1.getStorage());
        System.out.println("Graphics card: " + com1.getGraphicsCard());
        System.out.println("Wifi Available: "+com1.isWifiAvailable());
        System.out.println();
        System.out.println("Second computer specifications:");
        System.out.println("CPU: " + com2.getCpu());
        System.out.println("Ram: " + com2.getRam());
        System.out.println("Storage: " + com2.getStorage());

    }
}

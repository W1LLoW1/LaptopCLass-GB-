package org.example.hw6;

public class Laptop {
    String brand;
    String os;
    String color;
    int ram;
    String cpu;
    int rom;

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", ram=" + ram +
                ", cpu='" + cpu + '\'' +
                ", rom=" + rom +
                '}';
    }
}

package org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles;

import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.DriveStrategy;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.NormalDrive;

public class Truck extends Vehicle{
    String brand;
    String model;
    int totalTyres;

    public Truck(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }

}

package org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles;

import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.DriveStrategy;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.NormalDrive;

public class Bike extends Vehicle {

    String brand;
    String model;
    Boolean isSportsMode;

    public Bike(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }
}

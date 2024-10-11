package org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles;

import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.DriveStrategy;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.SportsDrive;

public class Car extends Vehicle {
    String brand;
    String model;
    String transmissionType;
    Boolean isSportsMode;

    public Car(DriveStrategy driveStrategy) {
        super(driveStrategy);
    }

}

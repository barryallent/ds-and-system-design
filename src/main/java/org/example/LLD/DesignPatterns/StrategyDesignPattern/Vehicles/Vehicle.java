package org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles;

import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy=driveStrategy;
    }
    public void drive() {
        driveStrategy.drive();
    };
}

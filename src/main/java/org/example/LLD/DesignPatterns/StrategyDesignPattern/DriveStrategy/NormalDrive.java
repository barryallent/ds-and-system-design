package org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy;

public class NormalDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("normal drive");
    }
}

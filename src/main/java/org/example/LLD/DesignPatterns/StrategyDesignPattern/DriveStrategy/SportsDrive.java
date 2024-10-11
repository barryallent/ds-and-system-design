package org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy;

public class SportsDrive implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("sports drive");
    }
}

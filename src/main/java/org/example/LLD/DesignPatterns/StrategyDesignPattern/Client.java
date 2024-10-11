package org.example.LLD.DesignPatterns.StrategyDesignPattern;

import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.NormalDrive;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.DriveStrategy.SportsDrive;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles.Bike;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles.Car;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles.Truck;
import org.example.LLD.DesignPatterns.StrategyDesignPattern.Vehicles.Vehicle;

public class Client {
    public static void main(String[] args) {

        //creating car, bike and truck and both calling drive method.
        //bike and truck both have implemented same normal drive function, which we kept only at one place
        //so no code repeat. If a new vehicle type comes that has to implement same normal drive and sports drive
        //then no need to re-write and we have it in one place that is normaldrive and sportsdrive
        //if any new drive strategy we need to add then that also we can add.
        Vehicle v1 = new Car(new SportsDrive());
        v1.drive();

        Vehicle v2 = new Bike(new NormalDrive());
        v2.drive();

        Vehicle v3  = new Truck(new NormalDrive());
        v3.drive();


        //so strategy design pattern is used when both different child classes have same code
        //so there is code repeat and we can avoid it by keep the logic at same place, and define method in base class
        //only and based on object received in constructor we can call the different implementation of function
    }
}

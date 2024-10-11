package org.example.LLD.Designs.CarRentalSystem.Vehicles;

import lombok.Builder;
import lombok.Data;
import org.example.LLD.Designs.CarRentalSystem.Store.Location;
import org.example.LLD.Designs.CarRentalSystem.Store.Store;

@Data
public class Vehicle {
    int id;
    String model;
    String brand;
    int kmDriven;
    public int seatingCapacity;
    String vehicleNumber;
    public VehicleStatus vehicleStatus;
    Store store;
    Location location;
}

package org.example.LLD.Designs.CarRentalSystem.Managers;

import org.example.LLD.Designs.CarRentalSystem.Vehicles.VehicleStatus;
import org.example.LLD.Designs.CarRentalSystem.Vehicles.Vehicle;

import java.util.List;

public interface VehicleInventoryManager {

    void addVehicle(Vehicle v1);

    Boolean changeVehicleStatus(Vehicle v1, VehicleStatus vehicleStatus);

    List<Vehicle> findVehicle(Vehicle v1);
    void setVehicles(List<Vehicle> vehicles);
}

package org.example.LLD.Designs.CarRentalSystem.Managers;

import org.example.LLD.Designs.CarRentalSystem.Vehicles.VehicleStatus;
import org.example.LLD.Designs.CarRentalSystem.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class CarInventoryManager implements VehicleInventoryManager {
    List<Vehicle> vehicles;
    @Override
    public void addVehicle(Vehicle v1){
        vehicles.add(v1);
        //save to DB
    }

    @Override
    public void setVehicles(List<Vehicle> vehicles) {
        //add vehicles to DB
    }

    @Override
    public Boolean changeVehicleStatus(Vehicle v1, VehicleStatus vehicleStatus){

        v1.vehicleStatus=vehicleStatus;

        //save to DB
        return true;
    }
    @Override
    public List<Vehicle> findVehicle(Vehicle v1) {
        //find from DB based on filter
        int seatingCapacity=v1.seatingCapacity;

        Vehicle vehicle=new Vehicle();
        List<Vehicle> vehicles=new ArrayList<>();
        return vehicles;
    }

}

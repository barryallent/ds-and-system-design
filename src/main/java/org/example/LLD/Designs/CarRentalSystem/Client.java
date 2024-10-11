package org.example.LLD.Designs.CarRentalSystem;

import java.util.ArrayList;
import java.util.List;

import org.example.LLD.Designs.CarRentalSystem.Managers.CarInventoryManager;
import org.example.LLD.Designs.CarRentalSystem.Managers.VehicleInventoryManager;
import org.example.LLD.Designs.CarRentalSystem.Managers.VehicleRentalSystem;
import org.example.LLD.Designs.CarRentalSystem.Payment.Bill;
import org.example.LLD.Designs.CarRentalSystem.Payment.Payment;
import org.example.LLD.Designs.CarRentalSystem.Store.Location;
import org.example.LLD.Designs.CarRentalSystem.Store.Reservation;
import org.example.LLD.Designs.CarRentalSystem.Store.Store;
import org.example.LLD.Designs.CarRentalSystem.User.User;
import org.example.LLD.Designs.CarRentalSystem.Vehicles.Car;
import org.example.LLD.Designs.CarRentalSystem.Vehicles.Vehicle;

public class Client {
    public static void main(String args[]) {

        //some runtime errors in this due to null and all
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = Location.builder()
                .state("Karnataka")
                .city("Bangalore")
                .pinCode("560048")
                .build();
        List<Store> stores1 = rentalSystem.findStoreByLocation(location);
        Store store=stores1.get(0);

        //2. get All vehicles you are interested in (based upon different filters)
        Vehicle vehicleToFind = new Vehicle();
        vehicleToFind.setSeatingCapacity(7);
        List<Vehicle> storeVehicles = store.getVehicles(vehicleToFind);


        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(users.get(0),storeVehicles.get(0));

        //4. generate the bill
        Bill bill = Bill.builder()
                .reservation(reservation)
                .build();

        //5. make payment
        Payment payment = new Payment(bill);
        payment.payBill();

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation);

    }



    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setSeatingCapacity(7);

        Vehicle vehicle2 = new Car();
        vehicle1.setSeatingCapacity(4);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = User.builder()
                .id(1)
                .build();

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();
        VehicleInventoryManager vehicleInventoryManager = new CarInventoryManager();
        Store store1 = Store.builder()
                .vehicleInventoryManager(vehicleInventoryManager)
                .build();
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }
}

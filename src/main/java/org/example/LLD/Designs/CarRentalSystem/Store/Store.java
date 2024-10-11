package org.example.LLD.Designs.CarRentalSystem.Store;

import lombok.Builder;
import lombok.Data;
import org.example.LLD.Designs.CarRentalSystem.User.User;
import org.example.LLD.Designs.CarRentalSystem.Managers.VehicleInventoryManager;
import org.example.LLD.Designs.CarRentalSystem.Vehicles.Vehicle;

import java.util.List;
@Builder
@Data
public class Store {
    VehicleInventoryManager vehicleInventoryManager;
    List<Reservation> reservations;
    Location location;

    public List<Vehicle> getVehicles(Vehicle v1) {
        return vehicleInventoryManager.findVehicle(v1);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManager.setVehicles(vehicles);
    }

    public Reservation createReservation(User user, Vehicle vehicle) {
        Reservation reservation = Reservation.builder()
                .user(user)
                .vehicle(vehicle)
                .build();
        return reservation;
    }
    public void completeReservation(Reservation reservation) {
        reservation.reservationStatus=ReservationStatus.COMPLETED;
    }

}

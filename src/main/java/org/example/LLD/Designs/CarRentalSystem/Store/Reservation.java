package org.example.LLD.Designs.CarRentalSystem.Store;

import lombok.Builder;
import org.example.LLD.Designs.CarRentalSystem.User.User;
import org.example.LLD.Designs.CarRentalSystem.Vehicles.Vehicle;

import java.util.Date;
import java.util.UUID;

@Builder
public class Reservation {
    UUID id;
    User user;
    Vehicle vehicle;
    ReservationStatus reservationStatus;
    Date bookingdate;
    Date bookingFrom;
    Date bookingTill;
    Store store;
}

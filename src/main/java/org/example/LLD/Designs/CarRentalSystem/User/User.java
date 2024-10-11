package org.example.LLD.Designs.CarRentalSystem.User;

import lombok.Builder;

@Builder
public class User {
    int id;
    String drivingLicense;
    String userName;
    String email;
    String phoneNumber;
}

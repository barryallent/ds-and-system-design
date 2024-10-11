package org.example.LLD.Designs.CarRentalSystem.Store;

import lombok.Builder;

@Builder
public class Location {
    String city;
    String state;
    String country;
    String pinCode;
    String latitude;
    String longitude;

}

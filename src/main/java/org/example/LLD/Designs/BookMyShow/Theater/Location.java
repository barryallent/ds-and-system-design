package org.example.LLD.Designs.BookMyShow.Theater;

import lombok.Builder;

@Builder
public class Location {
    String city;
    String State;

    public Location(String city, String state, String address) {
        this.city = city;
        State = state;
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String address;

}

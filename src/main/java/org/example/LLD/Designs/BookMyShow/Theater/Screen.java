package org.example.LLD.Designs.BookMyShow.Theater;

import org.example.LLD.Designs.BookMyShow.Theater.Seat;

import java.util.List;

public class Screen {
    int screenId;
    List<Seat> seats;

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}

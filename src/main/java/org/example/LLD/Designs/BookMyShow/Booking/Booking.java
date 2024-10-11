package org.example.LLD.Designs.BookMyShow.Booking;

import lombok.Builder;
import org.example.LLD.Designs.BookMyShow.Movie.Show;
import org.example.LLD.Designs.BookMyShow.Theater.Seat;

import java.util.List;
import java.util.UUID;

@Builder
public class Booking {
    int bookingId;
    int priceOfBooking;
    int userId;


    Show show;

    List<Seat> bookedSeats;

    public int getPriceOfBooking() {
        return priceOfBooking;
    }

    public void setPriceOfBooking(int priceOfBooking) {
        this.priceOfBooking = priceOfBooking;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

}

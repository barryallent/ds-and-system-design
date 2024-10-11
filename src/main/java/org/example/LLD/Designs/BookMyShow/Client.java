package org.example.LLD.Designs.BookMyShow;


import org.example.LLD.Designs.BookMyShow.Booking.Booking;
import org.example.LLD.Designs.BookMyShow.Theater.Location;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        Location location = Location.builder()
                .city("Delhi")
                .build();

        ZoneId zoneId = ZoneId.of("UTC");

        Date movieStartTime = Date.from(LocalDateTime.of(2024, 6, 19, 11, 0).atZone(zoneId).toInstant());

        Booking booking1 = bookMyShow.createBooking(location,"Furiosa", movieStartTime, 30);

        Booking booking2 = bookMyShow.createBooking(location,"Deadpool", movieStartTime, 30);

    }
}

package org.example.LLD.Designs.BookMyShow.Movie;

import lombok.Builder;
import org.example.LLD.Designs.BookMyShow.Theater.Screen;
import org.example.LLD.Designs.BookMyShow.Theater.Seat;
import org.example.LLD.Designs.BookMyShow.Theater.Theater;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
public class Show {
    int showId;
    Movie movie;
    Theater theater;
    Screen screen;
    Date showStartTime;
    List<Seat> bookedSeats = new ArrayList<>();

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Date getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(Date showStartTime) {
        this.showStartTime = showStartTime;
    }

    public List<Seat> getBookedSeatIds() {
        return bookedSeats;
    }

    public void setBookedSeatIds(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}

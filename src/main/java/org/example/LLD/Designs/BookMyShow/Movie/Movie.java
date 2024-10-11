package org.example.LLD.Designs.BookMyShow.Movie;

import org.example.LLD.Designs.BookMyShow.Theater.Theater;

public class Movie extends Event {
    int eventId;
    String movieTitle;
    int durationInMinutes;

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Movie(String movieTitle, int durationInMinutes) {
        this.movieTitle = movieTitle;
        this.durationInMinutes = durationInMinutes;
    }
}

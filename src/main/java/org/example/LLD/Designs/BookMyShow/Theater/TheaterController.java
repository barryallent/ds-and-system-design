package org.example.LLD.Designs.BookMyShow.Theater;

import org.example.LLD.Designs.BookMyShow.Movie.Movie;
import org.example.LLD.Designs.BookMyShow.Movie.Show;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TheaterController {

    Map<Location, List<Theater>> theaterByLocation;
    List<Theater> theaters;

    List<Theater> getTheaterByLocation(Location location) {
        //logic to get theaters from DB based on location filter;
        return theaters;
    }
    public void addTheater(Theater theater) {
        //logic to add theater to DB
    }
    public void removeTheater(Theater theater) {
        //logic to remove theater to DB
    }


    public List<Show> getAllShow(Movie movie, Location location) {
        //get all Theaters from theater DB, based on location filter

        //Get shows for a movie based on theater filter.
        List<Show> shows=new ArrayList<>();
        return shows;

    }

}

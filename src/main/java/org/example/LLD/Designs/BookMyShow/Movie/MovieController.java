package org.example.LLD.Designs.BookMyShow.Movie;

import org.example.LLD.Designs.BookMyShow.Theater.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<Location, List<Movie>> moviesByLocation = new HashMap<>();

    List<Movie> allMovies = new ArrayList<>();
//    List<Movie> allMovies = new ArrayList<>();
    public void addMovies(Movie movie) {
        allMovies.add(movie);
        //add movies to Movie DB logic
    }

    public List<Movie> getMovieByLocation(Location location) {
        //fetch from movie DB based on location filter and store in moviesByLocation map
        return moviesByLocation.get(location);
    }

    public Movie findMovieByName(String moviename) {
        //fetch from movie DB based on location filter and store in moviesByLocation map
        // but currently using local variable
        for(Movie movie1:allMovies) {
            if(movie1.getMovieTitle().equalsIgnoreCase(moviename)) {
                return movie1;
            }
        }
        return null;
    }
   public Boolean removeMovie() {
        //logic to remove movie from DB
       return true;
    }
}

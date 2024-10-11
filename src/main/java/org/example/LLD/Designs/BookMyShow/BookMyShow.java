package org.example.LLD.Designs.BookMyShow;

import lombok.extern.java.Log;
import org.example.LLD.Designs.BookMyShow.Booking.Booking;
import org.example.LLD.Designs.BookMyShow.Movie.Movie;
import org.example.LLD.Designs.BookMyShow.Movie.MovieController;
import org.example.LLD.Designs.BookMyShow.Movie.Show;
import org.example.LLD.Designs.BookMyShow.Theater.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    public BookMyShow() {
        movieController = new MovieController();
        theaterController = new TheaterController();
    }


    public void initialize() {
        createMovies();
        createTheater();
    }

    Booking createBooking(Location location, String movieName, Date showStartTime, int seatNumber) {

        List<Movie> moviesInCitymovieController = movieController.getMovieByLocation(location);
        Movie movieToWatch = null;
        Logger logger
                = Logger.getLogger(
                BookMyShow.class.getName());

        for (Movie movie : moviesInCitymovieController) {
            if (movie.getMovieTitle().equalsIgnoreCase(movieName)) {
                movieToWatch = movie;
            }
        }
        if (movieToWatch == null) {
                logger.info("Movie " + movieName + " not found in City: " + location.getCity());
                return null;
        }

        List<Show> allShows = theaterController.getAllShow(movieToWatch, location);
        Show showToBook = null;
        for (Show show : allShows) {
            if (show.getShowStartTime().equals(showStartTime)) {
                    showToBook = show;
            }
        }

        List<Seat> bookedSeats = showToBook.getBookedSeatIds();

        List<Seat> allseats = showToBook.getScreen().getSeats();

        Seat seatToBook = null;

        for(Seat seat:bookedSeats) {
            if(seat.getSeatNumber()==seatNumber) {
               // throw exception
                logger.info("seat already booked, try again");
                return null;
            }
        }

        for(Seat seat:allseats) {
            if(seat.getSeatNumber()==seatNumber) {
                seatToBook=seat;
            }
        }


        Booking booking = Booking.builder()
                .show(showToBook)
                .show(showToBook)
                .priceOfBooking(400)
                .bookedSeats((List<Seat>) seatToBook)
                .build();

        return booking;

    }

    void createMovies() {
        Movie movie1 = new Movie("Furiosa",140);
        Movie movie2 = new Movie("Deadpool",120);
        movieController.addMovies(movie1);
        movieController.addMovies(movie1);
    }

    List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();
        for(int i=1;i<30;i++) {
            Seat seat = new Seat();
            seat.setSeatType(SeatType.SILVER);
            seats.add(seat);
        }
        for(int i=1;i<30;i++) {
            Seat seat = new Seat();
            seat.setSeatType(SeatType.GOLD);
            seats.add(seat);
        }
        for(int i=1;i<30;i++) {
            Seat seat = new Seat();
            seat.setSeatType(SeatType.PLATINUM);
            seats.add(seat);
        }
        return seats;
    }

    List<Screen> createScreen() {
        Screen screen1 = new Screen();
        screen1.setSeats(createSeats());

        Screen screen2 = new Screen();
        screen2.setSeats(createSeats());

        List<Screen> screens = new ArrayList<>();
        screens.add(screen1);
        screens.add(screen2);
        return screens;
    }

    void createTheater() {

        Theater theater = new Theater();
        theater.setLocation(Location.builder().city("Delhi").build());
        theater.setName("DLF mall");
        theater.setScreen(createScreen());


        Movie movie1=movieController.findMovieByName("Furiosa");

        ZoneId zoneId = ZoneId.of("UTC");

        Date date1 = Date.from(LocalDateTime.of(2024, 6, 19, 11, 0).atZone(zoneId).toInstant());


        Show movie1Show1 = Show.builder()
                .movie(movie1)
                .screen(theater.getScreen().get(0))
                .showStartTime(date1)
                .theater(theater)
                .build();

        Date date2 = Date.from(LocalDateTime.of(2024, 6, 19, 16, 0).atZone(zoneId).toInstant());
        Show movie1Show2 = Show.builder()
                .movie(movie1)
                .screen(theater.getScreen().get(0))
                .showStartTime(date2)
                .theater(theater)
                .build();
        List<Show> movie1Shows = new ArrayList<>();
        movie1Shows.add(movie1Show1);
        movie1Shows.add(movie1Show2);
        theater.setShows(movie1Shows);


        Movie movie2=movieController.findMovieByName("Deadpool");

        Date date3 = Date.from(LocalDateTime.of(2024, 6, 19, 11, 0).atZone(zoneId).toInstant());


        Show movie2Show1 = Show.builder()
                .movie(movie2)
                .screen(theater.getScreen().get(1))
                .showStartTime(date1)
                .build();

        Date date4 = Date.from(LocalDateTime.of(2024, 6, 19, 16, 0).atZone(zoneId).toInstant());
        Show movie2Show2 = Show.builder()
                .movie(movie2)
                .screen(theater.getScreen().get(1))
                .showStartTime(date2)
                .build();
        List<Show> movie2Shows = new ArrayList<>();
        movie1Shows.add(movie2Show1);
        movie1Shows.add(movie2Show2);
        theater.setShows(movie2Shows);

        theaterController.addTheater(theater);

    }


}

package org.example.LLD.Designs.BookMyShow.Theater;

import org.example.LLD.Designs.BookMyShow.Movie.Show;

import java.util.List;

public class Theater {

    int theaterId;
    Location location;
    String name;
    List<Screen> screen;

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    List<Show> shows;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screen> getScreen() {
        return screen;
    }

    public void setScreen(List<Screen> screen) {
        this.screen = screen;
    }

}

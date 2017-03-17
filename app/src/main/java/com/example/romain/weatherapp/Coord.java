package com.example.romain.weatherapp;

/**
 * Created by Romain on 17/03/2017.
 * Contient les latitudes et longitudes
 */

public class Coord {

    private double lat;
    private double lon;

    public Coord(double lon, double lat){
        this.lon=lon;
        this.lat=lat;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}

package com.example.romain.weatherapp;

/**
 * Created by Romain on 17/03/2017.
 */

public class City {

    private int _id;
    private String name;
    private String country;
    private Coord coord;

    public City(int _id, String name, String country, double lon, double lat) {
        this._id = _id;
        this.name = name;
        this.country = country;
        coord = new Coord(lon, lat);
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public Coord getCoord() {
        return coord;
    }

    @Override
    public String toString() {
        return "City{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", coord=" + coord +
                '}';
    }
}


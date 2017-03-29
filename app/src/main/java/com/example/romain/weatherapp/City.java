package com.example.romain.weatherapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Romain on 17/03/2017.
 */

public class City implements Parcelable{

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

    protected City(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        country = in.readString();
        coord = in.readParcelable(Coord.class.getClassLoader());
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
        dest.writeString(country);
        dest.writeParcelable(coord, flags);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return _id == city._id;
    }

    @Override
    public int hashCode() {
        return _id;
    }
}


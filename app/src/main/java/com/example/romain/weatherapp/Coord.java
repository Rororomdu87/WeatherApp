package com.example.romain.weatherapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Romain on 17/03/2017.
 * Contient les latitudes et longitudes
 */

public class Coord implements Parcelable{

    private double lat;
    private double lon;

    public Coord(double lon, double lat){
        this.lon=lon;
        this.lat=lat;
    }

    protected Coord(Parcel in) {
        lat = in.readDouble();
        lon = in.readDouble();
    }

    public static final Creator<Coord> CREATOR = new Creator<Coord>() {
        @Override
        public Coord createFromParcel(Parcel in) {
            return new Coord(in);
        }

        @Override
        public Coord[] newArray(int size) {
            return new Coord[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lon);
    }
}

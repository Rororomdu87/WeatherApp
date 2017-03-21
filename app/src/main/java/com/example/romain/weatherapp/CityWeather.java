package com.example.romain.weatherapp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Romain on 21/03/2017.
 */

class CityWeather implements JsonDeserializer<CityWeather>{
    private int temp;
    private int pressure;
    private int humidity;
    private int temp_min;
    private int temp_max;

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    public int getTemp() {

        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getTemp_min() {
        return temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }

    @Override
    public CityWeather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}

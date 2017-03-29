package com.example.romain.weatherapp;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Romain on 21/03/2017.
 */

class CityWeather implements JsonDeserializer<CityWeather>{

    private String main;

    private int id;
    private String description;
    private String icon;

    private double temp;
    private int pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;
    private double wind;

    public void setId(int id) { this.id = id; }

    public void setDescription(String description) { this.description = description; }

    public void setMain(String main) { this.main = main; }

    public void setIcon(String icon) { this.icon = icon; }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }

    public void setWind(double wind) { this.wind = wind; }

    public String getDescription() { return description; }

    public String getMain() { return main; }

    public String getIcon() { return icon; }

    public double getTemp() { return temp; }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getWind() { return wind; }

    @Override
    public String toString() {
        return "CityWeather{" +
                "main='" + main + '\'' +
                ", id=" + id +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", wind=" + wind +
                '}';
    }

    @Override
    public CityWeather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        CityWeather weather = new CityWeather();
        JsonObject jsonObject = json.getAsJsonObject();

        JsonArray weatherArray = jsonObject.get("weather").getAsJsonArray();
        JsonObject weatherObject = weatherArray.get(0).getAsJsonObject();

        weather.setDescription(weatherObject.get("description").getAsString());
        weather.setMain(weatherObject.get("main").getAsString());
        weather.setIcon(weatherObject.get("icon").getAsString());

        JsonObject weathermainObject = jsonObject.get("main").getAsJsonObject();

        weather.setTemp(weathermainObject.get("temp").getAsDouble());
        weather.setPressure(weathermainObject.get("pressure").getAsInt());
        weather.setHumidity(weathermainObject.get("humidity").getAsInt());
        weather.setTemp_min(weathermainObject.get("temp_min").getAsDouble());
        weather.setTemp_max(weathermainObject.get("temp_max").getAsDouble());

        JsonObject weatherwindObject = jsonObject.get("wind").getAsJsonObject();
        weather.setWind(weatherwindObject.get("speed").getAsDouble());

        return weather;
    }
}

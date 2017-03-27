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
    private String description;
    private String main;
    private String icon;
    private int temp;
    private int pressure;
    private int humidity;
    private int temp_min;
    private int temp_max;

    public void setDescription(String description) { this.description = description; }

    public void setMain(String main) { this.main = main; }

    public void setIcon(String icon) { this.icon = icon; }

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

    public String getDescription() { return description; }

    public String getMain() { return main; }

    public String getIcon() { return icon; }

    public int getTemp() { return temp; }

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
        CityWeather weather = new CityWeather();
        JsonObject jsonObject = json.getAsJsonObject();

        JsonArray weatherArray = jsonObject.get("weather").getAsJsonArray();
        JsonObject weatherObject = weatherArray.get(0).getAsJsonObject();

        weather.setDescription(weatherObject.get("description").getAsString());
        weather.setMain(weatherObject.get("main").getAsString());
        weather.setIcon(weatherObject.get("icon").getAsString());

        JsonObject weathermainObject = jsonObject.get("main").getAsJsonObject();

        weather.setTemp(weathermainObject.get("temp").getAsInt());
        weather.setPressure(weathermainObject.get("pressure").getAsInt());
        weather.setHumidity(weathermainObject.get("humidity").getAsInt());
        weather.setTemp_min(weathermainObject.get("temp_min").getAsInt());
        weather.setTemp_max(weathermainObject.get("temp_max").getAsInt());

        return weather;
    }
}

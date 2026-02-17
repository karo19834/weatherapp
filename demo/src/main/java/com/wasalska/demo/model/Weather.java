package com.wasalska.demo.model;

public class Weather {

    private String location;
    private double temperature;
    private double precipitation;
    private int wind;


    public Weather(String location, double temperature, double precipitation, int wind) {
        this.location = location;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.wind = wind;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }
}

package com.wasalska.demo.model;

public class Weather {
    private String location;
    private double temperature;
    private double precipitation;
    private int wind;
    private Double pm2_5;
    private Double pm10;

    public Weather(String location, double temperature, double precipitation, int wind, Double pm2_5, Double pm10) {
        this.location = location;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.wind = wind;
        this.pm2_5 = pm2_5;
        this.pm10 = pm10;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public Double getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(Double pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }
}

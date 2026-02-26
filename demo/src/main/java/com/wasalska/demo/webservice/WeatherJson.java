package com.wasalska.demo.webservice;

import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherJson {
    //TODO zmienic nazwy na jeden jezyk, uwaga na mapowanie JSON!!!
    private String stacja;
    private double temperatura;
    private double precipitation;
    private int wind;

    public WeatherJson(String location, double temperatura, double precipitation, int wind) {
        this.stacja = location;
        this.temperatura = temperatura;
        this.precipitation = precipitation;
        this.wind = wind;
    }

    public WeatherJson() {
    }

    public String getStacja() {
        return stacja;
    }

    public void setStacja(String stacja) {
        this.stacja = stacja;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    @JsonSetter("suma_opadu")
    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public int getWind() {
        return wind;
    }

    @JsonSetter("predkosc_wiatru")
    public void setWind(int wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Pogoda {" +
                "stacja='" + stacja + '\'' +
                ", temperatura=" + temperatura +
                ", suma opadu=" + precipitation +
                ", predkosc wiatru=" + wind +
                '}';
    }
}

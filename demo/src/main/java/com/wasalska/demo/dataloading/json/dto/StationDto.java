package com.wasalska.demo.dataloading.json.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class StationDto {

    private String location;
    private int stationId;

    public String getLocation() {
        return location;
    }

    @JsonSetter("Nazwa miasta")
    public void setLocation(String location) {
        this.location = location;
    }

    public int getStationId() {
        return stationId;
    }
    @JsonSetter("Identyfikator stacji")
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return
                "location='" + location + '\'' +
                ", stationId=" + stationId ;
    }
}

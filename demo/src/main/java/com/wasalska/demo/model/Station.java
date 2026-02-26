package com.wasalska.demo.model;

public class Station {
    private String location;
    private int stationId;
    private Integer pm10SensorId;
    private Integer pm2_5SensorId;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Integer getPm10SensorId() {
        return pm10SensorId;
    }

    public void setPm10SensorId(Integer pm10SensorId) {
        this.pm10SensorId = pm10SensorId;
    }

    public Integer getPm2_5SensorId() {
        return pm2_5SensorId;
    }

    public void setPm2_5SensorId(Integer pm2_5SensorId) {
        this.pm2_5SensorId = pm2_5SensorId;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", location='" + location + '\'' +
                ", pm10SensorId=" + pm10SensorId +
                ", pm2_5SensorId=" + pm2_5SensorId +
                '}';
    }
}

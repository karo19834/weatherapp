package com.wasalska.demo.dataloading.json.dto;

import com.fasterxml.jackson.annotation.JsonSetter;

public class SensorDto {

    private int sensorId;
    private String indicatorCode;

    public int getSensorId() {
        return sensorId;
    }

    @JsonSetter("Identyfikator stanowiska")
    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getIndicatorCode() {
        return indicatorCode;
    }
    @JsonSetter("Wskaźnik - kod")
    public void setIndicatorCode(String indicatorCode) {
        this.indicatorCode = indicatorCode;
    }

    @Override
    public String toString() {
        return "SensorDto{" +
                "sensorId=" + sensorId +
                ", indicatorCode='" + indicatorCode + '\'' +
                '}';
    }
}

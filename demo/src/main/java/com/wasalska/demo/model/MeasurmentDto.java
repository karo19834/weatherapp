package com.wasalska.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.time.LocalDate;

public class MeasurmentDto {

    private String stationCode;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDate dateTime;
    private Double value;

    public MeasurmentDto(String stationCode, LocalDate dateTime, Double value) {
        this.stationCode = stationCode;
        this.dateTime = dateTime;
        this.value = value;
    }

    public MeasurmentDto(){

    }

    public String getStationCode() {
        return stationCode;
    }
    @JsonSetter("Kod stanowiska")
    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }
    @JsonSetter("Data")
    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public Double getValue() {
        return value;
    }
    @JsonSetter("Wartość")
    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MeasurmentDto{" +
                "stationCode='" + stationCode + '\'' +
                ", dateTime=" + dateTime +
                ", value=" + value +
                '}';
    }
}

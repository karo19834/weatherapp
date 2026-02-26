package com.wasalska.demo.service;

import com.wasalska.demo.filereader.StationsCsvReader;
import com.wasalska.demo.model.Station;
import com.wasalska.demo.webservice.AirPollutionSensorService;

import java.util.List;
import java.util.function.Function;

public class AirPollutionService {
    private AirPollutionSensorService airPollutionSensorService = new AirPollutionSensorService();

    public Double getPm2_5Data(String stationName) {
        return getPmData(stationName, station -> station.getPm2_5SensorId());
    }

    public Double getPm10Data(String stationName) {
        return getPmData(stationName, Station::getPm10SensorId);
    }

    private Double getPmData(String stationName, Function<Station, Integer> getStationSensor) {
        StationsCsvReader stationsCsvReader = new StationsCsvReader();
        List<Station> stations = stationsCsvReader.readStations();
        Double pmSensorData = null;
        for (Station station : stations) {
            if (station.getLocation().equals(stationName)) {
                pmSensorData = airPollutionSensorService.getPmData(getStationSensor.apply(station));
            }
        }
        return pmSensorData;
    }
}

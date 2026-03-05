package com.wasalska.demo.service;

import com.wasalska.demo.filereader.StationsCsvReader;
import com.wasalska.demo.model.Station;
import com.wasalska.demo.service.dto.PmDateData;
import com.wasalska.demo.webservice.AirPollutionSensorService;

import java.util.List;
import java.util.function.Function;

public class AirPollutionService {
    private AirPollutionSensorService airPollutionSensorService = new AirPollutionSensorService();
    StationsCsvReader stationsCsvReader = new StationsCsvReader();
    List<Station> stations = stationsCsvReader.readStations();

    public Double getPm2_5Data(String stationName) {
        return getPmData(stationName, station -> station.getPm2_5SensorId());
    }

    public Double getPm10Data(String stationName) {
        return getPmData(stationName, Station::getPm10SensorId);
    }

    private Double getPmData(String stationName, Function<Station, Integer> getStationSensor) {
        PmDateData pmSensorData = null;
        PmDateData maxData= null;

        for (Station station : stations) {
            if (station.getLocation().equals(stationName)) {
                pmSensorData = airPollutionSensorService.getPmData(getStationSensor.apply(station));
                if(isGreater(pmSensorData, maxData)){
                    maxData = pmSensorData;
                }
            }
        }
        return maxData != null ? maxData.getPm() : null;
    }

    private boolean isGreater(PmDateData data1, PmDateData data2){
        return data1 != null &&
                (data2 == null || data1.getDate().isAfter(data2.getDate()) ||
                        (data1.getDate().isEqual(data2.getDate()) && data1.getPm() > data2.getPm()));
    }
}

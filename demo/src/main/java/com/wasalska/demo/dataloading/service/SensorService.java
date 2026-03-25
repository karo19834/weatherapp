package com.wasalska.demo.dataloading.service;

import com.wasalska.demo.dataloading.json.JsonDeserializer;
import com.wasalska.demo.dataloading.service.dto.StationSensors;
import com.wasalska.demo.dataloading.model.Station;
import org.springframework.stereotype.Component;

@Component
public abstract class SensorService {

    //private String pathSensor = "C:\\JavaProjects\\demo-preprocessing\\demo-preprocessing\\src\\main\\resources\\stacja.json";

    private JsonDeserializer jsonDeserializer = new JsonDeserializer();
    private AirPollutionDataService airPollutionDataService = new AirPollutionDataService();
    public SensorService() {

    }

    /**
     * wypelnia pojedyncza stacje sensorami PM 2.5 i PM 10
     */
    public void insertSensors(Station station) {
        StationSensors stationSensors = jsonDeserializer.deserializeSensors(getSensorsJson(station.getStationId()));
        if(stationSensors.getPm10SensorId() != null && !airPollutionDataService.isManual(stationSensors.getPm10SensorId())) {
            station.setPm10SensorId(stationSensors.getPm10SensorId());
        }
        if (stationSensors.getPm2_5SensorId() != null && !airPollutionDataService.isManual(stationSensors.getPm2_5SensorId()) ) {
            station.setPm2_5SensorId(stationSensors.getPm2_5SensorId());
        }
    }

    protected abstract String getSensorsJson(int stationId);



}

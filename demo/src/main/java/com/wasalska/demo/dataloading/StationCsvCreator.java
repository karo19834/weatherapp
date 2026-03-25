package com.wasalska.demo.dataloading;

import com.wasalska.demo.filereader.JsonFileReader;
import com.wasalska.demo.dataloading.file.StationsCsvWriter;
import com.wasalska.demo.model.Station;
import com.wasalska.demo.dataloading.service.SensorService;
import com.wasalska.demo.dataloading.service.StationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StationCsvCreator {

    private JsonFileReader jsonFileReader;
    private SensorService sensorService;
    private StationService stationService;
    private StationsCsvWriter stationsCsvWriter = new StationsCsvWriter();
    private String pathStation = "C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\Stacje.json";

    public StationCsvCreator(JsonFileReader jsonFileReader, @Qualifier("sensorHttpService") SensorService sensorService, StationService stationService) {
        this.jsonFileReader = jsonFileReader;
        this.sensorService = sensorService;
        this.stationService = stationService;
    }

    public void createStationsCsv() {
        List<Station> stations = stationService.getStations();
       // List<Station> stations = jsonFileReader.readStations(pathStation);
        for (Station station : stations) {
            sensorService.insertSensors(station);
        }
        stationsCsvWriter.write(stations);
    }
}

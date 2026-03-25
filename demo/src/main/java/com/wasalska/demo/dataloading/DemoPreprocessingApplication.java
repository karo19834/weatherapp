package com.wasalska.demo.dataloading;

import com.wasalska.demo.dataloading.file.JsonFileReader;
import com.wasalska.demo.dataloading.file.StationsCsvWriter;
import com.wasalska.demo.dataloading.model.Station;
import com.wasalska.demo.dataloading.service.SensorService;
import com.wasalska.demo.dataloading.service.StationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoPreprocessingApplication {

    private JsonFileReader jsonFileReader;
    private SensorService sensorService;
    private StationService stationService;
    private StationsCsvWriter stationsCsvWriter = new StationsCsvWriter();

    public DemoPreprocessingApplication(JsonFileReader jsonFileReader, @Qualifier("sensorHttpService") SensorService sensorService, StationService stationService) {
        this.jsonFileReader = jsonFileReader;
        this.sensorService = sensorService;
        this.stationService = stationService;
    }

    private String pathStation = "C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\stations.csv";



    public void createStationsCsv() {
  //      AirPollutionDataService airPollutionDataService = new AirPollutionDataService();
//        List<Station> stations = stationService.getStations();
        List<Station> stations = jsonFileReader.readStations(pathStation);
        for (Station station : stations) {
            sensorService.insertSensors(station);
        }
        //List<Station> stations = new StationsCsvReader().readStations();
        //stations.forEach(System.out::println);
//        for (Station station : stations) {
//            System.out.println(station);
//            airPollutionDataService.getPmData(station.getPm10SensorId());
//        }
        stationsCsvWriter.write(stations);
    }
}

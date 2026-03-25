package com.wasalska.demo.service;

import com.wasalska.demo.dataloading.DemoPreprocessingApplication;
import com.wasalska.demo.filereader.StationsCsvReader;
import com.wasalska.demo.model.Station;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Component
public class StationLoader {
    StationsCsvReader stationsCsvReader = new StationsCsvReader();
    private DemoPreprocessingApplication demoPreprocessingApplication;
    private String filePath = "C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\stations.csv";

    public StationLoader(DemoPreprocessingApplication demoPreprocessingApplication) {
        this.demoPreprocessingApplication = demoPreprocessingApplication;
    }

    public List<Station> loadStations (){
        File file = new File(filePath);
        List<Station> stations = Collections.emptyList();

        if (!file.exists() || (( System.currentTimeMillis() - file.lastModified()) > 86400000)) {
            demoPreprocessingApplication.createStationsCsv();
        }
        stations = stationsCsvReader.readStations(filePath);

        return stations;
    }
}

package com.wasalska.demo.dataloading.file;

import com.wasalska.demo.model.Station;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StationsCsvWriter {

    private String filePath = "C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\stations.csv";

    public void write(List<Station> stations) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Station station : stations){
                String pm25SensorId = station.getPm2_5SensorId() == null ? "" :  station.getPm2_5SensorId().toString();
                String pm10SensorId = station.getPm10SensorId() == null ? "" :  station.getPm10SensorId().toString();
                String line = station.getStationId() + ","
                        +station.getLocation() + ","
                        +  pm25SensorId + ","
                        +pm10SensorId + "\n";
                writer.write(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

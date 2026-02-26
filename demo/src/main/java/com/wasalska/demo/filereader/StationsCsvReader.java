package com.wasalska.demo.filereader;

import com.wasalska.demo.model.Station;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StationsCsvReader {

    private String filePath = "C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\stations.csv";

    public List<Station> readStations() {
        List<Station> stations = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                Station station = new Station();
                String[] data = line.split(",", -1);
                station.setStationId(Integer.parseInt(data[0]));
                station.setLocation(data[1]);
                //pierwszy sposob
                if (data[2].isEmpty()) {
                    station.setPm2_5SensorId(null);
                } else {
                    station.setPm2_5SensorId(Integer.parseInt(data[2]));
                }
                //kkrotszy sposob
                station.setPm10SensorId(data[3].isEmpty() ? null : Integer.parseInt(data[3]));

                stations.add(station);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stations;
    }
}

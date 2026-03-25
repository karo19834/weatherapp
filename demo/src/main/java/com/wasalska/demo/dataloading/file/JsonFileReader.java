package com.wasalska.demo.dataloading.file;

import com.wasalska.demo.dataloading.json.JsonDeserializer;
import com.wasalska.demo.dataloading.model.Station;
import com.wasalska.demo.dataloading.service.dto.StationSensors;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class JsonFileReader {

    public List<Station> readStations(String filePath) {
        JsonDeserializer deserializer = new JsonDeserializer();
        List<Station> stations = deserializer.deserializeStations(readFile(filePath));
        //stations.stream().forEach(System.out::println);
        return stations;
    }

    private String readFile(String path) {
        File file = new File(path);
        String json = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                json += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
        //System.out.println(json);
    }
}
package com.wasalska.demo.dataloading.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wasalska.demo.dataloading.json.dto.SensorDto;
import com.wasalska.demo.dataloading.json.dto.StationDto;
import com.wasalska.demo.model.Station;
import com.wasalska.demo.dataloading.service.dto.StationSensors;

import java.util.ArrayList;
import java.util.List;

public class JsonDeserializer {

    public List<Station> deserializeStations(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        List<Station> stations = new ArrayList<>();
        try {
            JsonNode jsonNodeRoot= objectMapper.readTree(json);
            JsonNode jsonNodeStations= jsonNodeRoot.get("Lista stacji pomiarowych");
            //System.out.println(jsonNodeStations.toPrettyString());

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            StationDto[] stationDtos = objectMapper.readValue(jsonNodeStations.toString(), StationDto[].class);
            //Arrays.stream(stationDtos).forEach(System.out::println);

            for (StationDto stationDto : stationDtos) {
                Station station = new Station();
                station.setLocation(stationDto.getLocation());
                station.setStationId(stationDto.getStationId());
                stations.add(station);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return stations;
    }

    public StationSensors deserializeSensors (String json){
        ObjectMapper objectMapper = new ObjectMapper();
        StationSensors stationSensors = new StationSensors();
        try{
            JsonNode jsonNodeRoot = objectMapper.readTree(json);
            JsonNode jsonNodeSensor = jsonNodeRoot.get("Lista stanowisk pomiarowych dla podanej stacji");

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            SensorDto[] sensorDtos = objectMapper.readValue(jsonNodeSensor.toString(), SensorDto[].class);
            //Arrays.stream(sensorDtos).forEach(System.out::println);

            for (SensorDto sensorDto : sensorDtos){
                String indicatorCode =sensorDto.getIndicatorCode();
                if(indicatorCode.equals("PM10")){
                    stationSensors.setPm10SensorId(sensorDto.getSensorId());
                }if(indicatorCode.equals("PM2.5")){
                    stationSensors.setPm2_5SensorId((sensorDto.getSensorId()));
                }

            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return stationSensors;
    }
}

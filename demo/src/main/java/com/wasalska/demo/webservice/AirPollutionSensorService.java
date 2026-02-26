package com.wasalska.demo.webservice;

import com.wasalska.demo.filereader.JsonFileReader;
import com.wasalska.demo.json.JsonPmDeserializer;

public class AirPollutionSensorService {
    private JsonPmDeserializer jsonPmDeserializer = new JsonPmDeserializer();
    private JsonFileReader jsonFileReader = new JsonFileReader();

    public Double getPmData(Integer sensorId) {
        if (sensorId == null) {
            return null;
        }
        String json = jsonFileReader.readFile("C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\data_single.json");
//        RestClient sensorRestClient = RestClient.create();
//        String result = sensorRestClient.get()
//            .uri("https://api.gios.gov.pl/pjp-api/v1/rest/data/getData/" + sensorId)
//            .accept(MediaType.APPLICATION_JSON)
//            .retrieve()
//            .body(String.class);
        Double result = jsonPmDeserializer.deserializePm(json);
        return result;
    }
}

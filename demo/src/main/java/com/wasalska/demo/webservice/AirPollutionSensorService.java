package com.wasalska.demo.webservice;

import com.wasalska.demo.filereader.JsonFileReader;
import com.wasalska.demo.json.JsonPmDeserializer;
import com.wasalska.demo.service.dto.PmDateData;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class AirPollutionSensorService {
    private JsonPmDeserializer jsonPmDeserializer = new JsonPmDeserializer();
    private JsonFileReader jsonFileReader = new JsonFileReader();

    public PmDateData getPmData(Integer sensorId) {
        if (sensorId == null) {
            return null;
        }
        //String json = jsonFileReader.readFile("C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\data_single.json");
        RestClient sensorRestClient = RestClient.create();
        String json = sensorRestClient.get()
            .uri("https://api.gios.gov.pl/pjp-api/v1/rest/data/getData/" + sensorId)
            //.accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(String.class);
        PmDateData result = jsonPmDeserializer.deserializePm(json);
        return result;
    }
}

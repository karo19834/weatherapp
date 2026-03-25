package com.wasalska.demo.webservice;

import com.wasalska.demo.json.JsonPmDeserializer;
import com.wasalska.demo.service.dto.PmDateData;
import org.springframework.web.client.RestClient;

public class AirPollutionSensorService {
    private JsonPmDeserializer jsonPmDeserializer = new JsonPmDeserializer();

    public PmDateData getPmData(Integer sensorId) {
        if (sensorId == null) {
            return null;
        }
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

package com.wasalska.demo.dataloading.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component("sensorHttpService")
public class SensorHttpService extends SensorService {

    private RestClient restClient = RestClient.create();

    protected String getSensorsJson(int stationId) {
        String result = restClient.get()
                .uri("https://api.gios.gov.pl/pjp-api/v1/rest/station/sensors/" + stationId)
                .retrieve()
                .body(String.class);
        return result;
    }
}

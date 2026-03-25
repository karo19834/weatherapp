package com.wasalska.demo.dataloading.service;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

public class AirPollutionDataService {

    public boolean isManual(int sensorId){
        RestClient restClient = RestClient.create();
        try {
            restClient.get()
                    .uri("https://api.gios.gov.pl/pjp-api/v1/rest/data/getData/" + sensorId)
                    .retrieve()
                    .body(String.class);
        } catch (HttpClientErrorException e) {
            if(e.getStatusCode().value()== 400 && e.getResponseBodyAs(String.class).contains("Dla stanowiska typu manualnego")){
                return true;
            } else {
                throw e;
            }
        }
        return false;
    }
}

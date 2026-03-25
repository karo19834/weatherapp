package com.wasalska.demo.dataloading.service;


import com.wasalska.demo.dataloading.json.JsonDeserializer;
import com.wasalska.demo.dataloading.model.Station;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class StationService {

    private RestClient restClient = RestClient.create();

    private JsonDeserializer jsonDeserializer = new JsonDeserializer();

    public List<Station> getStations() {
        String result = restClient.get()
                .uri("https://api.gios.gov.pl/pjp-api/v1/rest/station/findAll?size=500")
                //.accept(MediaType.APPLICATION_)
                .retrieve()
                .body(String.class);
        return jsonDeserializer.deserializeStations(result);
    }
}

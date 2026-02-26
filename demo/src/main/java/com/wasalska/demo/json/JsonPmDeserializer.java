package com.wasalska.demo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wasalska.demo.model.MeasurmentDto;

public class JsonPmDeserializer {

    public Double deserializePm(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            JsonNode jsonNodeRoot = objectMapper.readTree(json);
            JsonNode jsonNodeStations = jsonNodeRoot.get("Lista danych pomiarowych");

            MeasurmentDto[] measurmentDtos = objectMapper.readValue(jsonNodeStations.toString(), MeasurmentDto[].class);
            for (MeasurmentDto measurmentDto : measurmentDtos) {
                if (measurmentDto.getValue() != null) {
                    return measurmentDto.getValue();
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

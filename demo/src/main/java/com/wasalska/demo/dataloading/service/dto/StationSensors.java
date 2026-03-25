package com.wasalska.demo.dataloading.service.dto;

public class StationSensors {
    private Integer pm10SensorId;
    private Integer pm2_5SensorId;

    public Integer getPm10SensorId() {
        return pm10SensorId;
    }

    public void setPm10SensorId(Integer pm10SensorId) {
        this.pm10SensorId = pm10SensorId;
    }

    public Integer getPm2_5SensorId() {
        return pm2_5SensorId;
    }

    public void setPm2_5SensorId(Integer pm2_5SensorId) {
        this.pm2_5SensorId = pm2_5SensorId;
    }

    @Override
    public String toString() {
        return "StationSensors{" +
                "pm10SensorId=" + pm10SensorId +
                ", pm2_5SensorId=" + pm2_5SensorId +
                '}';
    }
}

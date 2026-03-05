package com.wasalska.demo.service.dto;

import java.time.LocalDate;

public class PmDateData {
    private Double pm;
    private LocalDate date;

    public Double getPm() {
        return pm;
    }

    public void setPm(Double pm) {
        this.pm = pm;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}

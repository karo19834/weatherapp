package com.wasalska.demo;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherappApplication {

	public static void main(String[] args) {
		Application.launch(WeatherFXApplication.class, args);
	}

}

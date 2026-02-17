package com.wasalska.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {



    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        try {
            URL url = new URL("file:\\C:\\JavaProjects\\weatherapp\\demo\\src\\main\\resources\\weatherapp.fxml");
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root, 1000, 500);
            Stage stage = event.getStage();
            stage.setTitle("Hello world!");
            stage.setScene(scene);


            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.wasalska.demo;

import com.wasalska.demo.model.Weather;
import com.wasalska.demo.service.AirPollutionService;
import com.wasalska.demo.webservice.WeatherJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WeatherAppController implements Initializable {
    @FXML
    private Label titleLabel;
    @FXML
    private Button refreshButton;
    @FXML
    private TableColumn locationColumn;
    @FXML
    private TableColumn temperatureColumn;
    @FXML
    private TableColumn precipitationColumn;
    @FXML
    private TableColumn windColumn;
    @FXML
    private TableColumn pm2_5Column;
    @FXML
    private TableColumn pm10Column;
    @FXML
    private TableView<Weather> weatherTable;

    private RestClient weatherRestClient = RestClient.create();

    private final ObservableList<Weather> data =
            FXCollections.observableArrayList(
                    new Weather("Krakow", 20.0, 4.0, 3, 2.5, 10.0),
                    new Weather("Londyn", 10.0, 0.0, 4, 4.6, 3.6),
                    new Weather("Graz", 23.0, 5.8, 0, 2.1, 8.5)
            );

    @FXML
    public void handleRefresh(ActionEvent actionEvent) {
        titleLabel.setText("Udalo sie");
        data.add(new Weather("Praha", 38, 4.5, 4, 6.3, 7.3));

        WeatherJson[] result = weatherRestClient.get()
                .uri("https://danepubliczne.imgw.pl/api/data/synop/")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(WeatherJson[].class);
        System.out.println(Arrays.toString(result));

        Weather[] weathers = weatherJsonToWeather(result);

        AirPollutionService airPollutionService = new AirPollutionService();

        for (Weather weather : weathers) {
            Double pm2_5 = airPollutionService.getPm2_5Data(weather.getLocation());
            weather.setPm2_5(pm2_5);
            Double pm10 = airPollutionService.getPm10Data(weather.getLocation());
            weather.setPm10(pm10);
        }

        data.clear();
        data.addAll(weathers);

    }

    Weather[] weatherJsonToWeather(WeatherJson[] weatherJson) {
        Weather[] weather = new Weather[weatherJson.length];
        for (int i = 0; i < weatherJson.length; i++) {
            weather[i] = new Weather(weatherJson[i].getStacja(), weatherJson[i].getTemperatura(), weatherJson[i].getPrecipitation(), weatherJson[i].getWind(), 5.8, 7.4);
        }
        return weather;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        locationColumn.setCellValueFactory(new PropertyValueFactory<Weather, String>("location"));
        temperatureColumn.setCellValueFactory(new PropertyValueFactory<Weather, Double>("temperature"));
        precipitationColumn.setCellValueFactory(new PropertyValueFactory<Weather, Double>("precipitation"));
        windColumn.setCellValueFactory(new PropertyValueFactory<Weather, Integer>("wind"));
        pm2_5Column.setCellValueFactory(new PropertyValueFactory<Weather, Double>("pm2_5"));
        pm10Column.setCellValueFactory(new PropertyValueFactory<Weather, Double>("pm10"));
        weatherTable.setItems(data);
    }
}

package com.grabarski.mateusz.models.weather;

import com.grabarski.mateusz.models.weather.services.WeatherService;

import java.time.LocalDate;

/**
 * Created by Mateusz Grabarski on 06.06.2018.
 */
public class WeatherStation {

    private WeatherService weatherService;
    private GUIController guiController;

    public WeatherStation(WeatherService weatherService, GUIController guiController) {
        this.weatherService = weatherService;
        this.guiController = guiController;
    }

    public void update() {
        guiController.display(weatherService.getWeather(LocalDate.now()));
    }
}
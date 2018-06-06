package com.grabarski.mateusz.models.weather.services;

import java.time.LocalDate;

/**
 * Created by Mateusz Grabarski on 06.06.2018.
 */
public interface WeatherService {
    String getWeather(LocalDate date);
}
package com.grabarski.mateusz.models.weather;

import com.grabarski.mateusz.models.weather.services.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Mateusz Grabarski on 06.06.2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherStationTest {

    @Mock
    private WeatherService weatherService;

    @Mock
    private GUIController guiController;

    @Test
    public void shouldUpdateWeather() {

        // given
        LocalDate now = LocalDate.now();
        String dateString = now.toString();
        when(weatherService.getWeather(now)).thenReturn(dateString);
        WeatherStation weatherStation = new WeatherStation(weatherService, guiController);

        // when
        weatherStation.update();

        // then
        verify(weatherService).getWeather(now);
        verify(guiController).display(dateString);
    }
}
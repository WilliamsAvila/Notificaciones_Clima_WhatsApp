package org.servicewhatsappweather.Service;

import org.servicewhatsappweather.Repository.GetWeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetWeatherService {


    @Autowired
    private GetWeatherRepository getWeatherRepository;

    public String getWeather() {
        return getWeatherRepository.getWeather("Madrid");
    }
}

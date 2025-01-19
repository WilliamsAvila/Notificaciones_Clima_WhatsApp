package org.servicewhatsappweather.Repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Get-Weather")
public interface GetWeatherRepository {

    @GetMapping("/Weather/getWeather/{city}")
    public String getWeather(@PathVariable String city);

}

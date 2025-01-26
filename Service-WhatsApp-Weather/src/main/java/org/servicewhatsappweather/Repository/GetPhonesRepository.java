package org.servicewhatsappweather.Repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="Add-Phones")
public interface GetPhonesRepository {

    @GetMapping("/GetNumber/AllNumbers")
    List<Object> getAllNumbers();
}

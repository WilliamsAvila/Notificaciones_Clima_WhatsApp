package org.servicewhatsappweather.Repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
@FeignClient(name="Add-Phones")
public interface GetPhonesRepository {

    @GetMapping("/GetNumber/AllNumbers")
    List<String> getAllNumbers();
}

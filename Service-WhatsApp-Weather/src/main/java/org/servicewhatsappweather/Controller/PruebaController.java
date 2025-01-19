package org.servicewhatsappweather.Controller;

import org.servicewhatsappweather.Repository.GetPhonesRepository;
import org.servicewhatsappweather.Service.GetPhonesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Service-Get")
public class PruebaController {

    @Autowired
    private GetPhonesService getPhonesService;


    @GetMapping("/GetAllNumbers")
    public List<String> getAllNumbers() {
        return getPhonesService.getAllPhones();
    }
}

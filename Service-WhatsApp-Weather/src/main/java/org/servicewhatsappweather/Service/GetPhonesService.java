package org.servicewhatsappweather.Service;

import org.servicewhatsappweather.Repository.GetPhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPhonesService {

    @Autowired
    private GetPhonesRepository getPhonesRepository;

    public List<Object> getAllPhones(){
        return getPhonesRepository.getAllNumbers();
    }


}

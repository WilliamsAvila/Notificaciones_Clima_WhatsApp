package org.addphones.Controller;

import org.addphones.Repository.UserPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/GetNumber")
public class GetNumberController {

    @Autowired
    private UserPhoneRepository userPhoneRepository;


    @GetMapping("/AllNumbers")
    public List<String> AllNumbers() {
        return userPhoneRepository.findAllNumberPhone();
    }
}

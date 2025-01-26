package org.addphones.Controller;

import org.addphones.Model.UserPhone;
import org.addphones.Repository.UserPhoneRepository;
import org.addphones.Service.NumberService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GetNumber")
public class NumberController {

    @Autowired
    private UserPhoneRepository userPhoneRepository;

    @Autowired
    private NumberService numberService;


    @GetMapping("/AllNumbers")
    public List<String> AllNumbers() {
        return userPhoneRepository.findAllNumberPhone();
    }

    @PostMapping("/AddNumbers")
    public ResponseEntity<String> AddNumbers(@RequestBody UserPhone userPhone) {
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(numberService.AddNumber(userPhone));
    }
}

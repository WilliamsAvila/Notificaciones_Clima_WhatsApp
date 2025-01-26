package org.addphones.Controller;

import jakarta.validation.Valid;
import org.addphones.Model.UserPhone;
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
    private NumberService numberService;


    @GetMapping("/AllNumbers")
    public List<Integer> AllNumbers() {
        return numberService.findAllNumbersPhone();
    }

    @PostMapping("/AddNumbers")
    public ResponseEntity<String> AddNumbers(@Valid @RequestBody UserPhone userPhone) {
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(numberService.AddNumber(userPhone));
    }
}

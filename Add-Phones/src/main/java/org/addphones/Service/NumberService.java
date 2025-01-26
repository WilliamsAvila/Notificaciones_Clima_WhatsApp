package org.addphones.Service;

import org.addphones.Model.UserPhone;
import org.addphones.Repository.UserPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberService {

    @Autowired
    private UserPhoneRepository userPhoneRepository;

    public String AddNumber (UserPhone userPhone){
        if (userPhone.getName() != null && userPhone.getNumberPhone() != 0 && userPhone.getCity() != null){
            userPhoneRepository.save(userPhone);
            return "User Added Successfully";
        } else {
            return "User Not Added Successfully";
        }
    }

    public List<Integer> findAllNumbersPhone (){
        return userPhoneRepository.findAllNumberPhone();
    }
}

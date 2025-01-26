package org.addphones.Service;

import org.addphones.Model.UserPhone;
import org.addphones.Repository.UserPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberService {

    @Autowired
    private UserPhoneRepository userPhoneRepository;

    public String AddNumber (UserPhone userPhone){
        if (userPhone.getName() != null && userPhone.getNumberPhone() != null && userPhone.getCity() != null){
            userPhoneRepository.save(userPhone);
            return "User Added Successfully";
        } else {
            return "User Not Added Successfully";
        }
    }
}

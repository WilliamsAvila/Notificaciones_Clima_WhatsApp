package org.addphones.Repository;

import org.addphones.DTO.UserPhoneDTO;
import org.addphones.Model.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPhoneRepository extends JpaRepository <UserPhone, Long> {

    @Query("SELECT new org.addphones.DTO.UserPhoneDTO(numberPhone, city) FROM UserPhone")
    List<Object> findAllNumberPhone();


}

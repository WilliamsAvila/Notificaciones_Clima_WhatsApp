package org.addphones.Repository;

import org.addphones.Model.UserPhone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPhoneRepository extends JpaRepository <UserPhone, Long> {

    @Query("SELECT numberPhone FROM UserPhone")
    List<String> findAllNumberPhone();


}

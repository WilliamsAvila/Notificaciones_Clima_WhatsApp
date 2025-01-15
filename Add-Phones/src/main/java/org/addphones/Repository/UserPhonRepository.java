package org.addphones.Repository;

import org.addphones.Model.UserPhon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhonRepository extends JpaRepository <UserPhon, Long> {




}

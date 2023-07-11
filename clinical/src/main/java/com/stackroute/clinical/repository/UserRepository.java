package com.stackroute.clinical.repository;

// create a interface USerRepository which extends JpaRepository<ClinicUser, Integer>
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.clinical.model.ClinicUser;

@Repository
public interface UserRepository extends JpaRepository<ClinicUser, Integer> {

    // create a method getUserByNameAndPassword() which returns ClinicUser

    public ClinicUser findByUserName(String userName);

}

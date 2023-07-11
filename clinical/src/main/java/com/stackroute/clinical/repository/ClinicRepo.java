package com.stackroute.clinical.repository;

// create a interface ClinicRepo which extends JpaRepository<Clinical, Integer>
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.clinical.model.Clinic;

@Repository
public interface ClinicRepo extends JpaRepository<Clinic, Integer> {

}


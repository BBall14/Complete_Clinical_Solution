package com.stackroute.clinical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.clinical.exception.ClinicAlreadyExistsException;
import com.stackroute.clinical.exception.ClinicDoesNotExistException;
import com.stackroute.clinical.model.Clinic;
import com.stackroute.clinical.service.ClinicService;

// Annotate this class with @RestController @RestMapping annotation

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ClinicController {

    // Autowire ClinicService class
    @Autowired
    private ClinicService clinicService;

    // create postMapping to store clinical details in database
    // return response entity
    // add try catch block to handle exception and throw
    // ClinicAlreadyExistsException
    // if clinical details already exists
    @PostMapping("/trail")
    public ResponseEntity<?> saveClinical(@RequestBody Clinic clinic) throws ClinicAlreadyExistsException {
        try {
            clinicService.saveClinical(clinic);
            return new ResponseEntity<>(clinic, HttpStatus.CREATED);
        } catch (ClinicAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    // create getMapping to get all clinical details from database
    // return response entity
    // add try catch block to handle exception and throw ClinicDoesNotExistException
    @GetMapping("/trails")
    public ResponseEntity<?> getAllClinical() {
        try {
            return new ResponseEntity<>(clinicService.getAllClinical(), HttpStatus.OK);
        } catch (ClinicDoesNotExistException e) {
            return new ResponseEntity<>("Clinic Does Not Exist", HttpStatus.NOT_FOUND);
        }
    }

    // create getMapping to get clinical details by id from database
    // return response entity
    // add try catch block to handle exception and throw ClinicDoesNotExistException
    @GetMapping("/trail/{id}")
    public ResponseEntity<?> getClinicalById(@PathVariable int id) {
        try {
            return new ResponseEntity<>(clinicService.getClinicalById(id), HttpStatus.OK);
        } catch (ClinicDoesNotExistException e) {
            return new ResponseEntity<>("Clinic Does Not Exist", HttpStatus.NOT_FOUND);
        }
    }

    // create putMapping to update clinical details by id from database
    // return response entity
    // add try catch block to handle exception and throw ClinicDoesNotExistException
    @PutMapping("/trail/{id}")
    public ResponseEntity<?> updateClinicalById(@PathVariable int id, @RequestBody Clinic clinic) {
        try {
            clinicService.updateClinicalById(id, clinic);

            return new ResponseEntity<>(clinic, HttpStatus.CREATED);
            // return ResponseEntity.ok(clinic.toString());
        } catch (ClinicDoesNotExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

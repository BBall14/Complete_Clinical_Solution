package com.stackroute.clinical.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.clinical.exception.ClinicAlreadyExistsException;
import com.stackroute.clinical.exception.ClinicDoesNotExistException;
import com.stackroute.clinical.model.Clinic;
import com.stackroute.clinical.repository.ClinicRepo;

// create a class ClinicService

@Service
public class ClinicService {

    // Autowire ClinicRepo class
    @Autowired
    private ClinicRepo clinicRepo;

    // create a method to store Clinical details in database
    // use clinicRepo.save() method to save clinical details in database
    // add try catch block to handle exception and throw ClinicAlreadyExistsException
    // if clinical details already exists
    public void saveClinical(Clinic clinical) throws ClinicAlreadyExistsException {
        try{
            clinicRepo.save(clinical);
        }
        catch (Exception e){
            throw new ClinicAlreadyExistsException("Clinic Already Exists");
        }
    }

    // create a method to get all clinical details from database
    // use clinicRepo.findAll() method to get all clinical details from database
    // use try catch block to handle exception
    public Iterable<Clinic> getAllClinical() throws ClinicDoesNotExistException {
        try{
            return clinicRepo.findAll();
        }
        catch (Exception e){
            throw new ClinicDoesNotExistException("Clinic Does Not Exist");
        }
    }

    // create a method to get clinical details by id from database
    // use clinicRepo.findById() method to get clinical details by id from database
    // use try catch block to handle exception
    public Clinic getClinicalById(int id) throws ClinicDoesNotExistException {
        try{
            return clinicRepo.findById(id).get();
        }
        catch (Exception e){
            throw new ClinicDoesNotExistException("Clinic Does Not Exist");
        }

    }

    // create a method to delete clinical details by id from database
    // use clinicRepo.deleteById() method to delete clinical details by id from
    // database
    // use try catch block to handle exception
    public void deleteClinicalById(int id) throws ClinicDoesNotExistException {
        try{
            clinicRepo.deleteById(id);
        }
        catch (Exception e){
            throw new ClinicDoesNotExistException("Clinic Does Not Exist");
        }
    }

    // create a method to update clinical details by id from database
    // use clinicRepo.save() method to update clinical details by id from database
    // use try catch block to handle exception
   public Clinic updateClinicalById(int id, Clinic clinical) throws ClinicDoesNotExistException {
        // Retrieve the existing clinical entity by ID
        Optional<Clinic> optionalClinical = clinicRepo.findById(id);
        if (optionalClinical.isPresent()) {
            Clinic existingClinical = optionalClinical.get();

            // Perform the necessary updates on the existing clinical entity
            existingClinical.setName(clinical.getName());
            existingClinical.setDescription(clinical.getDescription());
            // Update other attributes as needed

            // Save the updated clinical entity
            clinicRepo.save(existingClinical);
        } else {
            throw new ClinicDoesNotExistException("Clinic does not exist");
        }
        return clinical;

}
}
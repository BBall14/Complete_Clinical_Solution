package com.stackroute.clinical.service;

// write JUnit5 test cases for all the methods in this ClinicService class using Mockito
// and assert the results using JUnit5 assertions
// Use @Mock and @InjectMocks annotations to create mocks and inject them into the ClinicController class
// Use @BeforeEach annotation to create mocks and inject them into the ClinicController class
// Use @Test annotation to write test cases for all the methods in this ClinicController class
// Use assertEquals() and assertNull() methods to assert the results
// Use verify() method to verify the results
// Use doNothing() method to mock void methods
// Use when() method to mock methods that return something
// Use doThrow() method to mock methods that throw exceptions
// Use doReturn() method to mock methods that return something
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.clinical.exception.ClinicAlreadyExistsException;
import com.stackroute.clinical.exception.ClinicDoesNotExistException;
import com.stackroute.clinical.model.Clinic;
import com.stackroute.clinical.repository.ClinicRepo;
public class ClinicServiceTests {

    @Mock
    private ClinicRepo clinicRepo;

    @InjectMocks
    private ClinicService clinicService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClinical() throws ClinicAlreadyExistsException {
        Clinic clinical = new Clinic();
        // Set clinical properties

        clinicService.saveClinical(clinical);

        verify(clinicRepo, times(1)).save(clinical);
    }

    @Test
    void testSaveClinical_ClinicAlreadyExistsException() {
        Clinic clinical = new Clinic();
        // Set clinical properties

        when(clinicRepo.save(clinical)).thenThrow(new RuntimeException());

        assertThrows(ClinicAlreadyExistsException.class, () -> clinicService.saveClinical(clinical));
        verify(clinicRepo, times(1)).save(clinical);
    }

    @Test
    void testGetAllClinical() throws ClinicDoesNotExistException {
        List<Clinic> clinicalList = new ArrayList<>();
        // Add some clinics to the list

        when(clinicRepo.findAll()).thenReturn(clinicalList);

        Iterable<Clinic> result = clinicService.getAllClinical();

        assertEquals(clinicalList, result);
        verify(clinicRepo, times(1)).findAll();
    }

    @Test
    void testGetAllClinical_ClinicDoesNotExistException() {
        when(clinicRepo.findAll()).thenThrow(new RuntimeException());

        assertThrows(ClinicDoesNotExistException.class, () -> clinicService.getAllClinical());
        verify(clinicRepo, times(1)).findAll();
    }

    @Test
    void testGetClinicalById() throws ClinicDoesNotExistException {
        int id = 1;
        Clinic clinical = new Clinic();
        // Set clinical properties

        when(clinicRepo.findById(id)).thenReturn(Optional.of(clinical));

        Clinic result = clinicService.getClinicalById(id);

        assertEquals(clinical, result);
        verify(clinicRepo, times(1)).findById(id);
    }

    @Test
    void testGetClinicalById_ClinicDoesNotExistException() {
        int id = 1;

        when(clinicRepo.findById(id)).thenReturn(Optional.empty());

        assertThrows(ClinicDoesNotExistException.class, () -> clinicService.getClinicalById(id));
        verify(clinicRepo, times(1)).findById(id);
    }

    @Test
    void testDeleteClinicalById() throws ClinicDoesNotExistException {
        int id = 1;

        clinicService.deleteClinicalById(id);

        verify(clinicRepo, times(1)).deleteById(id);
    }

    @Test
    void testDeleteClinicalById_ClinicDoesNotExistException() {
        int id = 1;

        doThrow(new RuntimeException()).when(clinicRepo).deleteById(id);

        assertThrows(ClinicDoesNotExistException.class, () -> clinicService.deleteClinicalById(id));
        verify(clinicRepo, times(1)).deleteById(id);

    
}
}

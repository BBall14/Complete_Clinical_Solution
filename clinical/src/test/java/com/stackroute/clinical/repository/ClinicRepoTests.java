package com.stackroute.clinical.repository;

// write JUnit5 test cases for all the methods in this ClinicRepo class using Mockito
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

import com.stackroute.clinical.model.Clinic;
import com.stackroute.clinical.service.ClinicService;

public class ClinicRepoTests {

     @Mock
    private ClinicRepo clinicRepo;

    @InjectMocks
    private ClinicService clinicService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave_ReturnsSavedClinic() {
        Clinic clinic = new Clinic();
        // Set clinic properties

        when(clinicRepo.save(clinic)).thenReturn(clinic);

        Clinic result = clinicRepo.save(clinic);

        assertEquals(clinic, result);
        verify(clinicRepo, times(1)).save(clinic);
    }

    @Test
    void testGetAll_ReturnsAllClinics() {
        // Create a list of clinics
        List<Clinic> clinics = new ArrayList<>();
        // Add clinics to the list

        when(clinicRepo.findAll()).thenReturn(clinics);

        List<Clinic> result = clinicRepo.findAll();

        assertEquals(clinics, result);
        verify(clinicRepo, times(1)).findAll();
    }

    @Test
    void testGetById_ReturnsClinic() {
        int id = 1;
        Clinic clinic = new Clinic();
        // Set clinic properties

        Optional<Clinic> optionalClinic = Optional.of(clinic);
        when(clinicRepo.findById(id)).thenReturn(optionalClinic);

        Optional<Clinic> result = clinicRepo.findById(id);

        assertTrue(result.isPresent());
        assertEquals(clinic, result.get());
        verify(clinicRepo, times(1)).findById(id);
    }

    @Test
    void testGetById_ReturnsEmptyOptional() {
        int id = 1;

        when(clinicRepo.findById(id)).thenReturn(Optional.empty());

        Optional<Clinic> result = clinicRepo.findById(id);

        assertFalse(result.isPresent());
        verify(clinicRepo, times(1)).findById(id);
    }

    @Test
    void testDeleteById_VerifyDeletion() {
        int id = 1;

        clinicRepo.deleteById(id);

        verify(clinicRepo, times(1)).deleteById(id);
    }
    
}

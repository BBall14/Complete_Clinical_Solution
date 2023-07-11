package com.stackroute.clinical.controller;

// write JUnit5 test cases for all the methods in this ClinicController class using Mockito
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

import com.stackroute.clinical.exception.ClinicAlreadyExistsException;
import com.stackroute.clinical.exception.ClinicDoesNotExistException;
import com.stackroute.clinical.model.Clinic;
import com.stackroute.clinical.service.ClinicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClinicControllerTests {
    @Mock
    private ClinicService clinicService;

    @InjectMocks
    private ClinicController clinicController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClinical_ReturnsCreatedResponse() throws ClinicAlreadyExistsException {
        Clinic clinical = new Clinic();
        // Set clinical properties

        ResponseEntity<?> expectedResponse = new ResponseEntity<>("clinical details saved successfully", HttpStatus.CREATED);

        doNothing().when(clinicService).saveClinical(clinical);

        ResponseEntity<?> result = clinicController.saveClinical(clinical);

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).saveClinical(clinical);
    }

    @Test
    void testSaveClinical_ReturnsConflictResponse() throws ClinicAlreadyExistsException {
        Clinic clinical = new Clinic();
        // Set clinical properties

        ResponseEntity<?> expectedResponse = new ResponseEntity<>("Clinic Already Exists", HttpStatus.CONFLICT);

        doThrow(ClinicAlreadyExistsException.class).when(clinicService).saveClinical(clinical);

        ResponseEntity<?> result = clinicController.saveClinical(clinical);

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).saveClinical(clinical);
    }

    @Test
    void testGetAllClinical_ReturnsNotFoundResponse() throws ClinicDoesNotExistException {
        ResponseEntity<?> expectedResponse = new ResponseEntity<>("Clinic Does Not Exist", HttpStatus.NOT_FOUND);

        doThrow(ClinicDoesNotExistException.class).when(clinicService).getAllClinical();

        ResponseEntity<?> result = clinicController.getAllClinical();

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).getAllClinical();
    }

    @Test
    void testGetClinicalById_ReturnsOkResponse() throws ClinicDoesNotExistException {
        int id = 1;
        Clinic expectedClinical = new Clinic();
        // Set expected clinical properties

        ResponseEntity<?> expectedResponse = new ResponseEntity<>(expectedClinical, HttpStatus.OK);

        doReturn(expectedClinical).when(clinicService).getClinicalById(id);

        ResponseEntity<?> result = clinicController.getClinicalById(id);

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).getClinicalById(id);
    }

    @Test
    void testGetClinicalById_ReturnsNotFoundResponse() throws ClinicDoesNotExistException {
        int id = 1;

        ResponseEntity<?> expectedResponse = new ResponseEntity<>("Clinic Does Not Exist", HttpStatus.NOT_FOUND);

        doThrow(ClinicDoesNotExistException.class).when(clinicService).getClinicalById(id);

        ResponseEntity<?> result = clinicController.getClinicalById(id);

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).getClinicalById(id);
    }

    @Test
    void testUpdateClinicalById_ReturnsOkResponse() throws ClinicDoesNotExistException {
        int id = 1;
        Clinic clinical = new Clinic();
        // Set clinical properties

        ResponseEntity<String> expectedResponse = ResponseEntity.ok("Clinical Details Updated Successfully");

        doNothing().when(clinicService).updateClinicalById(id, clinical);

        ResponseEntity<String> result = clinicController.updateClinicalById(id, clinical);

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).updateClinicalById(id, clinical);
    }

    @Test
    void testUpdateClinicalById_ReturnsNotFoundResponse() throws ClinicDoesNotExistException {
        int id = 1;
        Clinic clinical = new Clinic();
        // Set clinical properties

        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Clinic Does Not Exist");

        doThrow(ClinicDoesNotExistException.class).when(clinicService).updateClinicalById(id, clinical);

        ResponseEntity<String> result = clinicController.updateClinicalById(id, clinical);

        assertEquals(expectedResponse, result);
        verify(clinicService, times(1)).updateClinicalById(id, clinical);
    }
}


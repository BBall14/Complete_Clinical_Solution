package com.stackroute.clinical.controller;


// write JUnit5 test cases for all the methods in this UserController class using Mockito
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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.stackroute.clinical.jwtConfig.JwtGenerator;
import com.stackroute.clinical.model.ClinicUser;
import com.stackroute.clinical.service.UserService;


public class UserControllerTests {

       @Mock
    private UserService userService;

    @Mock
    private JwtGenerator jwtGenerator;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser_ReturnsSuccessResponse() {
        ClinicUser user = new ClinicUser();
        // Set user properties

        ResponseEntity<?> expectedResponse = new ResponseEntity<>("User details saved successfully", HttpStatus.CREATED);

        doNothing().when(userService).saveUser(user);

        ResponseEntity<?> result = userController.saveUser(user);

        assertEquals(expectedResponse, result);
        verify(userService, times(1)).saveUser(user);
    }


    @Test
    void testLoginUser_ReturnsBadRequestResponse() {
        ClinicUser user = new ClinicUser();
        user.setUserName(null);
        user.setPassword(null);

        ResponseEntity<?> expectedResponse = new ResponseEntity<>("User Name or Password cannot be empty", HttpStatus.BAD_REQUEST);

        ResponseEntity<?> result = userController.loginUse(user);

        assertEquals(expectedResponse, result);
        verifyNoInteractions(userService);
    }

    @Test
    void testGetRestrictedMessage_ReturnsRestrictedMessage() {
        ResponseEntity<?> expectedResponse = new ResponseEntity<>("This is a restricted message", HttpStatus.OK);

        ResponseEntity<?> result = userController.getRestrictedMessage();

        assertEquals(expectedResponse, result);
        verifyNoInteractions(userService);
    }
}

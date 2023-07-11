// package com.stackroute.clinical.repository;

// // write JUnit5 test cases for all the methods in this UserRepository class using Mockito
// // and assert the results using JUnit5 assertions
// // Use @Mock and @InjectMocks annotations to create mocks and inject them into the ClinicController class
// // Use @BeforeEach annotation to create mocks and inject them into the ClinicController class
// // Use @Test annotation to write test cases for all the methods in this ClinicController class
// // Use assertEquals() and assertNull() methods to assert the results
// // Use verify() method to verify the results
// // Use doNothing() method to mock void methods
// // Use when() method to mock methods that return something
// // Use doThrow() method to mock methods that throw exceptions
// // Use doReturn() method to mock methods that return something
// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import com.stackroute.clinical.model.ClinicUser;
// import com.stackroute.clinical.service.UserService;

// public class UserRepositoryTests {
    
//     @Mock
//     private UserRepository userRepository;

//     @InjectMocks
//     private UserService userService;

//     @BeforeEach
//     void setup() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testGetUserByUserNameAndUserPassword_ReturnsUser() {
//         String userName = "test";
//         String userPassword = "password";
//         ClinicUser user = new ClinicUser();
//         // Set user properties

//         when(userRepository.getUserByUserNameAndUserPassword(userName, userPassword)).thenReturn(user);

//         ClinicUser result = userRepository.getUserByUserNameAndUserPassword(userName, userPassword);

//         assertEquals(user, result);
//         verify(userRepository, times(1)).getUserByUserNameAndUserPassword(userName, userPassword);
//     }

//     @Test
//     void testGetUserByUserNameAndUserPassword_ReturnsNull() {
//         String userName = "test";
//         String userPassword = "password";

//         when(userRepository.getUserByUserNameAndUserPassword(userName, userPassword)).thenReturn(null);

//         ClinicUser result = userRepository.getUserByUserNameAndUserPassword(userName, userPassword);

//         assertNull(result);
//         verify(userRepository, times(1)).getUserByUserNameAndUserPassword(userName, userPassword);
//     }


// }

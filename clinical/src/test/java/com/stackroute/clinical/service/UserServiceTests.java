// package com.stackroute.clinical.service;

// // write JUnit5 test cases for all the methods in this UserService class using Mockito
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

// import com.stackroute.clinical.exception.UserNotFoundException;
// import com.stackroute.clinical.model.ClinicUser;
// import com.stackroute.clinical.repository.UserRepository;


// public class UserServiceTests {

//       @Mock
//     private UserRepository userRepository;

//     @InjectMocks
//     private UserService userService;

//     @BeforeEach
//     void setup() {
//         MockitoAnnotations.openMocks(this);
//     }

//     @Test
//     void testSaveUser() {
//         ClinicUser user = new ClinicUser();
//         // Set user properties

//         userService.saveUser(user);

//         verify(userRepository, times(1)).save(user);
//     }

//     @Test
//     void testGetUserByNameAndPassword() throws UserNotFoundException {
//         String name = "john";
//         String password = "password";

//         ClinicUser user = new ClinicUser();
//         // Set user properties

//         when(userRepository.getUserByUserNameAndUserPassword(name, password)).thenReturn(user);

//         ClinicUser result = userService.getUserByuserNameAnduserPassword(name, password);

//         assertEquals(user, result);
//         verify(userRepository, times(1)).getUserByUserNameAndUserPassword(name, password);
//     }

//     @Test
//     void testGetUserByNameAndPassword_UserNotFoundException() {
//         String name = "john";
//         String password = "password";

//         when(userRepository.getUserByUserNameAndUserPassword(name, password)).thenReturn(null);

//         assertThrows(UserNotFoundException.class, () -> userService.getUserByuserNameAnduserPassword(name, password));
//         verify(userRepository, times(1)).getUserByUserNameAndUserPassword(name, password);
//     }
    
// }

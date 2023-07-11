package com.stackroute.clinical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.clinical.exception.UserNotFoundException;
import com.stackroute.clinical.jwtConfig.JwtGenerator;
import com.stackroute.clinical.model.ClinicUser;
import com.stackroute.clinical.service.UserService;

// Annotate class with @RestController @RequestMapping annotation 

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

    // Autowire UserService
    @Autowired
    private UserService userService;

    // Autowire JwtGenerator
    @Autowired
    private JwtGenerator jwtGenerator;

    // create postMapping to store user details in database
    // return response entity
    // add try catch block to handle exception and throw UserAlreadyExistsException
    // if user details already exists
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody ClinicUser user) {
        try {
            userService.saveUser(user);
            
            
            return new ResponseEntity<>(user, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    // create postMapping to get user details by name and password from database
    // return response entity
    // add try catch block to handle exception and throw UserNotFoundException
    // if user details not found
    @PostMapping("/login")
    public ResponseEntity<?> loginUse(@RequestBody ClinicUser user) {
        try {
            if (user.getUserName() == null || user.getPassword() == null) {
                throw new UserNotFoundException("UserName or Password cannot be empty");
            }
            ClinicUser userData = userService.getUserByuserNameAndpassword(user.getUserName(), user.getPassword());

            if (userData == null) {
                throw new UserNotFoundException("User Not Found");
            } 
            return new ResponseEntity<>(jwtGenerator.generateToken(userData), HttpStatus.OK);    
            } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

        @GetMapping("/restricted")
    public ResponseEntity<?> getRestrictedMessage() {
        return new ResponseEntity<>("This is a restricted message", HttpStatus.OK);
    }

}

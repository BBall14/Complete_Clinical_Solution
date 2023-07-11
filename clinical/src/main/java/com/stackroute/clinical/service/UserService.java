package com.stackroute.clinical.service;

import org.springframework.beans.factory.annotation.Autowired;

// Annotate this class with @Service annotation

import org.springframework.stereotype.Service;

import com.stackroute.clinical.exception.UserNotFoundException;
import com.stackroute.clinical.model.ClinicUser;
import com.stackroute.clinical.repository.UserRepository;


@Service
public class UserService {

    
    // Autowire the UserRepository 
    @Autowired
    private UserRepository userRepository;

    // create a method to save user details in database
    // use userRepository.save() method to save user details in database
    public void saveUser(ClinicUser user) {
        userRepository.save(user);
    }

    //  method to get user by getUserByNameAndPassword from database
    // use userRepository.getUserByNameAndPassword() method to get user by getUserByNameAndPassword from database
    public ClinicUser getUserByuserNameAndpassword(String userName, String password) throws UserNotFoundException {
      
        ClinicUser user = userRepository.findByUserName(userName);

        if(user == null) {
            throw new UserNotFoundException("User with given name does not exists");
        }
        return user;
    }
    
}

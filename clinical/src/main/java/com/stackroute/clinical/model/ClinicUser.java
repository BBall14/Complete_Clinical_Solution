package com.stackroute.clinical.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Annotation to declare ClinicUser class as an entity
// use @Table annotation to declare table name as clinicuser

@Entity
@Table(name = "clinicuser")
public class ClinicUser {

    //  declare variables userID, userName and password
    // use @Id annotation to declare userID as primary key
    // use @GeneratedValue annotation to auto generate userID

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private int userID;
    private String userName;
    private String password;

    //  create default constructor
    public ClinicUser() {
    }

    // create parameterized constructor
    public ClinicUser(int userID, String userName, String password) {
        super();
        this.userID = userID;
        this.userName = userName;
        this.password = password;
    }

    // generate getters and setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    // generate getters and setters for userName and password
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    } 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // add toString() method
    @Override
    public String toString() {
        return "ClinicUser [userID=" + userID + ", userName=" + userName + ", password=" + password + "]";
    }
    
}
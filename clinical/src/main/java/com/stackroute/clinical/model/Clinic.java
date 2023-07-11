package com.stackroute.clinical.model;

import javax.persistence.Entity;
import javax.persistence.Id;


// annotation @Entity to class Clinical

@Entity
public class Clinic {

    // declare variable id autom increment , name , description, duration, targetPopulation, status, TrailStartDate, TrailEndDate, TrailEndDate
    
    // annotation @Id to id variable

    @Id
    private int id;
    private String name;
    private String description;
    private int duration;
    private String targetPopulation;
    private String status;
    private String TrailStartDate;
    private String TrailEndDate;
    private String TrailPhase;
    
    // default constructor
    public Clinic() {
    }

    // parameterized constructor
    public Clinic(int id, String name, String description, int duration, String targetPopulation, String status,
            String trailStartDate, String trailEndDate, String trailPhase) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.targetPopulation = targetPopulation;
        this.status = status;
        TrailStartDate = trailStartDate;
        TrailEndDate = trailEndDate;
        TrailPhase = trailPhase;
    }
    
    // getter and setter methods
    public int getId() {
        return id;
    }

    public String getTrailPhase() {
        return TrailPhase;
    }

    public void setTrailPhase(String trailPhase) {
        TrailPhase = trailPhase;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrailStartDate() {
        return TrailStartDate;
    }

    public void setTrailStartDate(String trailStartDate) {
        TrailStartDate = trailStartDate;
    }

    public String getTrailEndDate() {
        return TrailEndDate;
    }

    public void setTrailEndDate(String trailEndDate) {
        TrailEndDate = trailEndDate;
    }

    public String getName() {
        return name;
    }

    public String getTargetPopulation() {
        return targetPopulation;
    }

    public void setTargetPopulation(String targetPopulation) {
        this.targetPopulation = targetPopulation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Clinical [TrailEndDate=" + TrailEndDate + ", TrailStartDate=" + TrailStartDate + ", description="
                + description + ", duration=" + duration + ", id=" + id + ", name=" + name + ", status=" + status
                + ", targetPopulation=" + targetPopulation + "]";
    }
    
    
}

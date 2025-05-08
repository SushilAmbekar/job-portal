package com.example.job_portal.model;

import jakarta.persistence.*;

// This class maps to a "Job" table in the H2 database
@Entity
public class Job {

    // Primary key: Auto-generated ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Job title (e.g., Software Engineer)
    private String title;

    // Company name (e.g., Google, Infosys)
    private String company;

    // Job description
    private String description;

    // Job location (e.g., Pune, Remote)
    private String location;

    // ==== Getters and Setters ====

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}

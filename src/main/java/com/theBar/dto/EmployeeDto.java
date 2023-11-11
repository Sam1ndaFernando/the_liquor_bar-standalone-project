package com.theBar.dto;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EmployeeDto {
    private String empID;
    private String name;
    private String address;
    private String contact;
    private String jobRole;

    public EmployeeDto(String id, String name, String address, String contact, String jobRole) {


    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }
}

package com.theBar.dto.tm;

public class EmployeeTm {
    private String empId;
    private String name;
    private String address;
    private String contact;
    private String jobRole;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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
    public EmployeeTm(String empId, String name, String address, String contact, String jobRole) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.jobRole = jobRole;
    }
    public EmployeeTm() {
    }

    @Override
    public String toString() {
        return "EmployeeTm{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", jobRole='" + jobRole + '\'' +
                '}';
    }

}

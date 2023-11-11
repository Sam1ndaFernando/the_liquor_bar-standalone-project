package com.theBar.dto;

public class CustomerDto {
    private String cusId;
    private String cusName;
    private String cusAddress;
    private String cusContactNumber;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public String getCusContactNumber() {
        return cusContactNumber;
    }

    public void setCusContactNumber(String cusContactNumber) {
        this.cusContactNumber = cusContactNumber;
    }

    public CustomerDto(String cusId, String cusName, String cusAddress, String cusContactNumber) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.cusContactNumber = cusContactNumber;
    }

    public CustomerDto() {
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusAddress='" + cusAddress + '\'' +
                ", cusContactNumber='" + cusContactNumber + '\'' +
                '}';
    }
}

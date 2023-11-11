package com.theBar.dto.tm;

import com.theBar.dto.CustomerDto;

public class CustomerTm  {
    private String Id;
    private String Name;
    private String Address;
    private String ContactNumber;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
    public CustomerTm() {
    }
    public CustomerTm(String id, String name, String address, String contactNumber) {
        Id = id;
        Name = name;
        Address = address;
        ContactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "CustomerTm{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", ContactNumber='" + ContactNumber + '\'' +
                '}';
    }
}

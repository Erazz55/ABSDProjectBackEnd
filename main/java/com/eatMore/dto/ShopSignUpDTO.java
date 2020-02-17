package com.eatMore.dto;

public class ShopSignUpDTO {
    private String name;
    private String email;
    private String contactNo;
    private String contactPersonName;
    private String password;

    public ShopSignUpDTO() {
    }

    public ShopSignUpDTO(String name, String email, String contactNo, String contactPersonName, String password) {
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPersonName = contactPersonName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

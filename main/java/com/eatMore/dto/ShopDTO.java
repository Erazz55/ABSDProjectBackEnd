package com.eatMore.dto;

public class ShopDTO {

    private Integer id;
    private String name;
    private String email;
    private String contactNo;
    private String contactPersonName;

    public ShopDTO() {
    }

    public ShopDTO(Integer id, String name, String email, String contactNo, String contactPersonName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPersonName = contactPersonName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

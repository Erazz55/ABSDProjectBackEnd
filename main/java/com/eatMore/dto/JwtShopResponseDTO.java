package com.eatMore.dto;

import java.io.Serializable;

public class JwtShopResponseDTO implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
    private final String name;
    private final String email;
    private final String contactNo;
    private final String contactPersonName;

    public JwtShopResponseDTO(String jwtToken, String name, String email, String contactNo, String contactPersonName) {
        this.jwtToken = jwtToken;
        this.name = name;
        this.email = email;
        this.contactNo = contactNo;
        this.contactPersonName = contactPersonName;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }
}

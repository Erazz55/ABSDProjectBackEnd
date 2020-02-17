package com.eatMore.dto;

import java.io.Serializable;

public class JwtShopRequestDTO implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String email;
    private String password;

    public JwtShopRequestDTO() {
    }

    public JwtShopRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

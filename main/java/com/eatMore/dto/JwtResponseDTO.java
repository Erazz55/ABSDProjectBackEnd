package com.eatMore.dto;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;


    public JwtResponseDTO(String jwtToken) {
        this.jwtToken = jwtToken;

    }

    public String getJwtToken() {
        return this.jwtToken;
    }



}

package com.eatMore.dto;

public class SignUpDTO {

    private String username;
    private String email;
    private String password;


    public SignUpDTO(String username,String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public SignUpDTO(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    @Override
    public String toString() {
        return "SignUpDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

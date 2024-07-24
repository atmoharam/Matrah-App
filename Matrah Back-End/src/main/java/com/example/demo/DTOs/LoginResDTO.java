package com.example.demo.DTOs;

public class LoginResDTO {
    private String username;
    private int Id;

    private String role;
    private String Token;

    public LoginResDTO() {
    }

    public LoginResDTO(String username, int id, String role, String token) {
        this.username = username;
        Id = id;
        this.role = role;
        Token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}

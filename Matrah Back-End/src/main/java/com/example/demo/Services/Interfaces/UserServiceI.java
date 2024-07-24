package com.example.demo.Services.Interfaces;

import com.example.demo.Entites.User;

import java.util.List;

public interface UserServiceI {
    public User getUserById(int id);
    public User getUserByEmail(String email);
    public User getUserByUserName(String userName);
    public List<User> getAllUsers();
    public User createUser(User _user);
    public User updateUser(int id , User _user);
    public boolean deleteUser(int id);
}

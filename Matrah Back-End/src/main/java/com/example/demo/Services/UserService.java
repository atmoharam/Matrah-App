package com.example.demo.Services;

import com.example.demo.Entites.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.Interfaces.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceI {

    @Autowired
    private UserRepository userRepository;

    @Override
//    @Cacheable(value = "user", key = "#id")
    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
//    @Cacheable(value = "user", key = "#email")
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
//    @Cacheable(value = "user", key = "#userName")
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
//    @Cacheable(value = "user")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User createUser(User _user) {
        if (_user.getPassword() != null) {
            _user.setPassword(new BCryptPasswordEncoder().encode(_user.getPassword()));
            return userRepository.save(_user);
        }
        return null;
    }

    @Override
    public User updateUser(int id, User _user) {
        User foundedUser = userRepository.findById(id);
        foundedUser.setUserName(_user.getUserName());
        foundedUser.setEmail(_user.getEmail());
        foundedUser.setPassword(new BCryptPasswordEncoder().encode(_user.getPassword()));
        return userRepository.save(foundedUser);

    }

    @Override
//    @CacheEvict(value = "user", key = "#id")
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.demo.Repositories;

import com.example.demo.Entites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findById(int id);
    public User findByEmail(String email);
    public User findByUserName(String userName);
//    public User findByBannedNotAndEmail(Boolean banned, String email);
}

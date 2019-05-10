package com.example.safaricomHackathon.repository;

import com.example.safaricomHackathon.model.UserModel;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserModel, Integer> {
    UserModel findByUsername(String username);
}

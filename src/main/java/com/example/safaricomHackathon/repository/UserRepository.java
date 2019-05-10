package com.example.safaricomHackathon.repository;

import com.example.safaricomHackathon.model.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
    List<UserModel> findByUserName(String username);
}

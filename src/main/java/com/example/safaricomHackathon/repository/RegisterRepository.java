package com.example.safaricomHackathon.repository;

import com.example.safaricomHackathon.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<UserModel, Long> {

}

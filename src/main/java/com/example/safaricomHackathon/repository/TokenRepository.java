package com.example.safaricomHackathon.repository;

import com.example.safaricomHackathon.model.TokenModel;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<TokenModel, String> {
}

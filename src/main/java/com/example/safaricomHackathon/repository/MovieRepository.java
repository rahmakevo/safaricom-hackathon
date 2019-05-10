package com.example.safaricomHackathon.repository;

import com.example.safaricomHackathon.model.MovieModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieModel, Integer> {
}

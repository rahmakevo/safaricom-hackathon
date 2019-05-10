package com.example.safaricomHackathon.repository;

import com.example.safaricomHackathon.model.MovieModel;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieModel, Long> {
}

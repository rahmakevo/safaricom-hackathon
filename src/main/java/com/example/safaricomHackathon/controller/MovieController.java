package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("save/movies")
    public String saveMovies(MovieModel movieModel) {
        movieRepository.save(movieModel);
        return "index";
    }
}

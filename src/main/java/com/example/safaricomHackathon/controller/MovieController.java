package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("save/movies")
    public String saveMovies(@RequestHeader() MovieModel movieModel) {
        movieRepository.save(movieModel);
        return "index";
    }
}

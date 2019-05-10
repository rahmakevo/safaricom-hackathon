package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.repository.MovieRepository;
import com.example.safaricomHackathon.repository.TokenRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;
    private TokenRepository tokenRepository;

    @PostMapping("save/movies")
    public String saveMovies(@RequestHeader("access-token") MovieModel movieModel) {
        JsonObject mResponseObject = new JsonObject();
        movieRepository.save(movieModel);
        mResponseObject.addProperty("status", "200");
        mResponseObject.addProperty("message", "Data has been saved successfully");
        return String.valueOf(mResponseObject);
    }
}

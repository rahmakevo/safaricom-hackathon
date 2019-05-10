package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.ApiResponse;
import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.model.TokenModel;
import com.example.safaricomHackathon.repository.MovieRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("save/movies")
    public String saveMovies(@RequestBody String access_token, MovieModel movieModel) {
        JsonObject mResponseObject = new JsonObject();
        if (new TokenModel(access_token).getToken().equals(access_token)) {
            movieRepository.save(movieModel);
            mResponseObject.addProperty("status", "200");
            mResponseObject.addProperty("message", "Data has been saved successfully");
        } else {
            mResponseObject.addProperty("status", "200");
            mResponseObject.addProperty("message", "You don't have access to use this service");
        }
        return String.valueOf(mResponseObject);
    }

    @GetMapping("saved/reviews")
    public Iterable<MovieModel> getAllMovies() {
        return movieRepository.findAll();
    }

    @DeleteMapping("deleteAll")
    public String deleteAll() {
        movieRepository.deleteAll();
        JsonObject mResponseObject = new JsonObject();
        mResponseObject.addProperty("status", "200");
        mResponseObject.addProperty("message", "Data has been deleted successfully");
        return String.valueOf(mResponseObject);
    }

}

package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.constants.Constants;
import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.repository.MovieRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("save/movies")
    public String saveMovies(@RequestBody String accessToken, MovieModel movieModel) {
        JsonObject mResponseObject = new JsonObject();
        Constants mConstant = new Constants();
        String token = mConstant.token;
        if (token.equals(accessToken)) {
            movieRepository.save(movieModel);
            mResponseObject.addProperty("status", "200");
            mResponseObject.addProperty("message", "Data has been saved successfully");
        } else {
            mResponseObject.addProperty("status", "200");
            mResponseObject.addProperty("message", "You do not have access to this service");
        }


        return String.valueOf(mResponseObject);
    }

    @GetMapping("saved/reviews")
    public Iterable<MovieModel> getAllMovies() {
        return movieRepository.findAll();
    }

    @DeleteMapping("deleteAll")
    public String deleteAll(@RequestBody String accessToken) {
        JsonObject mResponseObject = new JsonObject();
        Constants mConstant = new Constants();
        String token = mConstant.token;

        if (token.equals(accessToken)) {
            movieRepository.deleteAll();
            mResponseObject.addProperty("status", "200");
            mResponseObject.addProperty("message", "Data has been deleted successfully");
        } else {
            mResponseObject.addProperty("status", "200");
            mResponseObject.addProperty("message", "You do not have access to this service");
        }
        return String.valueOf(mResponseObject);
    }

}

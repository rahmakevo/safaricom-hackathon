package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.ApiResponse;
import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.repository.MovieRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Controller
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("save/movies")
    public String saveMovies(MovieModel movieModel) {
        JsonObject mResponseObject = new JsonObject();
        movieRepository.save(movieModel);
        mResponseObject.addProperty("status", "200");
        mResponseObject.addProperty("message", "Data has been saved successfully");
        return String.valueOf(mResponseObject);
    }

    @GetMapping("saved/reviews")
    public Iterable<MovieModel> getAllMovies() {
        return new ApiResponse(HttpStatus.OK.value(), "Movie Review List Fetched Successfuly", movieRepository.findAll());
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

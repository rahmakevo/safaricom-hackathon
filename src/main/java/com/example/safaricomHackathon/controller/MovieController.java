package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.MovieModel;
import com.example.safaricomHackathon.model.TokenModel;
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
        String message;
        JsonObject mResponseObject = new JsonObject();


//        if ("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJrc2l1bmR1IiwiaWF0IjoxNTU3NDgzMjAxLCJzdWIiOiJyZWdpc3RlciIsImlzcyI6ImtzaXVuZHUiLCJleHAiOjE1NTc0ODMyMzd9.TLns--tDXx0zcdpfxrVW_4nqx0j4AOiPBlzXKM7YTFU".equals(tokenRepository.findAll())) {
//            movieRepository.save(movieModel);
//
//        } else {
//            message = "You don't have access to this service";
//        }
        message = String.valueOf(tokenRepository.findAll());
        mResponseObject.addProperty("status", "200");
        mResponseObject.addProperty("message", message);
        return String.valueOf(mResponseObject);
    }
}

package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.config.TokenHandler;
import com.example.safaricomHackathon.model.UserModel;
import com.example.safaricomHackathon.repository.UserRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("register/user")
    public String registerUser(UserModel userModel) {
        userRepository.save(userModel);
        long ttlMillis = 36000;
        TokenHandler mtoken = new TokenHandler();
        String mToken = mtoken.createJWT(userModel.getPassword(), userModel.getUsername(), "register", ttlMillis);
        JsonObject mObject = new JsonObject();
        mObject.addProperty("status", "200");
        mObject.addProperty("access_token", mToken);
        return String.valueOf(mObject);
    }
}

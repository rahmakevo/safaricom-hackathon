package com.example.safaricomHackathon.controller;

import com.example.safaricomHackathon.model.UserModel;
import com.example.safaricomHackathon.repository.RegisterRepository;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    RegisterRepository registerRepository;

    @PostMapping("register/user")
    public String registerUser(UserModel userModel) {
        registerRepository.save(userModel);
        long ttlMillis = 36000;
//        TokenHandler mToken = new TokenHandler();
//        String mToke = mToken.createJWT("regrequest", userModel.getUsername(), "registration", ttlMillis);
        JsonObject mResponseObject = new JsonObject();
        mResponseObject.addProperty("status", "200");
        mResponseObject.addProperty("access_token", "cvhjuteieh");
        return String.valueOf(mResponseObject);
    }
}

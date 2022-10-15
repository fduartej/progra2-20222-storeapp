package com.acme.storeapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.acme.storeapp.integration.sendgrid.*;
import com.acme.storeapp.integration.spotity.*;

@Controller
public class MessageController {
    private final SpotifyAPI spotifyAPI;
    private final SendGridAPI sendGridAPI;

    public MessageController(SpotifyAPI spotifyAPI,SendGridAPI sendGridAPI ){
        this.spotifyAPI = spotifyAPI;
        this.sendGridAPI = sendGridAPI;
    }

    @GetMapping("/message/send")
    public String index(Model model) {
        spotifyAPI.me();
        sendGridAPI.send("fduartej@usmp.pe","fduartej@gmail.com","test","test");
        return "index";
    }

}

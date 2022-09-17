package com.acme.storeapp.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;


@Controller
public class HomeController {
    
    private static final String HOME_INDEX ="welcome"; 

    @GetMapping("/")
    public String index(Model model) {
        return HOME_INDEX;
    }

}

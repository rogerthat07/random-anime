package com.random.anime.controller;

import com.random.anime.model.ResponsePojo;
import com.random.anime.tools.api.KitsuApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomAnimeWebController {

    @Autowired
    private KitsuApi api;
    
    @GetMapping("/")
    public ModelAndView home(){
        ResponsePojo responsePojo = api.fetchAnime();
        System.out.println(responsePojo);
        return new ModelAndView("home");
    }
}

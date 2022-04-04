package com.random.anime.controller;

import java.util.Random;

import com.random.anime.model.Attributes;
import com.random.anime.model.CoverImage;
import com.random.anime.model.ResponsePojo;
import com.random.anime.tools.api.KitsuApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomAnimeWebController {

    @Autowired
    private KitsuApi api;
    private Integer OFFSET=17713;
    private String URL="https://kitsu.io/api/edge/anime?sort=popularityRank&page[limit]=1&page[offset]=";
    
    @GetMapping("/")
    public ModelAndView home(Model model){
        Random random = new Random();
        int offset = random.nextInt(OFFSET)+1;
        ResponsePojo responsePojo = api.fetchAnime(URL, offset);
        System.out.println(responsePojo);
        String description = responsePojo.getData().get(0).getAttributes().getDescription();
        String poster = responsePojo.getData().get(0).getAttributes().getPosterImage().getOriginal();
        String cover = responsePojo.getData().get(0).getAttributes().getCoverImage().getOriginal();
        OFFSET = responsePojo.getMeta().getCount();
        Attributes attributes = responsePojo.getData().get(0).getAttributes();
        model.addAttribute("description", description);
        model.addAttribute("cover", cover);
        model.addAttribute("poster", poster);
        model.addAttribute("anime", attributes);
        return new ModelAndView("home");
    }
}

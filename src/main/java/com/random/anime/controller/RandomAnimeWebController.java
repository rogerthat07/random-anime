package com.random.anime.controller;

import java.util.List;
import java.util.Random;

import com.random.anime.model.Attributes;
import com.random.anime.model.CoverImage;
import com.random.anime.model.Datum;
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
        OFFSET = responsePojo.getMeta().getCount();
        Attributes anime = responsePojo.getData().get(0).getAttributes();
        String streamingLinksURL = responsePojo.getData().get(0).getRelationships().getStreamingLinks().getLinks().getRelated();
        System.out.println("######################################");
        System.out.println("Streaming links : "+streamingLinksURL);
        ResponsePojo responsePojoForLinks = api.fetchStreamingLinks(streamingLinksURL);
        model.addAttribute("anime", anime);
        model.addAttribute("streamingLinks", responsePojoForLinks);
        return new ModelAndView("home");
    }
}

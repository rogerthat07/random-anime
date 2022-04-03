package com.random.anime.tools.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KitsuApi {

    @Autowired
    private RestTemplate restTemplate;
    
}

package com.random.anime.tools.api;

import com.random.anime.model.ResponsePojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class KitsuApi {

    @Autowired
    private RestTemplate restTemplate;
    
    public ResponsePojo fetchAnime(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json, application/vnd.api+json");
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        //ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, param);
        String url = "https://kitsu.io/api/edge/anime?sort=popularityRank&page[limit]=1";
        ResponsePojo response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ResponsePojo.class).getBody();
        return response;
    }
}

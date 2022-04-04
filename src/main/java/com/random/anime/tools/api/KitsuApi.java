package com.random.anime.tools.api;

import com.random.anime.model.CoverImage;
import com.random.anime.model.PosterImage;
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

    public static HttpEntity<Void> getHeaderEnity(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json, application/vnd.api+json");
        return new HttpEntity<>(headers);
    }
    
    public ResponsePojo fetchAnime(String URL, Integer OFFSET){
        HttpEntity<Void> requestEntity = KitsuApi.getHeaderEnity();
        //ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, param);
        String url = URL+OFFSET;
        ResponsePojo responsePojo = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ResponsePojo.class).getBody();
        CoverImage coverImage = responsePojo.getData().get(0).getAttributes().getCoverImage();
        PosterImage posterImage = responsePojo.getData().get(0).getAttributes().getPosterImage();

        responsePojo.getData().get(0).getAttributes().setCoverImage(coverImage==null?new CoverImage().setAllToDefault():coverImage);
        responsePojo.getData().get(0).getAttributes().setPosterImage(posterImage==null?new PosterImage().setAllToDefault():posterImage);
            
        return responsePojo;
    }

    public ResponsePojo fetchStreamingLinks(String URL){
        HttpEntity<Void> requestEntity = KitsuApi.getHeaderEnity();
        ResponsePojo responsePojo = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, ResponsePojo.class).getBody();
        return responsePojo;
    }
}

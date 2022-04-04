package com.random.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Titles {
    private String en;
    @JsonProperty("en_jp")
    private String enJp;
    @JsonProperty("en_us")
    private String enUs;
    @JsonProperty("ja_jp")
    private String jaJp;
}

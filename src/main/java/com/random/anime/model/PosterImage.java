package com.random.anime.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PosterImage implements DefaultImage {
    private String tiny;
    private String large;
    private String small;
    private String original;

    public PosterImage setAllToDefault() {
        this.tiny = DefaultImage.DEFAULT;
        this.large = DefaultImage.DEFAULT;
        this.original = DefaultImage.DEFAULT;
        this.small = DefaultImage.DEFAULT;
        return this;
    }
}

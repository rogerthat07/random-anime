package com.random.anime.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attributes {
    private String slug;
    private String synopsis;
    private String description;
    private Titles titles;
    private String canonicalTitle;
    private List<String> abbreviatedTitles = null;
    private String averageRating;
    private Integer userCount;
    private Integer favoritesCount;
    private String startDate;
    private String endDate;
    private Object nextRelease;
    private Integer popularityRank;
    private Integer ratingRank;
    private String ageRating;
    private String ageRatingGuide;
    private String subtype;
    private String status;
    private String tba;
    private PosterImage posterImage;
    private CoverImage coverImage;
    private Integer episodeCount;
    private Integer episodeLength;
    private Integer totalLength;
    private String youtubeVideoId;
    private String showType;
}

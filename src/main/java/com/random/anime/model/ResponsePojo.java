package com.random.anime.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePojo {
    private List<Datum> data;
    private Meta meta;
    private Links links;
}

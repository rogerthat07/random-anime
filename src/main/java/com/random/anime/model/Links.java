package com.random.anime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Links {
    private String first;
    private String next;
    private String last;
    private String self;
    private String related;
}

package com.kobalthackathon.streamx.test.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Movie {

    @JsonProperty("movieName")
    private String movieName;

    @JsonCreator
    public Movie(@JsonProperty("movieName") String movieName) {
        this.movieName = movieName;
    }
}

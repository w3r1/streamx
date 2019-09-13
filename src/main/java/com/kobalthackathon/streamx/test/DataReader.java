package com.kobalthackathon.streamx.test;

import com.kobalthackathon.streamx.test.domain.Movie;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;

@EnableBinding(Sink.class)
@MessageEndpoint
public class DataReader {

    @StreamListener("movies")
    void logMessage(Movie movie) {
        System.out.println(movie.getMovieName());
    }
}

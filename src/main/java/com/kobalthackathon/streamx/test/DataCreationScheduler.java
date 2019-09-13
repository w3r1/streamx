package com.kobalthackathon.streamx.test;

import com.kobalthackathon.streamx.test.binding.MovieStream;
import com.kobalthackathon.streamx.test.domain.Movie;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;

@EnableBinding(MovieStream.class)
@AllArgsConstructor
public class DataCreationScheduler {

    private final MovieStream stream;

    @Scheduled(fixedRate = 1000)
    private void createAndPostMovie() {
        Movie movie = new Movie("Indiana Jones " + ((int)(Math.random() * 100)));
        stream.source().send(MessageBuilder.withPayload(movie).build());
    }
}

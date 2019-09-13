package com.kobalthackathon.streamx.test;

import com.kobalthackathon.streamx.test.domain.Movie;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@EnableBinding(Source.class)
@EnableScheduling
@AllArgsConstructor
@Service
public class DataCreationScheduler {

    private final Source source;

    @Scheduled(fixedRate = 1000)
    private void createAndPostMovie() {
        Movie movie = new Movie("Indiana Jones " + ((int)(Math.random() * 100)));
        source.output().send(MessageBuilder.withPayload(movie).build());
    }
}

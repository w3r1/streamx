package com.kobalthackathon.streamx.test;

import com.kobalthackathon.streamx.test.domain.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.stereotype.Service;

@EnableBinding(Sink.class)
@MessageEndpoint
@Service
public class DataReader {
    private static final Logger logger = LoggerFactory.getLogger(DataReader.class);

    @StreamListener(Sink.INPUT)
    void logMessage(Movie movie) {
        logger.info(movie.getMovieName());
    }
}

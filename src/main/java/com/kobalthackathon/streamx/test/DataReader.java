package com.kobalthackathon.streamx.test;

import com.kobalthackathon.streamx.test.binding.MovieStream;
import com.kobalthackathon.streamx.test.domain.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.stereotype.Service;

@MessageEndpoint
@Service
public class DataReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataReader.class);

    @StreamListener(MovieStream.SOURCE)
    void logMessage(Movie movie) {
        LOGGER.info(movie.getMovieName());
    }
}

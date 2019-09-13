package com.kobalthackathon.streamx.test;

import com.kobalthackathon.streamx.test.binding.MovieStream;
import com.kobalthackathon.streamx.test.domain.Movie;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableBinding(MovieStream.class)
@AllArgsConstructor
public class DataCreationController {

    private final MovieStream sourceStream;

    @GetMapping("/addmovie")
    public ResponseEntity getAddMovie() {
        Movie movie = new Movie("Indiana Jones " + ((int)(Math.random() * 100)));
        sourceStream.movies().send(MessageBuilder.withPayload(movie).build());

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}

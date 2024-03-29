package com.kobalthackathon.streamx.test.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MovieStream {

    String SOURCE = "movies-in";

    @Output(SOURCE)
    MessageChannel source();
}

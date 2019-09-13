package com.kobalthackathon.streamx.test.binding;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MovieStream {

    @Output
    MessageChannel movies();
}

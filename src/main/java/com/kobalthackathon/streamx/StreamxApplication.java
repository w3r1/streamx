package com.kobalthackathon.streamx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StreamxApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamxApplication.class, args);
	}

}

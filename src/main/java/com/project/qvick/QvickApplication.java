package com.project.qvick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class QvickApplication {

	public static void main(String[] args) {
		SpringApplication.run(QvickApplication.class, args);
	}

}

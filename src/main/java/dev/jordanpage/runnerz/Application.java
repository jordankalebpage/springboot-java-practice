package dev.jordanpage.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.jordanpage.runnerz.run.Location;
import dev.jordanpage.runnerz.run.Run;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return (args) -> {
			Run run = new Run(1, "Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 10,
					Location.OUTDOOR);
			logger.info("Running {}", run);

		};
	}
}

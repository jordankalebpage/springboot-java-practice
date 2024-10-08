package dev.jordanpage.runnerz.run;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RunJsonDataLoader implements CommandLineRunner {
    private static final Logger logger = LoggerFactory
            .getLogger(RunJsonDataLoader.class);
    private final RunRepository runRepository;
    private final ObjectMapper objectMapper;

    public RunJsonDataLoader(RunRepository runRepository) {
        this.runRepository = runRepository;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    public void run(String... args) throws Exception {
        if (runRepository.count() > 0) {
            logger.info("Skipping data load, already loaded");
            return;
        }

        try (InputStream inputStream = TypeReference.class
                .getResourceAsStream("/data/runs.json")) {
            Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
            logger.info("Loaded {} runs", allRuns.runs().size());
            runRepository.saveAll(allRuns.runs());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON data", e);
        }
    }
}

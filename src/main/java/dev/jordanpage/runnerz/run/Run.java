package dev.jordanpage.runnerz.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
        Integer id,
        @NotEmpty String title,
        LocalDateTime startTime,
        LocalDateTime endTime,
        @Positive Integer miles,
        Location location) {

    public Run {
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException(
                    "Start time must be before end time");
        }
    }
}

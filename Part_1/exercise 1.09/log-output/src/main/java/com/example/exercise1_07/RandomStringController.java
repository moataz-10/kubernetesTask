package com.example.exercise1_07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Scanner;
import java.nio.file.Paths;



@RestController
class RandomStringController {
    private final String randomString;

    private Timestamp lastTimestamp;

    public RandomStringController() {
        this.randomString = UUID.randomUUID().toString();

    }

    @GetMapping("/")
    public String getStatus() {
        updateTimestamp();
        String requests=null;

        String result = lastTimestamp + ": " + randomString;
        return result;
    }

    private void updateTimestamp() {
        this.lastTimestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}

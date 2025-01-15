package org.example.logoutput;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;


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
        try(Scanner scanner = new Scanner(Paths.get("shared/file.txt"))){
            requests = scanner.nextLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        String result = lastTimestamp + ": " + randomString+"."+"<br>Ping / Pongs: "+requests;
        return result;
    }

    private void updateTimestamp() {
        this.lastTimestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}

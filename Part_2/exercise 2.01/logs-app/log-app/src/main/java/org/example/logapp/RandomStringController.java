package org.example.logapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.sql.Timestamp;
import java.time.LocalDateTime;

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
        String count = fetchRequestsFromEndpoint();
        String result = lastTimestamp + ": " + randomString+"."+"<br>Ping / Pongs: "+ count;
        return result;
    }

    //to request the count ponds from the other pod
    private String fetchRequestsFromEndpoint() {
        RestTemplate resttemplate = new RestTemplate();

        //here we want to call the service which the pingpong deployment recieves its connections.
        //In addition to the mapping of the endpoint.
        String url = "http://pingpong-svc:2222/getCount";
        try{
            return resttemplate.getForObject(url, String.class);
        } catch (Exception e) {
            return "Error fetching the count";
        }
    }

    private void updateTimestamp() {
        this.lastTimestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
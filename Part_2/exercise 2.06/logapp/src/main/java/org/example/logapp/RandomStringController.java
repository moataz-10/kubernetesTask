package org.example.logapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import java.util.Scanner;
import java.util.UUID;


@RestController
class RandomStringController {

    private final String randomString;
    private Timestamp lastTimestamp;
    //creation of environment variable in spring boot
    @Value("${MESSAGE:default}")
    private String message;

    public RandomStringController() {
        this.randomString = UUID.randomUUID().toString();

    }

    @GetMapping("/")
    public String getStatus() {
        updateTimestamp();
        String count = fetchRequestsFromEndpoint();
        String file = readFile();
        String result = file+"<br> env variable: MESSAGE="+message+"<br>"+lastTimestamp + ": " + randomString+"."+"<br>Ping / Pongs: "+ count;
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
    //to read the file from the config map -> exercise 2.06
    public String readFile(){
        try(Scanner scanner = new Scanner(Paths.get("/shared/information.txt"))){
            return scanner.nextLine();
        }catch(Exception e){
            return "Error reading file";
        }
    }

    private void updateTimestamp() {
        this.lastTimestamp = Timestamp.valueOf(LocalDateTime.now());
    }
}
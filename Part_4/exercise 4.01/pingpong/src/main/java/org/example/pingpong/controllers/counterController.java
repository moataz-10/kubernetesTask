package org.example.pingpong.controllers;

import org.example.pingpong.services.counterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class counterController {
    Integer count;
    @Autowired
    private counterService counterService;
    public counterController() {
        this.count = 0;
    }

    @GetMapping("/pingpong")
    public String counter() {
        this.count = counterService.incrementCounter();
        return "pong "+count;
    }
    //this endpoint is to get the count of pongs for the other web app
    @GetMapping("/getCount")
    public synchronized String getCount() {
        return this.count.toString();
    }

    @GetMapping("/checkDb")
    public synchronized void checkDb() {
        counterService.testDb();
    }
}

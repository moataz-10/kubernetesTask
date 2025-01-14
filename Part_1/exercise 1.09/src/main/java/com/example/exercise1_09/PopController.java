package com.example.exercise1_09;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class PopController {
    private Integer count;
    public PopController() {
        this.count = 0;
    }
    @GetMapping("pingpong")
    public String pingpong() {
        this.count++;
        return "pong "+this.count;

    }
}

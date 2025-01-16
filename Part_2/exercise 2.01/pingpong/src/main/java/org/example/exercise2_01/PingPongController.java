package org.example.exercise2_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@RestController
public class PingPongController {

    private Integer count;
    public PingPongController() {
        count = 0;
    }
    @GetMapping("/pingpong")
    public synchronized String pingpong() {
        this.count++;
        return "pong " + this.count;
    }
    @GetMapping("/getCount")
    public synchronized String getCount() {
        return this.count.toString();
    }
}
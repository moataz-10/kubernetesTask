package org.example.pingpong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@RestController
public class PingPongController {

    private static final String FILE_PATH = "shared/file.txt";
    private Integer count = 0;

    @GetMapping("/pingpong")
    public synchronized String pingpong() {
        Path filePath = Paths.get(FILE_PATH);

        // Ensure file exists before reading
        if (!Files.exists(filePath)) {
            try {
                Files.createDirectories(filePath.getParent()); // Create parent directories if needed
                Files.write(filePath, "0".getBytes()); // Initialize the file with 0
            } catch (Exception e) {
                e.printStackTrace();
                return "Error initializing the file.";
            }
        }

        // Read current count from the file
        try (Scanner scanner = new Scanner(filePath)) {
            if (scanner.hasNextLine()) {
                this.count = Integer.valueOf(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error reading the count.";
        }

        // Increment the count
        this.count++;

        // Write the updated count back to the file
        try (FileWriter writer = new FileWriter(FILE_PATH, false)) {
            writer.write(this.count.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "Error writing the updated count.";
        }

        return "pong " + this.count;
    }
}

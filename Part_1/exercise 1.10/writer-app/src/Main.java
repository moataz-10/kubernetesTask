import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        String filePath = "/shared/timestamp.txt"; // Shared file location

        while (true) {
            try (FileWriter writer = new FileWriter(filePath, false)) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                writer.write(timestamp.toString());
                writer.flush();
                System.out.println(timestamp);
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

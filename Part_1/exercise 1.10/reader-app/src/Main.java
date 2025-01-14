import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        String filePath = "/shared/timestamp.txt"; // Shared file location

        while (true) {
            try {
                // Read the file
                if (new File(filePath).exists()) {
                    String content = Files.readString(Paths.get(filePath));
                    String hash = generateHash(content);

                    System.out.print(content);
                    System.out.println(": " + hash);
                }
                Thread.sleep(5000); // Wait for 5 seconds
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

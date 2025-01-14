import java.sql.Timestamp;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String randomString = UUID.randomUUID().toString();
        while(true) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp+": "+randomString);
            Thread.sleep(5000);
        }
    }
}
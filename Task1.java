
import java.io.FileInputStream;
import java.security.MessageDigest;


public class Task1 {

    public static void main(String[] args) {
        String filePath1 = "src/longfile.txt";
        String filePath2 = "src/shortfile.txt";

        try {
            long startTime1 = System.nanoTime();
            String hash1 = calculateSHA256(filePath1);
            long endTime1 = System.nanoTime();
            double elapsedTime1 = (endTime1 - startTime1) / 1_000_000_000.0;

            long startTime2 = System.nanoTime();
            String hash2 = calculateSHA256(filePath2);
            long endTime2 = System.nanoTime();
            double elapsedTime2 = (endTime2 - startTime2) / 1_000_000_000.0;

            System.out.println("long file SHA-256 Hash: " + hash1);
            System.out.println("long file Time taken: " + elapsedTime1 + " seconds");

            System.out.println("short file SHA-256 Hash: " + hash2);
            System.out.println("short file Time taken: " + elapsedTime2 + " seconds");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String calculateSHA256(String filePath) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[8192];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, bytesRead);
            }
        }

        byte[] hashBytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}


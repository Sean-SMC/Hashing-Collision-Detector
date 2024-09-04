import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class task2 {
    public static void main(String[] args) {
        String targetPattern = "01091";//"01091997"; // birthdate

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] input = new byte[32]; // 256 bits
            int attempts = 0;

            long startTime = System.nanoTime();

            while (true) {
                // Hash the updated input
                md.update(input);
                input = md.digest();


                String inputHex = byteArrayToHexString(input);

                // Check if the first leadingZeros hex digits match the target pattern
                if (inputHex.startsWith(targetPattern)) {
                    long endTime = System.nanoTime();
                    double elapsedTimeInSeconds = (endTime - startTime) / 1_000_000_000.0;

                    System.out.println("Found matching hash: " + inputHex);
                    System.out.println("Attempts: " + attempts);
                    System.out.println("Total time elapsed: " + formatTime(elapsedTimeInSeconds));
                    break;
                }

                // Increment the input by 1
                incrementByteArray(input);
                attempts++;

                // Display progress every 1 million attempts
                if (attempts % 1_000_000 == 0) {
                    System.out.println("Attempts: " + attempts);
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    //  convert byte array to a hexadecimal string
    private static String byteArrayToHexString(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

   //increment  array by 1
    private static void incrementByteArray(byte[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] & 0xFF) < 0xFF) {
                array[i]++;
                break;
            } else {
                array[i] = 0;
            }
        }
    }

    // format time in "mm : ss" format
    private static String formatTime(double seconds) {
        long minutes = (long) (seconds / 60);
        long remainingSeconds = (long) (seconds % 60);
        return String.format("%02d : %02d", minutes, remainingSeconds);
    }
}

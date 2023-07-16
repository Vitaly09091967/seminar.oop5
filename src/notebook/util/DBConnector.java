package notebook.util;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataHasher {
    public static String hash(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(data.getBytes());
            return bytesToHexString(encodedHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                builder.append('0');
            }
            builder.append(hex);
        }
        return builder.toString();
    }
}

public class DBConnector {
    public static final String DB_PATH = "db.txt";
    public static void createDB() {
        try {
            File db = new File(DB_PATH);
            if (db.createNewFile()) {
                System.out.println("DB created");
            }
            else {
                System.out.println("DB already exists");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}

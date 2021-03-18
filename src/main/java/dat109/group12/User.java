package dat109.group12;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private User(String email, String password_hash, String fornavn, String etternavn)
    {
        this.email = email;
        this.password_hash = password_hash;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
    }

    static synchronized User construct(String email, String password, String fornavn, String etternavn)
    {
        String hash = new String(md.digest(password.getBytes(StandardCharsets.UTF_8)));
        return new User(email, hash, fornavn, etternavn);
    }

    static MessageDigest md;

    static {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("THIS MACHINE CAN NOT RUN THE SERVER SECURELY.");
            System.err.println("SHA-256 DIGESTION COULD NOT BE INITIALIZED. ABORT.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    String email;
    String password_hash;
    String fornavn;
    String etternavn;

}

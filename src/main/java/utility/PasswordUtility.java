package utility;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

public class PasswordUtility
{
    private static final int SALT_LENGTH = 24;
    private static final int HASH_ITERATIONS = 1000;

    private static final int KEY_LENGTH = 256; // For PBEKeySpec
    private static final String KEY_FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final String VALID_PASSWORD_PATTERN = "^.{5,}$";

    public static boolean checkPassword(String password, String encryptedPassword)
    {
        if (password == null || !password.matches(VALID_PASSWORD_PATTERN))
        {
            return false;
        }

        byte[] salt = getSaltFromEncryptedPassword(encryptedPassword);
        return encryptWithSalt(salt, password).equals(encryptedPassword);
    }

    public static String encryptPassword(String password) throws IllegalArgumentException
    {
        if (password == null || !password.matches(VALID_PASSWORD_PATTERN))
        {
            throw new IllegalArgumentException("Password does not match valid pattern");
        }

        byte[] salt = generateRandomSalt();
        return encryptWithSalt(salt, password);
    }

    private static String encryptWithSalt(byte[] salt, String password)
    {
        String encrypted = null;

        try
        {
            SecretKeyFactory secretKeyFactory;

            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, HASH_ITERATIONS, KEY_LENGTH);
            secretKeyFactory = SecretKeyFactory.getInstance(KEY_FACTORY_ALGORITHM);
            byte[] keyHash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();

            byte[] keyHashWithSalt = merge(salt, keyHash);

            encrypted = Base64.getEncoder().encodeToString(keyHashWithSalt);
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {

        }

        return encrypted;
    }

    private static byte[] generateRandomSalt()
    {
        byte[] salt = new byte[SALT_LENGTH];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private static byte[] getSaltFromEncryptedPassword(String encryptedPassword)
    {
        return Arrays.copyOf(Base64.getDecoder().decode(encryptedPassword), SALT_LENGTH);
    }

    private static byte[] merge(byte[] salt, byte[] keyHash)
    {
        byte[] saltPlussKeyHash = new byte[SALT_LENGTH + keyHash.length];
        System.arraycopy(salt, 0, saltPlussKeyHash, 0, SALT_LENGTH);
        System.arraycopy(keyHash, 0, saltPlussKeyHash, SALT_LENGTH, keyHash.length);
        return saltPlussKeyHash;
    }
}

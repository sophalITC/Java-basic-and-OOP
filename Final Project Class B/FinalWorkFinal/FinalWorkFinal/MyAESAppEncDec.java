package FinalWorkFinal;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class MyAESAppEncDec {
    private static SecretKeySpec secretkey;
    private static byte[] key;

    public static void setKey(String myKey) {
        try {
            key = myKey.getBytes("UTF-8");
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretkey = new SecretKeySpec(key, "AES");

        }
        catch (NoSuchAlgorithmException e) {    }
        catch (UnsupportedEncodingException e) {    }
    }

    // Encryption
    public static String encrypt(String strToEnc, String sec) {
        try {
            setKey(sec);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretkey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEnc.getBytes("UTF-8")));
        }
        catch (Exception e) {

        }
        return null;
    }

    // Decryption
    public static String decrypt(String strToDec, String sec) {
        try {
            setKey(sec);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretkey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDec)));
        }
        catch (Exception e) {

        }
        return null;
    }
}
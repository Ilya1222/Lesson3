package tasks;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DELL on 12.10.2018.
 */
public class Part4 {

    public static String hash(String string, String code ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance(code);
        messageDigest.update(string.getBytes("UTF-8"));
        String finish = new String(messageDigest.digest());
         return finish;
    }
}

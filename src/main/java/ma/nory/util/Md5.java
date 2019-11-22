package ma.nory.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class Md5 {
	
	private static Logger logger = Logger.getLogger(Md5.class);
	
	public static String encode(String password){
        byte[] uniqueKey = password.getBytes();
        byte[] hash      = null;
        
        try {
            hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
        }
        catch (NoSuchAlgorithmException e) {
        	logger.info("MD5 n'est pas supporté dans cette machine.");
            throw new Error("MD5 n'est pas supporté dans cette machine.");
        }

        StringBuilder hashString = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(hash[i]);
            if (hex.length() == 1) {
                hashString.append('0');
                hashString.append(hex.charAt(hex.length() - 1));
            }
            else
                hashString.append(hex.substring(hex.length() - 2));
        }
        return hashString.toString();
    }
}

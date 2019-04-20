package tw.com.pm.xml.model;
/**
 * 
 */

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;


/**
 * @author timchiang
 * @version
 * 					<li>2010/6/22,Tim, new</li>
 * <ol>
 * <li>加解密碼時使用，在new class時，沒有呼叫CommonEncrypter(String passPharse)建構子和傳入要使用的密碼pharse
 * ，就會使用預設的建構子及密碼pharse
 * </li>
 * </ol>
 *
 */
public class ComEncrypt {
    Cipher ecipher;
    Cipher dcipher;

    /**
     * define passPharse
     */
    private final String userDefinePassPhrase = "userDefined";

    ComEncrypt(){
        // 8-bytes Salt
        byte[] salt = {(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,(byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03};
        // Iteration count
        int iterationCount = 19;
        try {
            KeySpec keySpec = new PBEKeySpec(this.userDefinePassPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
            // Prepare the parameters to the cipthers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
        } catch (InvalidKeySpecException e) {
            System.out.println("EXCEPTION: InvalidKeySpecException");
        } catch (NoSuchPaddingException e) {
            System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }
    
    /**
     * Constructor used to create this object.  Responsible for setting
     * and initializing this object's encrypter and decrypter Chipher instances
     * given a Secret Key and algorithm.
     * @param key        Secret Key used to initialize both the encrypter and
     *                   decrypter instances.
     * @param algorithm  Which algorithm to use for creating the encrypter and
     *                   decrypter instances.
     */
    ComEncrypt(SecretKey key, String algorithm) {
        try {
            ecipher = Cipher.getInstance(algorithm);
            dcipher = Cipher.getInstance(algorithm);
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchPaddingException e) {
            System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }


    /**
     * Constructor used to create this object.  Responsible for setting
     * and initializing this object's encrypter and decrypter Chipher instances
     * given a Pass Phrase and algorithm.
     * @param passPhrase Pass Phrase used to initialize both the encrypter and
     *                   decrypter instances.
     */
    ComEncrypt(String passPhrase) {
        // 8-bytes Salt
        byte[] salt = {(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,(byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03};
        // Iteration count
        int iterationCount = 19;
        try {
            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
            // Prepare the parameters to the cipthers
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        } catch (InvalidAlgorithmParameterException e) {
            System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
        } catch (InvalidKeySpecException e) {
            System.out.println("EXCEPTION: InvalidKeySpecException");
        } catch (NoSuchPaddingException e) {
            System.out.println("EXCEPTION: NoSuchPaddingException");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("EXCEPTION: NoSuchAlgorithmException");
        } catch (InvalidKeyException e) {
            System.out.println("EXCEPTION: InvalidKeyException");
        }
    }


    /**
     * Takes a single String as an argument and returns an Encrypted version
     * of that String.
     * @param str String to be encrypted
     * @return <code>String</code> Encrypted version of the provided String
     */
    public String encrypt(String str) {
        try {
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");
            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);
            // Encode bytes to base64 to get a string
//            return new sun.misc.BASE64Encoder().encode(enc);

            return "";
        } catch (BadPaddingException e) {
        	e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
        	e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        }
        return null;
    }


    /**
     * Takes a encrypted String as an argument, decrypts and returns the 
     * decrypted String.
     * @param str Encrypted String to be decrypted
     * @return <code>String</code> Decrypted version of the provided String
     */
    public String decrypt(String str) {
        try {
            // Decode base64 to get bytes
//            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

          byte[] dec = {1};
            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (BadPaddingException e) {
        	e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
        	e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args){
    	ComEncrypt comEncrypter = new ComEncrypt();
    	String secretCode = "";
    	String comType = "";
    	if(args.length!=0){
    		comType = args[0];
    		secretCode = args[1];
    	}
    	if(comType!=null && comType.startsWith("en")){
            // Encrypt the string
            String desEncrypted = comEncrypter.encrypt(secretCode);
            System.out.println("    Original String  : " + secretCode);
            System.out.println("    Encrypted String : " + desEncrypted);
    	}
    	else if(comType!=null && comType.startsWith("de")){
	        // Decrypt the string
	        String desEncrypted = comEncrypter.decrypt(secretCode);
	        System.out.println("    Original String  : " + secretCode);
	        System.out.println("    Decrypted String : " + desEncrypted);
    	}else{
    		System.out.println("    傳入參數錯誤");
    	}
    	
    }

}

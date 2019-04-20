/**
 * 
 */
package tw.com.pm.xml.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
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
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;


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
public class CommonEncrypter {
    Cipher ecipher;
    Cipher dcipher;

    /**使用者定義passPharse*/
    private final String userDefinePassPhrase = "userDefined";

    CommonEncrypter(){ 
    	Security.insertProviderAt(new com.sun.crypto.provider.SunJCE(),1);
        // 8-bytes Salt
        byte[] salt = {(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,(byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03};
        // Iteration count
        int iterationCount = 19;
        try {
            KeySpec keySpec = new PBEKeySpec(this.userDefinePassPhrase.toCharArray(), salt, iterationCount);
            SecretKeyFactory keyF = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            SecretKey key = keyF.generateSecret(keySpec);
      
            ecipher = Cipher.getInstance("PBEWithMD5AndDES");
            dcipher = Cipher.getInstance("PBEWithMD5AndDES");
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
    CommonEncrypter(SecretKey key, String algorithm) {
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
//    CommonEncrypter(String passPhrase) {
//        // 8-bytes Salt
//        byte[] salt = {(byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,(byte)0x56, (byte)0x34, (byte)0xE3, (byte)0x03};
//        // Iteration count
//        int iterationCount = 19;	
//        try {
//            KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
//            GaiaLog.error(this.getClass(), "FoR TesT::::"+keySpec.toString());
//            SecretKeyFactory keyF = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
//            GaiaLog.error(this.getClass(), "FoR TesT::::"+keyF.toString());
//            SecretKey key = keyF.generateSecret(keySpec);
//            GaiaLog.error(this.getClass(), "FoR TesT::::"+key.toString());
//            ecipher = Cipher.getInstance("PBEWithMD5AndDES");
//            dcipher = Cipher.getInstance("PBEWithMD5AndDES");
//            // Prepare the parameters to the cipthers
//            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
//            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
//            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
//        } catch (InvalidAlgorithmParameterException e) {
//            System.out.println("EXCEPTION: InvalidAlgorithmParameterException");
//            GaiaLog.error(this.getClass(), "EXCEPTION: InvalidAlgorithmParameterException");
//        } catch (InvalidKeySpecException e) {
//            System.out.println("EXCEPTION: InvalidKeySpecException");
//            GaiaLog.error(this.getClass(), "EXCEPTION: InvalidKeySpecException");
//        } catch (NoSuchPaddingException e) {
//            System.out.println("EXCEPTION: NoSuchPaddingException");
//            GaiaLog.error(this.getClass(), "EXCEPTION: NoSuchPaddingException");
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("EXCEPTION: NoSuchAlgorithmException");
//            GaiaLog.error(this.getClass(), "EXCEPTION: NoSuchAlgorithmException");
//            GaiaLog.error(this.getClass(), e);
//        } catch (InvalidKeyException e) {
//            System.out.println("EXCEPTION: InvalidKeyException");
//            GaiaLog.error(this.getClass(), "EXCEPTION: InvalidKeyException");
//        }
//    }


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
//            return new BASE64Encoder().encode(enc);
            return "";
        } catch (BadPaddingException e) {

        } catch (IllegalBlockSizeException e) {
            
        } catch (UnsupportedEncodingException e) {
  
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
    	//fixbug:不可限制加密字串長度,20101220,Update by Minnie
    	//if(str.length()!=24){
    		//GaiaLog.error(this.getClass(), "str-short :"+str);
    		//return str;
    	//}
        try {
            // Decode base64 to get bytes
        	//GaiaLog.error(this.getClass(), "str :"+str);
            byte[] dec = {1};
            
            //GaiaLog.error(this.getClass(), "dec :"+dec);
            if(dec==null){
            
            	return null;
            }
            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);
           
            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (BadPaddingException e) {
       
        } catch (IllegalBlockSizeException e) {
           
        } catch (UnsupportedEncodingException e) {

        } catch (IOException e) {
            
        }
        return null;
    }
    
    public static void main(String[] args){
    	CommonEncrypter comEncrypter = new CommonEncrypter();
    	String secretCode = "murex36";
        // Encrypt the string
        String desEncrypted = comEncrypter.encrypt(secretCode);
        // Decrypt the string
        String desDecrypted = comEncrypter.decrypt(desEncrypted);
        System.out.println("    Original String  : " + secretCode);
        System.out.println("    Encrypted String : " + desEncrypted);
        System.out.println("    Decrypted String : " + desDecrypted);
    }

}

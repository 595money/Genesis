/**
 * 
 */
package tw.com.pm.xml.model;



/**
 * 加密密碼及解密密碼工具
 * @author timchiang
 *	 @version
 *						<li>2010/6/23,Tim, new</li>
 */
public class EncryptionAndDecryptionUtils {
	
	private static CommonEncrypter comEncrypter = new CommonEncrypter();
	
	/**
	 * 加密
	 * @param secretCode 需要加密的字串
	 * @return encryptSecretCode 加密字串
	 */
	public static String encryptPassWord(String secretCode){
		String encryptSecretCode = "";
		try{
			encryptSecretCode = secretCode;
			encryptSecretCode = comEncrypter.encrypt(encryptSecretCode);
		}catch(Exception ex){
			ex.printStackTrace();
	
		}
		return encryptSecretCode;
	}
	
	/**
	 * 解密
	 * @param encryptedSecretCode 需要解密的字串
	 * @return decryptSecretCode 解密字串
	 */
	public static String decryptPassWord(String encryptedSecretCode){
		String decryptSecretCode = "";
		try{
			decryptSecretCode = encryptedSecretCode;
			decryptSecretCode = comEncrypter.decrypt(decryptSecretCode);
		}catch(Exception ex){
			ex.printStackTrace();
	
		}
		return decryptSecretCode;
	}
}

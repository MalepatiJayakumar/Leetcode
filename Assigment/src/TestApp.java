import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

class TestApp {
	public static void main(String[] args) throws Exception {
		// Generate RSA Key Pair
		KeyPair keyPair = generateRSAKeyPair();

		// Get public and private keys
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		// String to be encrypted
		String originalString = "Hello, RSA Encryption!";

		// Encrypt the string
		String encryptedString = encryptRSA(originalString, publicKey);
		System.out.println("Encrypted String: " + encryptedString);

		// Decrypt the string
		String decryptedString = decryptRSA(encryptedString, privateKey);
		System.out.println("Decrypted String: " + decryptedString);
	}

// Generate RSA Key Pair
	private static KeyPair generateRSAKeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048); // You can specify the key size (e.g., 2048 bits)
		return keyPairGenerator.generateKeyPair();
	}

// Encrypt a string using RSA
	private static String encryptRSA(String originalString, PublicKey publicKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);

		byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

// Decrypt a string using RSA
	private static String decryptRSA(String encryptedString, PrivateKey privateKey) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);

		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

		return new String(decryptedBytes);
	}
}
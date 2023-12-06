package com.walmart.Arrays;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSAEncryptionAlgorithm {
	public static void main(String[] args) throws Exception {
		String RSA = "RSA";
		String originalString = "Hello, RSA Encryption!";
		String encryptedString = encryptRSA(originalString, generateRSAKeyPair(RSA).getPublic(), RSA);
		System.out.println("Encrypted String: " + encryptedString);
	}

	private static KeyPair generateRSAKeyPair(String algorithm) throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
		keyPairGenerator.initialize(2048);
		return keyPairGenerator.generateKeyPair();
	}

	private static String encryptRSA(String originalString, PublicKey publicKey, String algorithm) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	private static String decryptRSA(String encryptedString, PrivateKey privateKey, String algorithm) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedString);
		byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
		return new String(decryptedBytes);
	}
}
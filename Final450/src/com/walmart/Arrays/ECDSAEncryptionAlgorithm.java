package com.walmart.Arrays;

import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class ECDSAEncryptionAlgorithm {
	public static void main(String[] args) throws Exception {
		String originalString = "Hello, ECDSA Signing!";
		System.out.println(signECDSA(originalString, generateECDSAKeyPair().getPrivate()));
	}

	private static KeyPair generateECDSAKeyPair() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
		keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
		return keyPairGenerator.generateKeyPair();
	}

	private static String signECDSA(String originalString, PrivateKey privateKey) throws Exception {
		Signature ecdsa = Signature.getInstance("SHA256withECDSA");
		ecdsa.initSign(privateKey);
		ecdsa.update(originalString.getBytes());
		return Base64.getEncoder().encodeToString(ecdsa.sign());
	}
}
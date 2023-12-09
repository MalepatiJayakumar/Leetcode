package com.walmart.Arrays;

import java.security.*;
import java.security.spec.*;
import java.util.Base64;

public class ECDSAEncryptionAlgorithm {
	public static void main(String[] args) throws Exception {
		String originalString = "Hello, ECDSA Signing!";
		
		//ECDSA -256
//		String key = "secp256r1";
//		String instance = "SHA256withECDSA";
		
		//ECDSA - 384
//		String key = "secp384r1";
//		String instance = "SHA384withECDSA";
		
		//ECDSA - 521
		String key = "secp521r1";
		String instance = "SHA512withECDSA";
		
		System.out.println(signECDSA(originalString, generateECDSAKeyPair(key).getPrivate(),instance));
	}

	private static KeyPair generateECDSAKeyPair(String key) throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
		keyPairGenerator.initialize(new ECGenParameterSpec(key));
		return keyPairGenerator.generateKeyPair();
	}

	private static String signECDSA(String originalString, PrivateKey privateKey, String instance) throws Exception {
		Signature ecdsa = Signature.getInstance(instance);
		ecdsa.initSign(privateKey);
		ecdsa.update(originalString.getBytes());
		return Base64.getEncoder().encodeToString(ecdsa.sign());
	}
}
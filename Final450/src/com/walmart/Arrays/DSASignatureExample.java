package com.walmart.Arrays;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

public class DSASignatureExample {

	 public static void main(String[] args) throws Exception {
	        // Generate key pair
	        KeyPair keyPair = generateKeyPair();

	        // Your username
	        String username = "exampleUsername";

	        // Sign the username with the private key
	        byte[] signatureBytes = sign(username, keyPair.getPrivate());

	        // Convert the signature to a string
	        String signatureString = Base64.getEncoder().encodeToString(signatureBytes);

	        // Verify the signature using the public key
	        boolean isValid = verify(username, signatureBytes, keyPair.getPublic());

	        System.out.println("Original Data: " + username);
	        System.out.println("Signature String: " + signatureString);
	        System.out.println("Signature is valid: " + isValid);
	    }

	    private static KeyPair generateKeyPair() throws Exception {
	        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
	        keyPairGenerator.initialize(2048); // Adjust the key size if needed
	        return keyPairGenerator.generateKeyPair();
	    }

	    private static byte[] sign(String data, PrivateKey privateKey) throws Exception {
	        Signature signature = Signature.getInstance("DSA");
	        signature.initSign(privateKey);
	        signature.update(data.getBytes());
	        return signature.sign();
	    }

	    private static boolean verify(String data, byte[] signature, PublicKey publicKey) throws Exception {
	        Signature verifier = Signature.getInstance("DSA");
	        verifier.initVerify(publicKey);
	        verifier.update(data.getBytes());
	        return verifier.verify(signature);
	    }
}
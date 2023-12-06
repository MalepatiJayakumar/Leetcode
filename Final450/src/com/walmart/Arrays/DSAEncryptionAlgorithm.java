package com.walmart.Arrays;

import java.security.*;
import java.util.Base64;

public class DSAEncryptionAlgorithm {

    public static void main(String[] args) throws Exception {
        String encryptedKey = signDSA("Hello, DSA Signing!", generateDSAKeyPair().getPrivate());
        System.out.println("encrypted key with DSA algo :: " + encryptedKey);
    }
    // Generate DSA Key Pair
    private static KeyPair generateDSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(2048); // You can specify the key size
        return keyPairGenerator.generateKeyPair();
    }
    // Sign a string using DSA with SHA-256
    private static String signDSA(String originalString, PrivateKey privateKey) throws Exception {
        Signature dsa = Signature.getInstance("SHA256withDSA");
        dsa.initSign(privateKey);
        dsa.update(originalString.getBytes());
        return Base64.getEncoder().encodeToString(dsa.sign());
    }
}
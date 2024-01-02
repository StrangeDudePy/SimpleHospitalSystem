package com.example.Hospital;

import java.math.BigInteger;


public class RSA {

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;


    // Key generation
    private void generateKeys(int bitLength) {

        // Choose two distinct large random prime numbers, p and q
        BigInteger p = new BigInteger("7238");
        BigInteger q = new BigInteger("8653");

        // Compute n = pq
        modulus = p.multiply(q);

        // Compute the totient (Euler's totient function) phi(n) = (p-1)(q-1)
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        // Choose a public key e such that 1 < e < phi(n) and e is coprime with phi(n)
        publicKey = new BigInteger("65537"); // Common choice for e

        // Compute the private key d such that d ≡ e^(-1) (mod phi(n))
        privateKey = publicKey.modInverse(phi);
    }

    // Encryption
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    // Decryption
    public BigInteger decrypt(BigInteger encryptedMessage) {
        return encryptedMessage.modPow(privateKey, modulus);
    }

}
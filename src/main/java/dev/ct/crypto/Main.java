package dev.ct.crypto;

import dev.ct.crypto.utils.crypto.encryption.Encrypt;
import dev.ct.crypto.utils.crypto.decryption.Decrypt;

public class Main {
    public static void main(String[] args) {
        String content = """
                This is a test string, I use this string to test functionality of encryption and decryption.
                """;
        String key = "This is a key";

        try {
            String encrpytedContent = Encrypt.encrypt(content, key);
            System.out.printf("Encrypted content: %s\n", encrpytedContent);

            String decryptedContent = Decrypt.decrypt(encrpytedContent, key);
            System.out.printf("Decrypted content: %s\n", decryptedContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

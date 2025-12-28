package dev.ct.crypto;

import dev.ct.crypto.utils.crypto.encryption.Encrypt;
import dev.ct.crypto.utils.crypto.decryption.Decrypt;
import dev.ct.crypto.utils.file.FileManager;

public class Main {
    public static void main(String[] args) {
        String key = "This is a key";

        try {
            String content = FileManager.ReadFile("/Users/user/Desktop/Program/Java/Crypto/test_input");

            String encryptedContent = Encrypt.encrypt(content, key);
            System.out.printf("Encrypted content: %s\n", encryptedContent);

            FileManager.WriteFile("/Users/user/Desktop/Program/Java/Crypto/test_output", encryptedContent);
            encryptedContent = FileManager.ReadFile("/Users/user/Desktop/Program/Java/Crypto/test_output");

            String decryptedContent = Decrypt.decrypt(encryptedContent, key);
            System.out.printf("Decrypted content: %s\n", decryptedContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

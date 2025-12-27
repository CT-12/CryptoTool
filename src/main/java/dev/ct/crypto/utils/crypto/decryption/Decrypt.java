package dev.ct.crypto.utils.crypto.decryption;

import javax.crypto.Cipher;               // 加解密的引擎
import javax.crypto.spec.SecretKeySpec;   // 將字串轉為 key object;
import java.util.Base64;                  // 將二進位 byte 轉成文字
import java.nio.charset.StandardCharsets; // 編碼用的

import dev.ct.crypto.utils.crypto.base.CryptoBase;

public class Decrypt extends CryptoBase {

    public static String decrypt(String encryptedContent, String key) throws Exception {
        // Prepare key
        byte[] keyBytes = CryptoBase.prepareKey(key);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, CryptoBase.ALGORITHM);

        // Init cipher
        Cipher cipher = Cipher.getInstance(CryptoBase.ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decode BASE64
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedContent);

        // Decrypt
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}


package dev.ct.crypto.utils.crypto.encryption;

import javax.crypto.Cipher;               // 加解密的引擎
import javax.crypto.spec.SecretKeySpec;   // 將字串轉為 key object;
import java.util.Base64;                  // 將二進位 byte 轉成文字
import java.nio.charset.StandardCharsets; // 編碼用的

import dev.ct.crypto.utils.crypto.base.CryptoBase;

public class Encrypt extends CryptoBase {

    public static String encrypt(String content, String key) throws Exception {
        // Prepare key
        byte[] keyBytes = CryptoBase.prepareKey(key);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, CryptoBase.ALGORITHM);

        // Init Cipher
        Cipher cipher = Cipher.getInstance(CryptoBase.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt: (輸入 String -> 轉 byte[] -> 加密 -> 得到加密後的 byte[])
        byte[] encryptedBytes = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}

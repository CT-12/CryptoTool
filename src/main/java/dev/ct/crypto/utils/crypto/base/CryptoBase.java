package dev.ct.crypto.utils.crypto.base;

import java.nio.charset.StandardCharsets;

public abstract class CryptoBase {

    protected static final String ALGORITHM = "AES";

    // Ensure the length of key is 16 bytes
    protected static byte[] prepareKey(String key) {
        byte[] keyBytes = new byte[16];
        byte[] inputBytes = key.getBytes(StandardCharsets.UTF_8);

        int length = Math.min(inputBytes.length, keyBytes.length);
        System.arraycopy(inputBytes, 0, keyBytes, 0, length);

        return keyBytes;
    }
}

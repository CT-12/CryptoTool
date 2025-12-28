package dev.ct.crypto.utils.file;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileManager {

    public static String ReadFile(String filepath) throws IOException {
        return Files.readString(Paths.get(filepath), StandardCharsets.UTF_8);
    }

    public static void WriteFile(String filepath, String content) throws IOException {
        Files.writeString(Paths.get(filepath), content, StandardCharsets.UTF_8);
    }
}

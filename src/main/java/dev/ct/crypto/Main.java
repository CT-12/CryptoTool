package dev.ct.crypto;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import dev.ct.crypto.utils.crypto.encryption.Encrypt;
import dev.ct.crypto.utils.crypto.decryption.Decrypt;
import dev.ct.crypto.utils.crypto.exception.CryptoException;
import dev.ct.crypto.utils.file.FileManager;
import dev.ct.crypto.utils.view.Layout;

public class Main extends Application {
    public static void main(String[] args) {
        String key = "This is a key";
        launch();
//        try {
//            String content = FileManager.ReadFile("/Users/user/Desktop/Program/Java/Crypto/test_input");
//
//            String encryptedContent = Encrypt.encrypt(content, key);
//            System.out.printf("Encrypted content: %s\n", encryptedContent);
//
//            FileManager.WriteFile("/Users/user/Desktop/Program/Java/Crypto/test_output", encryptedContent);
//            encryptedContent = FileManager.ReadFile("/Users/user/Desktop/Program/Java/Crypto/test_output");
//
//            String decryptedContent = Decrypt.decrypt(encryptedContent, key);
//            System.out.printf("Decrypted content: %s\n", decryptedContent);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (CryptoException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void start(Stage stage) {
        Layout layout = new Layout();
        Scene scene = new Scene(layout.getRoot(), 600, 600);
        stage.setTitle("Crypto");
        stage.setScene(scene);
        stage.show();
    }
}

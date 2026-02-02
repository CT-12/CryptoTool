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

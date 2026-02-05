package dev.ct.crypto;

import dev.ct.crypto.utils.view.Layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


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

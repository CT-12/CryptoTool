package dev.ct.crypto.utils.view;

import java.io.IOException;
import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import dev.ct.crypto.utils.file.FileManager;


public class Layout {
    private final BorderPane root = new BorderPane();
    // Secret key
    private final Label keyLabel = new Label("Key:");
    private final TextField keyInputField = new TextField();
    // Load file
    private final Button loadFileBtn = new Button("Load File");
    // Input content
    private final Label inputContentLabel = new Label("Input content:");
    private final TextArea inputContent = new TextArea();

    public Layout() {
        Node topSection = createTopSection();
        BorderPane.setMargin(topSection, new Insets(0, 0, 20, 0));

        Node centerSection = createCenterSection();

        this.root.setTop(topSection);
        this.root.setCenter(centerSection);

        this.root.setPadding(new Insets(20));
    }

    private Node createTopSection(){
        // Key
        keyInputField.setPromptText("Please input your secret key here");
        HBox keyGroup = new HBox(15, keyLabel, keyInputField);
        keyGroup.setAlignment(Pos.CENTER_LEFT);

        // Load file
        loadFileBtn.setOnAction(e -> handleLoadFile());

        // Add to container
        VBox container = new VBox(20);
        container.getChildren().addAll(keyGroup, loadFileBtn);

        return container;
    }

    private Node createCenterSection() {
        VBox container = new VBox(20);
        VBox.setVgrow(inputContent, Priority.ALWAYS);
        container.getChildren().addAll(inputContentLabel, inputContent);

        return container;
    }

    private void handleLoadFile() {
        FileChooser fc = new FileChooser();

        File selectedFile = fc.showOpenDialog(this.root.getScene().getWindow());
        if (selectedFile != null) {
            try {
                String content = FileManager.ReadFile(selectedFile.getAbsolutePath());
                inputContent.setText(content);

            } catch (IOException exception) {
                inputContent.setText("Load file failed: " + exception.getMessage());
            }
        }
    }

    public BorderPane getRoot() {
        return this.root;
    }

}

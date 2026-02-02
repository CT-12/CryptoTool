package dev.ct.crypto.utils.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

public class Layout {
    private final BorderPane root = new BorderPane();
    // Secret key
    private final Label keyLabel = new Label("Key:");
    private final PasswordField keyInputField = new PasswordField();
    // Input content
    private final Label inputContentLabel = new Label("Input content:");
    private final TextArea inputContentTextArea = new TextArea();
    // Output content
    private final Label outputContentLabel = new Label("Output content:");
    private final TextArea outputContentTextArea = new TextArea();
    // Buttons
    private final Button loadFileBtn = new Button("Load File");
    private final Button encryptBtn = new Button("Encrypt");
    private final Button decryptBtn = new Button("Decrypt");
    private final Button resetBtn = new Button("Reset");
    private final Button copyBtn = new Button("Copy");
    private final Button saveBtn = new Button("Save to file");

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
        HBox keyGroup = new HBox(15, keyLabel, keyInputField);
        keyGroup.setAlignment(Pos.CENTER_LEFT);

        // Buttons
        HBox btnGroup = new HBox(15);
        loadFileBtn.setOnAction(e -> ButtonHandler.handleLoadFile(this.root.getScene().getWindow(), inputContentTextArea));
        encryptBtn.setOnAction(e -> ButtonHandler.handleEncryptAndDecrypt(keyInputField, inputContentTextArea, outputContentTextArea, "Encrypt"));
        decryptBtn.setOnAction(e -> ButtonHandler.handleEncryptAndDecrypt(keyInputField, inputContentTextArea, outputContentTextArea, "Decrypt"));
        resetBtn.setOnAction(e -> ButtonHandler.handleReset(keyInputField, inputContentTextArea, outputContentTextArea));
        btnGroup.getChildren().addAll(loadFileBtn, encryptBtn, decryptBtn, resetBtn);

        // Add to container
        VBox container = new VBox(20);
        container.getChildren().addAll(keyGroup, btnGroup);

        return container;
    }

    private Node createCenterSection() {
        VBox container = new VBox(20);
        VBox.setVgrow(inputContentTextArea, Priority.ALWAYS);
        VBox.setVgrow(outputContentTextArea, Priority.ALWAYS);

        copyBtn.setOnAction(e -> ButtonHandler.handleCopy(outputContentTextArea));
        saveBtn.setOnAction(e -> ButtonHandler.handleSaveFile(this.root.getScene().getWindow(), outputContentTextArea));
        HBox btnGroup = new HBox(15);
        btnGroup.getChildren().addAll(copyBtn, saveBtn);

        container.getChildren().addAll(
                inputContentLabel,
                inputContentTextArea,
                outputContentLabel,
                outputContentTextArea,
                btnGroup
        );

        return container;
    }

    public BorderPane getRoot() {
        return this.root;
    }

}

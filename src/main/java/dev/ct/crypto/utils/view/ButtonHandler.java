package dev.ct.crypto.utils.view;

import dev.ct.crypto.utils.crypto.decryption.Decrypt;
import dev.ct.crypto.utils.crypto.encryption.Encrypt;
import dev.ct.crypto.utils.file.FileManager;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;

public class ButtonHandler {
    static void handleLoadFile(Window window, TextArea input) {
        FileChooser fc = new FileChooser();

        File selectedFile = fc.showOpenDialog(window);
        if (selectedFile != null) {
            try {
                String content = FileManager.ReadFile(selectedFile.getAbsolutePath());
                input.setText(content);

            } catch (IOException exception) {
                input.setText("Load file failed: " + exception.getMessage());
            }
        }
    }

    static void handleSaveFile(Window window, TextInputControl textControl) {
        FileChooser fc = new FileChooser();

        File saveFile = fc.showSaveDialog(window);
        if (saveFile != null) {
            String savePath = saveFile.getAbsolutePath();
            try {
                FileManager.WriteFile(savePath, textControl.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Save file successfully !");
            } catch (IOException exception) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Save file failed: " + exception.getMessage());
                alert.show();
            }
        }
    }

    static void handleEncryptAndDecrypt(PasswordField secretKey, TextArea input, TextArea output, String mode) {
        String content = null;
        switch (mode) {
            case "Encrypt":
                content = Encrypt.encrypt(input.getText(), secretKey.getText());
                break;
            case "Decrypt":
                content = Decrypt.decrypt(input.getText(), secretKey.getText());
                break;
            default:
                throw new IllegalStateException("Unexpected mode: " + mode);
        }
        if (content != null){
            output.setText(content);
        } else {
            output.setText("Content is NULL");
        }
    }

    static void handleReset(TextInputControl... textControls) {
        for (TextInputControl textControl : textControls) {
            textControl.clear();
        }
    }

    static void handleCopy(TextInputControl textControl) {
        String contentToCopy = textControl.getText();
        if (contentToCopy != null && !contentToCopy.isEmpty()) {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString(contentToCopy);
            clipboard.setContent(clipboardContent);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Copy to clipboard successfully !");
            alert.show();
        }
    }
}

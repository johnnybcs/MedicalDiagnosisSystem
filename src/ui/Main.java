package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Root;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new Root().createRoot();
        primaryStage.setTitle("Medical Diagnosis System");
        primaryStage.setScene(new Scene(root, 650, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

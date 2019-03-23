package model;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Root {

    public static final String DOCTOR_NAME = "Doctor:  ";
    public static final String USER_NAME = "You:  ";
    public static final int TEXT_AREA_HEIGHT = 600;
    public static TextArea textArea;
    public static TextField textField;

    public VBox vBox;
    private static String userInput;
    public static int questionNumber;


    private Doctor doctor;

    public Parent createRoot() {
        doctor = new Doctor();
        questionNumber = 0;

        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefHeight(TEXT_AREA_HEIGHT);
        textArea.setWrapText(true);
        textArea.setText(DOCTOR_NAME + "Tell me what I can help you with today.\n");

        textField = new TextField();


        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                    textArea.appendText(USER_NAME + textField.getText() + "\n");
                    userInput = textField.getText().toLowerCase();
                    textField.setText("");

                    ActionListener actionListener = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            doctor.reply(userInput, questionNumber);
                        }
                    };
                    Timer timer = new Timer(850, actionListener);
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });

        vBox = new VBox(textArea, textField);
        VBox vBox = new VBox(textArea, textField);
        vBox.setMargin(textField, new Insets(10, 10, 10, 10));

        return vBox;
    }
}

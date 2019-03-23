package ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Root;

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

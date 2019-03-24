package ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Root;

public class Main extends Application {
private static final int SCENE_WIDTH = 500;
private static final int SCENE_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = new Root().createRoot();
        primaryStage.setTitle("Medical Diagnosis System");
        primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

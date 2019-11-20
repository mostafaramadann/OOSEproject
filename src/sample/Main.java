package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class Main extends Application {
    public static Scene scene;
    public static User u;
    public static Stack<Scene> sceneStack = new Stack<Scene>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setResizable(false);
        primaryStage.setScene(Login.start(primaryStage));
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}

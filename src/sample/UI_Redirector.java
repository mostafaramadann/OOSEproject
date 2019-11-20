package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
public class UI_Redirector  {
    private static Group root = new Group();
    private static Scene Scene = new Scene(root,Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
    private UI_Redirector()
    {

    }
    public static Scene start(Stage primaryStage){

        VBox vBox = new VBox();
        vBox.setSpacing(20);
        Label LastSignin = new Label("Last Sign in by :\n at:");
        Label uioptions = new Label("Department Options");
        Button HRUI = new Button("Human Resources");
        HRUI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(HR_UI.start(primaryStage));
            }
        });
        Button Account_UI = new Button("Account Manager");
        Button CoordinationUI = new Button("Event Management");
        CoordinationUI.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(Coordination_UI.start(primaryStage));
            }
        });
        Button Logistics_Manager = new Button("Logistics Management");
        Button OtherOptions = new Button("Finance");
        OtherOptions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(Finance_UI.start(primaryStage));
            }
        });
        Button Logout_UI= new Button("Logout");
        vBox.getChildren().addAll(uioptions,HRUI,Account_UI,CoordinationUI,Logistics_Manager,OtherOptions,Logout_UI);
        vBox.setLayoutX(20);
        vBox.setLayoutY(Screen.getPrimary().getBounds().getHeight()/64);
        LastSignin.setLayoutX(vBox.getLayoutX()+150);
        LastSignin.setLayoutY(vBox.getLayoutY()+(vBox.getChildren().size()*vBox.getSpacing())/2);
        root.getChildren().addAll(vBox,LastSignin);
        return Scene;
    }
}

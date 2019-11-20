package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.font.TextAttribute;
import java.util.ArrayList;

public class Account_UI {
    private static Group root = new Group();
    private static Scene Scene = new Scene(root, Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
    private Account_UI()
    {

    }
    public static Scene start(Stage primaryStage) {
        Button Back = new Button("Back");
        Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(Main.sceneStack.pop());
            }
        });
        primaryStage.setTitle("Account Control");
        Label Title = new Label("                               Account Control");
        Title.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        VBox vbuttons = new VBox();
        VBox Tfields = new VBox();
        Tfields.setSpacing(25);
        vbuttons.setSpacing(25);
        TextField ChangeUsername = new TextField();
        ChangeUsername.setStyle(Styles.getTfieldStyle());
        TextField re_enterUsername=new TextField();
        re_enterUsername.setStyle(ChangeUsername.getStyle());
        ChangeUsername.setDisable(true);
        re_enterUsername.setDisable(true);
        PasswordField ChangePassword = new PasswordField();
        ChangePassword.setStyle(ChangeUsername.getStyle());
        PasswordField re_enterpassword= new PasswordField();
        re_enterpassword.setStyle(ChangeUsername.getStyle());
        ChangePassword.setDisable(true);
        re_enterpassword.setDisable(true);
        Tfields.getChildren().addAll(ChangeUsername,re_enterUsername,ChangePassword,re_enterpassword);
        Button Editacc = new Button("Edit Account Info");
        VBox labels = new VBox();
        labels.getChildren().addAll(new Label("new Username"),new Label("re-enter Username"),new Label("new Password"),new Label("re-enter Password"));
        labels.setSpacing(65);
        Editacc.setOnAction(new EventHandler<ActionEvent>() {
            boolean verify=true;
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Editacc.getText().equals("Edit Account Info")) {
                    ChangeUsername.setDisable(false);
                    re_enterUsername.setDisable(false);
                    ChangePassword.setDisable(false);
                    re_enterpassword.setDisable(false);
                    Editacc.setText("Submit");
                }
                else
                {

                    Alert D = new Alert(Alert.AlertType.ERROR);
                    if(ChangeUsername.getText().isEmpty()||!ChangeUsername.getText().matches("[\\w(\\.)*]+")||ChangeUsername.getText().length()<6
                            ||!ChangeUsername.getText().equals(re_enterUsername.getText()))
                    {
                        D.setTitle("Username Not Matching Criteria");
                        D.setContentText("Username is empty or less than 6 characters or does not match numerics or alphabetics");
                        verify=false;
                    }
                    if (ChangePassword.getText().isEmpty()||ChangePassword.getText().length()<=7||ChangePassword.getText().matches("(0123456789|123456789|012345678)")
                            ||!ChangePassword.getText().equals(re_enterpassword.getText()))
                    {
                        D.setTitle("Password Not Matching Criteria");
                        D.setContentText("Password is empty or less than 8 characters or does not match numeric or alphabetic");
                        verify=false;
                    }
                    if(!verify)
                    {
                        verify=true;
                        D.show();
                    }
                    else {

                        Saver.GetInstance().UpdateUserProfile(Main.u, ChangeUsername.getText(),ChangePassword.getText());
                    }
                    ChangeUsername.setDisable(true);
                    re_enterUsername.setDisable(true);
                    ChangePassword.setDisable(true);
                    re_enterpassword.setDisable(true);
                    ChangeUsername.clear();
                    re_enterUsername.clear();
                    ChangePassword.clear();
                    re_enterpassword.clear();
                    Editacc.setText("Edit Account Info");
                }
            }
        });
        Button Donate = new Button("Donate");
        Donate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               Donation_UI.start();
               Donation_UI.start().show();
            }
        });
        Editacc.setStyle(Styles.getButtonStyle());
        Button DonationHistory = new Button("Donation History");
        DonationHistory.setStyle(Editacc.getStyle());
        Button Deactivate = new Button("Deactivate Account");
        Deactivate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Saver.GetInstance().DeleteUserProfile(Main.u);
            }
        });
        Deactivate.setStyle(Editacc.getStyle());
        Donate.setStyle(Editacc.getStyle());
        vbuttons.getChildren().addAll(Editacc,Donate,DonationHistory,Deactivate);
        HBox buttons_text = new HBox();
        buttons_text.getChildren().addAll(vbuttons,labels,Tfields);
        VBox Layout = new VBox();
        Layout.getChildren().addAll(Title,buttons_text);
        Layout.setSpacing(50);
        Layout.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-250);
        Layout.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-250);
        buttons_text.setSpacing(75);
        //buttons_text.setLayoutY(200);
        //buttons_text.setLayoutX(200);
        Back.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+150);
        Back.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2);
        Back.setStyle(Editacc.getStyle());
        root.getChildren().addAll(Layout,Back);
        return Scene;
    }


}

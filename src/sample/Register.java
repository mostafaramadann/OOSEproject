package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Register
{
    private static Group root = new Group();
    private static Scene Scene = new Scene(root,Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
    private Register()
    {


    }
    public static Scene start(Stage primaryStage){
        primaryStage.setTitle("Registration_UI");
        primaryStage.setScene(Scene);
        primaryStage.show();
        ScrollPane sp = new ScrollPane();
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Label UserName = new Label("UserName");
        Label Password = new Label("Password");
        Label FirstName = new Label("First Name");
        Label LastName = new Label("Last Name");
        Label Email = new Label("Email");
        Label PostCode = new Label("Post Code");
        Label PhoneNumber = new Label("Phone Number");
        Label BankAccountNo = new Label("Bank Account Number");
        TextField tuser = new TextField();
        tuser.setStyle(Styles.getTfieldStyle());
        tuser.setTooltip(new Tooltip("Username should be any\nalphabetical letter or\nnumber greater in\nlength than 5 "));
        PasswordField tpassword = new PasswordField();
        tpassword.setStyle(tuser.getStyle());
        tpassword.setTooltip(new Tooltip("Password Should be any\nalphabetical letter or\nnumber greater in\nlength than 7"));
        TextField tfirstname = new TextField();
        tfirstname.setStyle(tuser.getStyle());
        tfirstname.setTooltip(new Tooltip("First/last name should\nbe alphabetical and\ndoes not contain\n spaces"));
        TextField tlastname = new TextField();
        tlastname.setStyle(tuser.getStyle());
        tlastname.setTooltip(tfirstname.getTooltip());
        TextField temail= new TextField();
        temail.setStyle(tuser.getStyle());
        TextField tpostcode = new TextField();
        tpostcode.setStyle(tuser.getStyle());
        TextField tphonenumber = new TextField();
        tphonenumber.setStyle(tuser.getStyle());
        TextField tbankacc = new TextField();
        tbankacc.setStyle(tuser.getStyle());
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(UserName,tuser);
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(Password,tpassword);
        HBox hb3= new HBox();
        hb3.getChildren().addAll(FirstName,tfirstname);
        HBox hb4 = new HBox();
        hb4.getChildren().addAll(LastName,tlastname);
        HBox hb6 =new HBox();
        hb6.getChildren().addAll(Email,temail);
        HBox hb7=new HBox();
        hb7.getChildren().addAll(PostCode,tpostcode);
        HBox hb8 = new HBox();
        hb8.getChildren().addAll(PhoneNumber,tphonenumber);
        HBox hb9 = new HBox();
        hb9.getChildren().addAll(BankAccountNo,tbankacc);
        HBox hb12 = new HBox();
        VBox vBox = new VBox();
        hb1.setSpacing(105);
        hb2.setSpacing(110);
        hb3.setSpacing(102);
        hb4.setSpacing(105);
        hb6.setSpacing(135);
        hb7.setSpacing(110);
        hb8.setSpacing(83);
        hb9.setSpacing(45);
        hb12.setSpacing(132);
        Button submit = new Button("submit");
        Label Title = new Label("                RegistrationForm");
        Title.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        vBox.setSpacing(25);
        Title.setLayoutY(50);
        Title.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-150);
        vBox.getChildren().addAll(hb1,hb2,hb3,hb4,hb6,hb7,hb8,hb9,hb12);
        submit.setStyle(Styles.getButtonStyle());
        // vBox.setLayoutX(100);
        //vBox.setLayoutY(80);
        sp.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-150);
        sp.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-250);
        sp.setContent(vBox);
        sp.setPrefHeight(Screen.getPrimary().getBounds().getHeight()/2);
        sp.getContent().setStyle("-fx-background-color: #ffffff;");
        submit.setLayoutX((Screen.getPrimary().getBounds().getWidth()/2-100));
        submit.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+150);
        Button Back = new Button("Back");
        Back.setStyle(submit.getStyle());
        Back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                primaryStage.setScene(Main.sceneStack.pop());
            }
        });
        Back.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2+100);
        Back.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+150);
        root.getChildren().addAll(Title,sp,submit,Back);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            boolean verify=true;
            Alert d = new Alert(Alert.AlertType.ERROR);
            @Override
            public void handle(ActionEvent actionEvent) {
                if(tuser.getText().isEmpty()||!tuser.getText().matches("[\\w(\\.)*]+")||tuser.getText().length()<6)
                {
                    d.setTitle("Username Not Matching Criteria");
                    d.setContentText("Username is empty or less than 6 characters or does not match numerics or alphabetics");
                    verify=false;
                }
                if (tpassword.getText().isEmpty()||tpassword.getText().length()<=7||tpassword.getText().matches("(0123456789|123456789|012345678)"))
                {
                    d.setTitle("Password Not Matching Criteria");
                    d.setContentText("Password is empty or less than 8 characters or is not strong enough");
                    verify=false;
                }
                if(tfirstname.getText().isEmpty()||!tfirstname.getText().matches("^[^\\d\\s]+$")||tlastname.getText().isEmpty()||!tlastname.getText().matches("^[^\\d\\s]+$"))
                {
                    d.setTitle("First/Last Name Not Matching Criteria");
                    d.setContentText("First/Last Name should not be followed by spaces and should not be empty");
                    verify=false;
                }
                if(temail.getText().isEmpty()||!temail.getText().matches("[\\w\\.]+\\@[\\w]+[\\.](com|eg|org|fcih|edu|net)"))
                {
                    d.setTitle("Email Not Matching Criteria");
                    d.setContentText("Email does not match its regular form ex: email@domain.com or empty");
                    verify=false;
                }
                if(tpostcode.getText().isEmpty()||!tpostcode.getText().matches("[0-9]+")||tpostcode.getText().length()<4)
                {
                    d.setTitle("Postal Code Not Matching Criteria");
                    d.setContentText("Post code is empty or is less than five or contains numeric");
                    verify=false;
                }
                if(tbankacc.getText().isEmpty()||tbankacc.getText().length()<10||tbankacc.getText().length()>12||!tbankacc.getText().matches("[0-9]+"))
                {
                    d.setTitle("Invalid Bank Account");
                    d.setContentText("Bank account Number should be 10-12 digits and not empty");
                    verify=false;
                }
                if(tphonenumber.getText().length()==12||!tphonenumber.getText().matches("[0-9]+"))
                {
                    d.setTitle("Phone number Not Matching Criteria");
                    d.setContentText("Phone number is empty or less than 12 numbers or includes alphabetic");
                    verify=false;
                }
                if(!verify)
                {
                    d.show();
                    verify=true;
                }
                else
                {
                    User u = new User();
                    u.setFirstName(tfirstname.getText());
                    u.setLastName(tlastname.getText());
                    u.setUsername(tuser.getText());
                    u.setPassword(tpassword.getText());
                    u.setEmail(temail.getText());
                    u.setPhoneNumber(tphonenumber.getText());
                    u.setBankAccountNo(tbankacc.getText());
                    Saver.GetInstance().AddUserProfile(u);
                    primaryStage.setScene(Login.start(primaryStage));

                }
            }
        });
        return Scene;

    }

}

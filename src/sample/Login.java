package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Login
{
    private static Group root = new Group();
    private static Scene Scene = new Scene(root,Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
    private Login()
    {
    }
    public static Scene start(Stage primaryStage) {
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        MenuBar menubar = new MenuBar();
        Menu menu =new Menu();
        menu.setText("Help");
        MenuItem Help = new MenuItem("Who are us ?");
        menubar.getMenus().add(menu);
        menu.getItems().add(Help);
        Help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        try {
                            Desktop.getDesktop().browse(new URI("http://www.facebook.com"));
                        }
                        catch (IOException e)
                        {e.printStackTrace();}
                    }
                    catch (URISyntaxException e)
                    {e.printStackTrace();}
                }
            }
        });
        Label regglabel = new Label("Don't Have An Account ?");
        regglabel.setTextFill(Paint.valueOf("#b3b3b3"));;
        Label reglabel = new Label(" Register Here");
        reglabel.setTextFill(Paint.valueOf("#4CAF50"));
        reglabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Main.sceneStack.push(Scene);
                primaryStage.setScene(Register.start(primaryStage));
            }
        });
        //Scene.getStylesheets().add("sample/CustomButton.css");
        // root.setId("scene");
        primaryStage.setTitle("Login");
        Label Title = new Label("                          Login");
        Title.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        Label UserName = new Label("Username");
        TextField UserT = new TextField();
        UserT.setStyle(Styles.getTfieldStyle());
        Label log = new Label("");
        UserT.setTooltip(new Tooltip("Enter Your Username Here"));
        HBox user = new HBox();
        user.getChildren().addAll(UserName,UserT);
        user.setSpacing(50);
        Label Password = new Label("Password");
        PasswordField password = new PasswordField();
        password.setStyle(UserT.getStyle());
        password.setTooltip(new Tooltip("Enter Your password here"));
        HBox pass = new HBox();
        pass.getChildren().addAll(Password,password);
        pass.setSpacing(50);
        Button Login = new Button("Login");
        HBox logg = new HBox();
        ProgressBar pBar = new ProgressBar();
        pBar.setVisible(false);
        logg.getChildren().addAll(log,pBar);
        logg.setSpacing(50);
        VBox v = new VBox();
        UserT.setId("input1");
        password.setId("input2");
        HBox labbels = new HBox();
        labbels.getChildren().addAll(regglabel,reglabel);
        v.getChildren().addAll(Title,user,pass,logg,labbels);
        v.setId("form");
        v.setSpacing(50);
        v.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-150);
        v.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-150);
        menubar.setUseSystemMenuBar(true);
        menubar.setPrefWidth(Screen.getPrimary().getBounds().getWidth());
        Login.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2);
        Login.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+100);
        root.getChildren().addAll(menubar,v,Login);
        // Scene.getStylesheets().add("sample/loginstylesheet.css");
        // Login.setId("button");
        Login.setStyle(Styles.getButtonStyle());
        Login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean verify=true;
                Alert d= new Alert(Alert.AlertType.ERROR);
                if(UserT.getText().isEmpty()||!UserT.getText().matches("[\\w(\\.)*]+")||UserT.getText().length()<6)
                {
                    d.setTitle("Username Not Matching Criteria");
                    d.setContentText("Username is empty or less than 6 characters or does not match numerics or alphabetics");
                    verify=false;
                }
                if (password.getText().isEmpty()||password.getText().length()<=7||password.getText().matches("(0123456789|123456789|012345678)"))
                {
                    d.setTitle("Password Not Matching Criteria");
                    d.setContentText("Password is empty or less than 8 characters or does not match numeric or alphabetic");
                    verify=false;
                }
                if(!verify)
                {
                    verify=true;
                    d.show();
                }
                else
                {
                    pBar.setVisible(true);
                    User u=Loader.GetInstance().LoadUserProfileFromDatabase(UserT.getText(),password.getText());
                    if(u==null)
                    {
                        pBar.setVisible(false);
                        log.setText("Login Not Successful");
                    }
                    else
                    {
                        pBar.setVisible(false);
                        log.setText("Login Successful");
                        Main.u = u;
                        Main.sceneStack.push(Scene);
                        //log.setText("");
                        // if() if eno msh user we eno stuff awdeeh lel UIRedirector
                        primaryStage.setScene(Account_UI.start(primaryStage));

                    }
                }
            }
        });
        return Scene;
    }

}

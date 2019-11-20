package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.transform.Templates;

public class PayWithCash implements IPay {

    private static int Cashamount;
    private static final Stage cashDialog = new Stage();
    @Override
    public void Pay() {
        cashDialog.setResizable(false);
        cashDialog.setTitle("Cash Donation");
        HBox text = new HBox();
        Label damount = new Label("Donation Amount");
        TextField donationamount = new TextField();
//        donationamount.setStyle(ChangeUsername.getStyle());
        text.getChildren().addAll(damount,donationamount);
        Image don = new Image("sample/Donate.png");
        ImageView iv = new ImageView(don);
        iv.setFitHeight(50);
        iv.setFitWidth(50);
        Button Donate= new Button("",iv);
        Donate.setStyle(Styles.getButtonStyle());
        HBox hbuttons = new HBox();
        hbuttons.setSpacing(100);
        hbuttons.getChildren().addAll(Donate);
        hbuttons.setLayoutX(220);
        hbuttons.setLayoutY(200);
        VBox v = new VBox();
        v.setSpacing(50);
        v.getChildren().addAll(text,hbuttons);
        Donate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(donationamount.getText().matches("[0-9]+")&&Integer.parseInt(donationamount.getText())>0)
                {
                    Cashamount = Integer.parseInt(donationamount.getText());
                    Saver.GetInstance().UpdateUserTransactions(Main.u,Cashamount,0);
                    System.out.println("Donation successful");
                }
                else {
                    Alert d = new Alert(Alert.AlertType.ERROR);
                    d.setTitle("Donation unsuccessful");
                    d.setContentText("Donation must be a number greater than zero");
                    d.show();
                }
            }
        });
        v.setLayoutY(100);
        v.setLayoutX(100);
        cashDialog.setScene(new Scene(new Group(v,hbuttons),500,300));
    }
    public static Stage GetStage()
    {
        return cashDialog;
    }

    public static int getCashamount() {
        return Cashamount;
    }
}

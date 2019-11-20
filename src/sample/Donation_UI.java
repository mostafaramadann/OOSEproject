package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Donation_UI  {
    private Donation_UI()
    {
        
    }
   private static final Stage Dialog = new Stage();
    public static Stage start() {
        Group root = new Group();
        VBox v = new VBox();
        Dialog.setResizable(false);
       // Dialog.initOwner(Donate.getScene().getWindow());
        Dialog.setTitle("           Donation Options");
        Label l =  new Label("Donation Options");
        l.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        HBox Hbuttons = new HBox();
        Button Cash = new Button("Cash");
        Cash.setStyle(Styles.getButtonStyle());
        Cash.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                IPay cashpayment = new PayWithCash();
                cashpayment.Pay();
                PayWithCash.GetStage().show();
            }
        });
        Button Credit = new Button("Credit");
        Credit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                IPay creditpayment = new PayWithCredit();
                creditpayment.Pay();
                PayWithCredit.GetStage().show();
            }
        });
        Credit.setStyle(Styles.getButtonStyle());
        Hbuttons.getChildren().addAll(Cash,Credit);
        Hbuttons.setSpacing(25);
        v.setSpacing(25);
        v.getChildren().addAll(l,Hbuttons);
        v.setLayoutX(80);
        v.setLayoutY(100);
        root.getChildren().add(v);
        Dialog.setScene(new Scene(root,300,300));
        //Dialog.show();
        return Dialog;
    }
}

package sample;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javax.print.attribute.standard.PagesPerMinute;
import java.util.ArrayList;

public class PayWithCredit implements IPay {

    private String CreditCardno;

    private String CVC;

    private String ExpireMonth;

    private String ExpireYear;
    private static int Donation_Amount;
    private  static Stage CreditDialog = new Stage();

    public static int getDonation_Amount() {
        return Donation_Amount;
    }

    @Override
    public void Pay() {
        CreditDialog.setResizable(false);
        CreditDialog.setTitle("Credit Donation");
        VBox Form = new VBox();
        ArrayList<Label> label = new ArrayList<>();
        ArrayList<HBox> talabels= new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            talabels.add(new HBox());
            talabels.get(i).setSpacing(25);
            label.add(new Label());
        }

        talabels.get(1).setSpacing(45);
        talabels.get(2).setSpacing(75);
        talabels.get(3).setSpacing(15);
        label.get(0).setText("Card Number");
        label.get(1).setText("Expiry Date");
        label.get(2).setText("CVV");
        label.get(3).setText("Name of Holder");
        label.get(4).setText("Donation Amount");
        TextField CardNumber = new TextField();
        talabels.get(0).getChildren().addAll(label.get(0),CardNumber);
        ComboBox Months = new ComboBox();
        Months.setStyle(Styles.getComboboxStyle());
        ComboBox Years = new ComboBox();
        Years.setStyle(Months.getStyle());
        Months.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
        Years.getItems().addAll("2019","2020","2021","2022");
        HBox Date = new HBox();
        Date.setSpacing(10);
        Date.getChildren().addAll(Months,Years);
        talabels.get(1).getChildren().addAll(label.get(1),Date);
        PasswordField CVV = new PasswordField();
        CVV.setStyle(CardNumber.getStyle());
        talabels.get(2).getChildren().addAll(label.get(2),CVV);
        TextField HolderName = new TextField("");
        talabels.get(3).getChildren().addAll(label.get(3),HolderName);
        TextField DonationAmount = new TextField();
        talabels.get(4).getChildren().addAll(label.get(4),DonationAmount);
        talabels.get(4).setSpacing(10);
        ImageView iv = new ImageView(new Image("sample/Donate.png"));
        iv.setFitWidth(50);
        iv.setFitHeight(50);
        Button CreditSubmit = new Button("",iv);
        CreditSubmit.setStyle(Styles.getButtonStyle());
        CreditSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert D = new Alert(Alert.AlertType.NONE);
                if((CVV.getText().length()==3||CVV.getText().length()==4)&&
                (CardNumber.getText().startsWith("4")||CardNumber.getText().startsWith("5")||CardNumber.getText().startsWith("6"))
                &&CardNumber.getText().length()==16&&HolderName.getText().length()>2&&HolderName.getText().matches("[\\w\\s]+")
                &&DonationAmount.getText().matches("[0-9]+")&&Integer.parseInt(DonationAmount.getText())>0)
                {
                    Donation_Amount=Integer.parseInt(DonationAmount.getText());
                    D.setAlertType(Alert.AlertType.INFORMATION);
                    D.setTitle("Donation Successful");
                    D.setHeaderText("Donation Successful");
                    Saver.GetInstance().UpdateUserTransactions(Main.u,Donation_Amount,1);
                    D.setContentText("Operation Complete");
                    D.showAndWait();
                }
                else
                {
                    D.setAlertType(Alert.AlertType.ERROR);
                    D.setTitle("Donation unsuccessful");
                    D.setHeaderText("Donation unsuccessful");
                    D.setContentText("Operation incomplete\n " +
                            "some of the info entered may be wrong or misleading such " +
                            "as credit card starting number or empty inputs");
                    D.showAndWait();
                }
            }
        });
        CreditSubmit.setLayoutX(240);
        CreditSubmit.setLayoutY(290);
        Form.setLayoutX(100);
        Form.setLayoutY(50);
        Form.setSpacing(25);
        Form.setBackground(new Background(new BackgroundFill(Paint.valueOf("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY)));
        Form.getChildren().addAll(talabels);
        CreditDialog.setResizable(false);
        CreditDialog.setScene(new Scene(new Group(Form,CreditSubmit),500,350));
        CreditDialog.getScene().heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Form.setLayoutY(CreditDialog.getScene().getHeight()/4);
                CreditSubmit.setLayoutY(CreditDialog.getScene().getHeight()/1.2f);
            }
        });
        CreditDialog.getScene().widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                Form.setLayoutX(CreditDialog.getScene().getWidth()/4);
                CreditSubmit.setLayoutX(CreditDialog.getScene().getWidth()/2.0833333f);
            }
        });
        //CreditDialog.show();

    }
    public static Stage GetStage()
    {
        return CreditDialog;
    }
}

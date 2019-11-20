package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Finance_UI implements ManegerialUI {

   private static Group root = new Group();
   private static Scene Scene = new Scene(root,Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
   private Finance_UI()
   {

   }

    public static Scene start(Stage primaryStage){
        //primaryStage.setScene(Scene);
        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();
        VBox vtext= new VBox();
        VBox vlabels = new VBox();
        vtext.setSpacing(20);
        int i=0;
        while (i<3)
        {
            TextField t = new TextField();
            Label l = new Label();
            textFields.add(t);
            vtext.getChildren().add(t);
            labels.add(l);
            vlabels.getChildren().add(l);
            i++;
        }
        vlabels.setSpacing(25);
        vlabels.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-50);
        vlabels.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2+50);
        vtext.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-50);
        vtext.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2+150);
        Button AddB=new Button("Add");
        vtext.getChildren().add(AddB);
        labels.get(0).setText("Asset Name");
        labels.get(1).setText("Price");
        labels.get(2).setText("Quantity");
        TableView table = new TableView();
        table.setPrefWidth(200);
        TableColumn Assets = new TableColumn("Assets");
        TableColumn Price = new TableColumn("Price");
        TableColumn Qty = new TableColumn("Quantity");
        TextField search = new TextField("Search");
        Label fdetails = new Label("Financial Details");
        Assets.setPrefWidth(150);
        Button searchB= new Button("Search");
        Button DeleteB = new Button("Delete");
        Button ModifyB = new Button("Modify");
        HBox hBox= new HBox();
        hBox.getChildren().addAll(search,searchB,DeleteB,ModifyB);
        table.getColumns().addAll(Assets,Price,Qty);
        search.setPrefWidth(200);
        fdetails.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        VBox vBox = new VBox();
        Label title = new Label("Financial Matters");
        title.setFont(Font.font("Times New Roman",FontWeight.BOLD,26));
        title.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-50);
        title.setLayoutY(10);
        vBox.getChildren().addAll(fdetails,table,hBox);
        vBox.setLayoutX(Screen.getPrimary().getBounds().getWidth()/4-250);
        vBox.setLayoutY(Screen.getPrimary().getBounds().getHeight()/4-50);
        root.getChildren().addAll(vBox,title,vlabels,vtext);
    return Scene;
    }

    @Override
    public String add(int StaffPowerLevel, String ID) {
        return null;
    }

    @Override
    public String delete(int StaffPowerLevel, String ID) {
        return null;
    }

    @Override
    public String modify(int StaffPowerLevel, String ID) {
        return null;
    }
   /* public static void main(String[] args) {
        launch(args);
    }*/
}

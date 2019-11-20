package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ServiceConfigurationError;

public class HR_UI implements ManegerialUI{
    private static Group root = new Group();
    private static Scene Scene = new Scene(root,Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
    private static TableView table = new TableView();
    private HR_UI()
    {

    }
    public static Scene start(Stage primaryStage){
        Label label = new Label("Stuff Details");
        label.setFont(Font.font("Arial", FontWeight.BOLD,20));
        label.setAlignment(Pos.TOP_RIGHT);
        table.setEditable(true);
        TableColumn firstNameCol = new TableColumn("First Name");
        TableColumn lastNameCol = new TableColumn("Last Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn Phone = new TableColumn("Phone");
        TableColumn UserType = new TableColumn("UserType");
        TableColumn ID = new TableColumn("ID");
        TableColumn PowerLevel = new TableColumn("PowerLevel");
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol,Phone,UserType,ID,PowerLevel);
        table.setMaxWidth(645);
        table.setPrefWidth(Screen.getPrimary().getBounds().getWidth()/2);
        VBox vbox = new VBox();
        //vbox.setSpacing(5);
        // vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);
        Group g1 = new Group();
        g1.getChildren().addAll(vbox);
        g1.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-300);
        g1.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-300);
        HBox hbox = new HBox();
        Label hr = new Label("Human Resources UI Manager");
        hbox.getChildren().addAll(hr);
        hr.setFont(Font.font("Arial", FontWeight.BOLD,26));
        hr.setAlignment(Pos.TOP_RIGHT);
        TextField search = new TextField();
        search.setText("Search by ID");
        search.setLayoutX(table.getLayoutX());
        search.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+50);
        search.setPrefWidth(table.getMaxWidth());
        Button Searchb = new Button("Search");
        Button Delete = new Button("Delete");
        Button Modify = new Button("Modify");
        Searchb.setLayoutX(table.getLayoutX()+table.getMaxWidth()-50);
        Delete.setLayoutX(table.getLayoutX()+table.getMaxWidth()-150);
        Modify.setLayoutX(table.getLayoutX()+table.getMaxWidth()-100);
        Searchb.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+50);
        Modify.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+50);
        Delete.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2+50);
        g1.getChildren().add(search);
        g1.getChildren().add(Searchb);
        g1.getChildren().addAll(Delete,Modify);
        Group g2 = new Group();
        g2.getChildren().add(hbox);
        g2.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-150);
        root.getChildren().add(g1);
        root.getChildren().add(g2);
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
}

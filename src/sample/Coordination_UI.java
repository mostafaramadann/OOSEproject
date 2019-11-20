package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Coordination_UI  implements ManegerialUI {
    private static Group root = new Group();
    private static Scene Scene = new Scene(root,Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
    private Coordination_UI()
    {

    }
    public static Scene start(Stage primaryStage) {
        ArrayList<Label> labels = new ArrayList<>();
        ArrayList<TextField> textFields = new ArrayList<>();
//        Group root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Coordination UI");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
        TableView table = new TableView();
        TableColumn EventName=new TableColumn("Event Name");
        TableColumn EventDate=new TableColumn("Event Date");
        TableColumn EventDuration = new TableColumn("Event Duration");
        TableColumn EventShortdesc = new TableColumn("Event Short");
        TableColumn Event_ID = new TableColumn("Event ID");
        VBox vBox = new VBox();
        Label tabeldesc= new Label("Event Details");
        table.getColumns().addAll(Event_ID,EventName,EventDate,EventDuration,EventShortdesc);
        tabeldesc.setAlignment(Pos.TOP_RIGHT);
        table.setEditable(true);
        //table.resizeColumn(EventDuration,25);
        table.setPrefWidth(400);
        //table.setLayoutX((Screen.getPrimary().getBounds().getWidth()/3)*4);
        vBox.getChildren().addAll(tabeldesc,table);
        vBox.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2+200);
        vBox.setLayoutY(Screen.getPrimary().getBounds().getHeight()/2-250);
        int i=0;
        double h=Screen.getPrimary().getBounds().getHeight()/2-200;
        while (i<4)
        {
            Label l= new Label();
            TextField t = new TextField();
            l.setLayoutX(150);
            t.setLayoutX(300);
            l.setLayoutY(h);
            l.setScaleY(1.2);
            l.setScaleX(1.2);
            t.setLayoutY(h);
            labels.add(l);
            textFields.add(t);
            h+=50;
            i++;
        }
        TextArea textArea = new TextArea();
        textArea.setLayoutY(textFields.get(3).getLayoutY()+50);
        textFields.remove(textFields.size()-1);
        DatePicker datePicker = new DatePicker();
        datePicker.setLayoutX(textFields.get(1).getLayoutX());
        datePicker.setLayoutY(textFields.get(1).getLayoutY());
        textFields.remove(1);
        TextField search = new TextField("Event Name");
        labels.get(0).setText("Event Name");
        labels.get(1).setText("Event Date");
        labels.get(2).setText("Event Duration");
        labels.get(3).setText("Event Description");
        labels.get(3).setLayoutX(labels.get(3).getLayoutX());
        vBox.getChildren().add(search);
        textArea.setLayoutX(labels.get(3).getLayoutX()-10);
        i=0;
        while (i<labels.size())
        {
            root.getChildren().addAll(labels.get(i));
            if(i<textFields.size())
                root.getChildren().add(textFields.get(i));
            i++;
        }
        Label title = new Label("Coordination UI Manager");
        title.setLayoutX(Screen.getPrimary().getBounds().getWidth()/2-150);
        //title.setScaleX(2);
        //title.setScaleY(2);
        title.setLayoutY(50);
        title.setFont(Font.font("Times New Roman", FontWeight.BOLD,22));
        Button Submit = new Button("Add Event");
        Button Modify = new Button("Modify");
        Button Delete = new Button("Delete");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(Modify,Delete);
        hBox.setLayoutX(vBox.getLayoutX());
        hBox.setLayoutY(vBox.getLayoutY()+450);
        Modify.setPrefWidth(100);
        Delete.setPrefWidth(100);
        Submit.setLayoutX(textArea.getLayoutX());
        Submit.setLayoutY(textArea.getLayoutY()+200);
        root.getChildren().add(datePicker);
        root.getChildren().add(textArea);
        root.getChildren().add(Submit);
        root.getChildren().add(title);
        root.getChildren().add(vBox);
        root.getChildren().addAll(hBox);
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

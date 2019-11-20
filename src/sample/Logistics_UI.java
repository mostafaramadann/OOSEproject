package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Logistics_UI implements ManegerialUI
{

    private static Group root = new Group();
    private static Scene Scene = new Scene(root, Screen.getPrimary().getBounds().getWidth(), Screen.getPrimary().getBounds().getHeight());
    private Logistics_UI()
    {

    }
    private static Scene start(Stage primaryStage){
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

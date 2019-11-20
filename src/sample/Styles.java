package sample;

import javax.swing.text.Style;

public class Styles
{
    private Styles() {
    }

    private static final String ComboboxStyle = "  -fx-display: inline-block;\n" +
                                                "  -fx-overflow:hidden;\n" +
                                                "  -fx-cursor: pointer;\n" +
                                                "  -fx-text-align: left;\n" +
                                                "  -fx-white-space: nowrap;\n" +
                                                "  -fx-color: #444;\n" +
                                                "  -fx-outline: none;\n" +
                                                "  -fx-background-color: #f2f2f2;\n" +
                                                "  -fx-transition: timing all ease-in-out;";
    private static final String ButtonStyle =   "  -fx-font-family: \"Roboto\", sans-serif;\n" +
                                                "  -fx-text-transform: uppercase;\n" +
                                                "  -fx-outline: 0;\n" +
                                                "  -fx-background-color: #4CAF50;\n" +
                                                "  -fx-color: #FFFFFF;\n" +
                                                "  -fx-cursor: pointer;\n"+
                                                "  -fx-width: 100%;\n"+
                                                "  -fx-border: 0;\n"+
                                                "  -fx-padding: 15px;\n";
    private static final String TfieldStyle=    "  -fx-font-family: \"Roboto\", sans-serif;\n" +
                                                "  -fx-outline: 0;\n" +
                                                "  -fx-background-color: #f2f2f2;\n" +
                                                "  -fx-width: 100%;\n" +
                                                "  -fx-border: 0;\n" +
                                                "  -fx-margin: 0 0 15px;\n" +
                                                "  -fx-padding: 15px;\n" +
                                                "  -fx-box-sizing: border-box;\n" +
                                                "  -fx-font-size: 14px;";

    public static String getButtonStyle() {
        return ButtonStyle;
    }

    public static String getTfieldStyle() {
        return TfieldStyle;
    }

    public static String getComboboxStyle() {
        return ComboboxStyle;
    }
}

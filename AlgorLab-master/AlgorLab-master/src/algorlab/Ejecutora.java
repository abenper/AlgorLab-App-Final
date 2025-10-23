package algorlab;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.*;
import javax.swing.*;
import login.*;

public class Ejecutora {

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");
        try {
            //UIManager.put("Component.arc", 15);
            UIManager.put("Button.arc", 15);
            UIManager.put("TextComponent.arc", 15);
            UIManager.put("ComboBox.arc", 15);
            UIManager.put("ScrollPane.arc", 15);
            UIManager.put("Table.selectionBackground", new Color(115, 174, 213));
            UIManager.put("Table.selectionArc", 10);
            UIManager.put("Table.cellFocusColor", new Color(0, 0, 0, 0));
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        FlatLightLaf.setup();
        Login lg = new Login();
    }
}

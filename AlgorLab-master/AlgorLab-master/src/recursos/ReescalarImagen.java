package recursos;

import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class ReescalarImagen {
    
    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}

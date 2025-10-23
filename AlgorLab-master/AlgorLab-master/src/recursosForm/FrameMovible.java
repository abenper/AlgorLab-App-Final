package recursosForm;

import java.awt.*;
import javax.swing.*;

public class FrameMovible extends JFrame {
    
    @Override
    public Image getIconImage() {
        Image miIcono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/AlgorLogo.png"));
        return miIcono;
    }

    public void hacerMovible(JFrame frame, JComponent componenteArrastre) {
        componenteArrastre.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                xMouse = evt.getX();
                yMouse = evt.getY();
            }
        });

        componenteArrastre.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                frame.setLocation(x - xMouse, y - yMouse);
            }
        });
    }
    private int xMouse, yMouse;
}

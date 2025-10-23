package recursosForm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import recursos.ReescalarImagen;

public class BtnRecursos {

    public static void reescalarIconBtn(JButton btn, ImageIcon icon, int iconSize) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setIcon(ReescalarImagen.resizeIcon(icon, iconSize + 1, iconSize + 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setIcon(ReescalarImagen.resizeIcon(icon, iconSize, iconSize));
            }
        });
    }

    public static void reescalarBtn(JButton btn) {
        Dimension tamaño = btn.getSize();

        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setSize(tamaño.width + 1, tamaño.height + 1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setSize(tamaño.width, tamaño.height);
            }
        });
    }

    public static void cambiarIcono(JButton btn, int iconSize, ImageIcon icono1, ImageIcon icono2) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setIcon(ReescalarImagen.resizeIcon(icono2, iconSize + 1, iconSize + 1));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setIcon(ReescalarImagen.resizeIcon(icono1, iconSize, iconSize));
            }
        });
    }

    public static void cambiarColorBtn(JButton btn, Color color) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(128, 128, 128, 100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(color);
            }
        });
    }

    public static void btnBonito(JButton btn) {
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setOpaque(false);
    }

    public static void toggleBonito(JToggleButton btn) {
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setOpaque(false);
    }

    public static void btnTransparente(JButton btn) {
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
    }
}

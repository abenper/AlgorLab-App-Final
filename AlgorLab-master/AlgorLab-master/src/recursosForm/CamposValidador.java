package recursosForm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class CamposValidador {

    public void validarCampo(JTextComponent campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && campo.getText().trim().equalsIgnoreCase("")) {
                    campo.setBackground(Color.PINK);
                }
                if(!campo.getText().equalsIgnoreCase("")){
                    campo.setBackground(Color.WHITE);
                }
            }
        });
    }

    public void validarEmail(JTextField campo) {
        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                String texto = campo.getText().trim();
                if (texto.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    campo.setBackground(Color.WHITE);
                } else {
                    campo.setBackground(Color.PINK);
                }
            }
        });
    }

    public void soloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '\b') {
                    e.consume();
                }
            }
        });
    }
}

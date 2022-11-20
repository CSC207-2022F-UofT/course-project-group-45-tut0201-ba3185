package UI;

import javax.swing.*;

public class Button extends JButton {

    public Button(int boundX, int boundY, int boundWeight, int boundHeight, String text) {
        this.setBounds(boundX, boundY, boundWeight, boundHeight);
        this.setText(text);
    }
}

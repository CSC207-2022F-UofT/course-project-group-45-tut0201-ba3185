package UI.CamillaPart;

import javax.swing.*;

public class Button {
    JButton button;

    public Button(String userName){
        button = new JButton(userName);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setActionCommand("userInfo");
    }
    public JButton getButton() {
        return button;
    }



}

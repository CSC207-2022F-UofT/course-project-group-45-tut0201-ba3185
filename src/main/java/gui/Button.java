package gui;

import javax.swing.*;

public class Button {
    JButton button;

    /**
     *
     * @param btnName the name of button
     */
    public Button(String btnName){
        button = new JButton(btnName);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setActionCommand("userInfo");
    }

//    public Button(String btnName, ImageIcon imageIcon){
//        button = new JButton(btnName);
//        button.setOpaque(false);
//        button.setContentAreaFilled(false);
//        button.setFocusPainted(false);
//        button.setActionCommand("userInfo");
//    }
    public JButton getButton() {
        return button;
    }



}
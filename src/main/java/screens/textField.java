package screens;

import javax.swing.*;
//it's a tool to create textfield.

public class textField {
    JTextField textField;

    /**
     * Returns class variable textField
     * @return
     */
    public JTextField getTextField() {
        return textField;
    }

    public void createTextField(JPanel jp, int boundX, int boundY, int boundWidth, int boundHeight) {
        textField = new JTextField();
        textField.setBounds(boundX,boundY,boundWidth,boundHeight);
        jp.add(textField);
    }
}

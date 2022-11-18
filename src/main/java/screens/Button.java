package screens;
import javax.swing.*;

public class Button {
    JButton button;

    /**
     * Returns class variable button
     * @return
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Creates a JButton UI component with an image icon
     * @param buttonText
     * @param boundX
     * @param boundY
     * @param boundWidth
     * @param boundHeight
     */
    public void createButtonWithText(String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        button.setBounds(boundX,boundY,boundWidth,boundHeight);
    }
}
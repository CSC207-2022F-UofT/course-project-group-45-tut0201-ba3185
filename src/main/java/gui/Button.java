package gui;

import javax.swing.*;

public class Button extends JButton {

    /**
     * This method generate a button with given text and size.
     * @param boundX the x position of the button
     * @param boundY the y position of the button
     * @param boundWidth the width of the button
     * @param boundHeight the height of the button
     * @param text  the text on the button
     *
     */

    public Button(int boundX, int boundY, int boundWidth, int boundHeight, String text) {
        this.setBounds(boundX, boundY, boundWidth, boundHeight);
        this.setText(text);
    }
}

package gui;

import javax.swing.*;

public class LoginPageUI extends JFrame {
    public static final int PAGE_HEIGHT = 736;
    public static final int PAGE_WIDTH = 414;
    public LoginPageUI() {
        this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
    }
}
